import { Component, OnInit, ViewChild,ElementRef } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { MyAPIsService } from 'src/app/services/my-apis.service';
import { HttpClient} from '@angular/common/http';
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { ToastController } from '@ionic/angular';


@Component({
  selector: 'app-add-item-modal',
  templateUrl: './add-item-modal.page.html',
  styleUrls: ['./add-item-modal.page.scss'],
})
export class AddItemModalPage implements OnInit {


  categories : any=[];
  subcategories : any=[];
  images : any=[];
  types : any=[];
  type_result : any;
  selected_category_id: any;
  selected_subcategory_id : any;
  image: any;
  ionicForm: FormGroup;
  user_id : any;


  type_id:any;
  item_name: string;
  item_image: string;
  item_category_name: string;
  item_subcategory_name: string;
  item_description: string;
  item_type: string;
  item_price: number;



  item_img_file:any;


  constructor(public  toastController: ToastController,private modalCtrl: ModalController,private service: MyAPIsService, private http : HttpClient) {

  }

  ngOnInit() {
    this.item_price=0;
    this.getCategories();
    this.getTypes();

  }

  selectedFile($event){
    this.image = $event.target.files[0];
  }



 
  getCategories(){

    this.service.getCategories().subscribe((res:any)=>{
      this.categories=res;
      console.log(" Catagories options SUCCESS",res);

    },(error:any)=>{
      console.log("Categories options Error");
    })
}


getTypes(){

  this.service.getTypes().subscribe((res:any)=>{
    this.types=res;
    console.log(" types options SUCCESS",res);

  },(error:any)=>{
    console.log("types options Error");
  })
}



getSubCategories($event) {
  console.log($event.target.value);
  for(let cat in this.categories){
    if (this.categories[cat].category_name==$event.target.value){
      this.selected_category_id=this.categories[cat].category_id;
    }

 }
  this.service.getSubCategories(this.selected_category_id).subscribe((res:any)=>{
    this.subcategories=res;
    console.log(" subctagories options SUCCESS",res);
  },(error:any)=>{
    console.log("subcategories options Error");
  })
}


selectedType($event){
  this.item_type=$event.target.value;
  if ($event.target.value!="Trade"&&$event.target.value!="Donation"){
    this.type_result=1;
  }
  else{
    this.item_price=0;

    this.type_result=0;

  }
}



async  onSubmit(){


  this.user_id=localStorage.getItem("logged-in-user-id");

  const formData = new FormData();
  formData.append('img_file',this.image);
  this.http.post('http://localhost/capstone_apis/postImageResults.php',formData).subscribe((res:any)=>{

    console.log("SUCCESS=", res);
    this.item_img_file=res['path'];
    console.log("item img", this.item_img_file);
    for(let subcat in this.subcategories){

   if ( this.subcategories[subcat].subcategory_name==this.item_subcategory_name){
    this.selected_subcategory_id=this.subcategories[subcat].subcategory_id;

   }

    }


    for(let type in this.types){
      if (this.types[type].type_name==this.item_type){
        this.type_id=this.types[type].type_id;
        console.log("hellloo");
        console.log(this.type_id);
      }

   }

    let data= {
      item_name:            this.item_name   ,
      item_image:           this.item_img_file         ,
      item_category_name:   this.selected_category_id ,
      item_subcategory_name:this.selected_subcategory_id,
      item_description:     this.item_description     ,
      item_type:            this.type_id     ,
      item_price:           this.item_price,

    }

    console.log("categories");
    console.log(this.item_category_name);

    this.service.addItem(data,this.user_id).subscribe(async (ress:any)=>{
      console.log("check cat" + data.item_category_name);
      console.log("check subcat" + data.item_subcategory_name);

      console.log("SUCCESS=", ress);
      const toast = await this.toastController.create({
        message: 'Your item has been added succesfully!',
        duration: 2000,
        color:"new"
      });
      toast.present();
      this.modalCtrl.dismiss({
        'dismissed': true
      });

    },(error:any)=>{
      console.log("ERROR=", error);
    });


  },(error:any)=>{
    console.log("ERROR=", error);


    })




}




  dismissModal(){
      this.modalCtrl.dismiss();
  }
}
