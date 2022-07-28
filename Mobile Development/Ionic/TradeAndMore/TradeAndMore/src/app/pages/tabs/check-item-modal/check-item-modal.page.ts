import { Component, OnInit,Input } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { MyAPIsService } from 'src/app/services/my-apis.service';
import { RequestItemModalPage } from '../request-item-modal/request-item-modal.page';
@Component({
  selector: 'app-check-item-modal',
  templateUrl: './check-item-modal.page.html',
  styleUrls: ['./check-item-modal.page.scss'],
})
export class CheckItemModalPage implements OnInit {


  categories : any =[];
  subcategories : any =[];
  types: any=[];

  category_name:any;
  subcategory_name: any;
  type_name: string;
  id:any;
  constructor(private modalCtrl: ModalController,private service: MyAPIsService) { }
  @Input() item_name: string;
     @Input()  item_id         :number;
     @Input()  user_id         :number;
     @Input()  item_image      :string;
     @Input()  item_category   :number;
     @Input()  item_subcategory:number;
     @Input()  item_description:string;
     @Input()  item_type       :number;
     @Input()  item_price      :number;
     @Input()  date_uploaded   :string;

  ngOnInit() {
    this.getCategories();
    this.id= localStorage.getItem("logged-in-user-id");
  }



  getCategories(){

    this.service.getCategories().subscribe((res:any)=>{
      this.categories=res;
      console.log(" Catagories options SUCCESS",res);

  this.service.getSubCategories(this.item_category).subscribe((res:any)=>{
    this.subcategories=res;
    console.log(" subctagories options SUCCESS",res);
    this.service.getTypes().subscribe((res:any)=>{
      this.types=res;
      console.log(" types options SUCCESS",res);


      for(let cat in this.categories){
        if (this.categories[cat].category_id==this.item_category){
          this.category_name=this.categories[cat].category_name;
        }

      }

      for(let subcat in this.subcategories){
      if (this.subcategories[subcat].subcategory_id==this.item_subcategory){
        this.subcategory_name=this.subcategories[subcat].subcategory_name;
      }

      }


      for(let type in this.types){
        if (this.types[type].type_id==this.item_type){
          this.type_name=this.types[type].type_name;
          console.log(this.type_name);

        }

        }


    },(error:any)=>{
      console.log("types options Error");
    })

  },(error:any)=>{
    console.log("subcategories options Error");
  })
    },(error:any)=>{
      console.log("Categories options Error");
    })
}

async openRequestModal() {
  const modal = await this.modalCtrl.create({
    component:RequestItemModalPage,
    componentProps: {
      'receiver_item_id'       :    this.item_id,
      'receiver_user_id'         :  this.user_id,
  }});

  await modal.present();
}




  dismissModal(){
    this.modalCtrl.dismiss();
}
}
