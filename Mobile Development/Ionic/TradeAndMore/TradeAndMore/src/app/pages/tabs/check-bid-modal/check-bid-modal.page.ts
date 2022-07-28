import { Component, Input, OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { MyAPIsService } from 'src/app/services/my-apis.service';
import { RequestItemModalPage } from '../request-item-modal/request-item-modal.page';
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { Router } from '@angular/router';

@Component({
  selector: 'app-check-bid-modal',
  templateUrl: './check-bid-modal.page.html',
  styleUrls: ['./check-bid-modal.page.scss'],
})
export class CheckBidModalPage implements OnInit {
  isSubmitted = false;
  ionicForm: FormGroup;
  categories : any =[];
  subcategories : any =[];
  types: any=[];
  id: any;
  category_name:any;
  subcategory_name: any;
  type_name: string;
  price: number;
  item: any = [];
  count: number;
  bids: any = [];
  users: any = [];

  constructor(private router: Router,private modalCtrl: ModalController,private service: MyAPIsService,public formBuilder: FormBuilder) { }
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
    this.getPrice();
    this.getLastBids();
    this.getItem();
    this.id=parseInt(localStorage.getItem("logged-in-user-id"), 10);
    console.log("id " + this.id + "user id" + this.user_id + "type 1 " + typeof(this.id) + "type 2" + typeof(this.user_id))
    this.getCategories();
      this.ionicForm = this.formBuilder.group({
      Price: ['', [Validators.required]],
    })
  }
  get errorControl() {
    return this.ionicForm.controls;
  }
  getPrice(){
    console.log(this.item_id);
      this.service.getBidsCount(this.item_id).subscribe((res:any)=>{
      this.item=res;
      this.count = this.item.count;
      console.log("price2" + this.item);
      console.log("my count" + this.count);

      console.log("SUCCESS");
      if(this.count===0){
        this.price = this.item_price;
        this.ionicForm.controls.Price.addValidators(Validators.min(this.price+1));
        console.log("COUNT 0 PRICE" + this.price);
      }else{
        this.service.getLastBid(this.item_id).subscribe((res:any)=>{
          this.item=res;
          this.price = this.item.item_price;
          this.ionicForm.controls.Price.addValidators(Validators.min(this.price+1));
          console.log("COUNT >0 PRICE" + this.price);


          console.log("SUCCESS");
        },(error:any)=>{
          console.log("Errorrrrr",error);
        })
      }
    },(error:any)=>{
      console.log("Errorrrrr");
    })
  }
  getItem(){
    console.log(this.item_id);
      this.service.getItem(this.item_id).subscribe((res:any)=>{
      this.users=res;
      console.log("price2223142" + this.users);

    },(error:any)=>{
      console.log("Errorrrrr",error);
    })
  }

  getLastBids(){
    console.log(this.item_id);
      this.service.getLastBids(this.item_id).subscribe((res:any)=>{
      this.bids=res;
      console.log("price222" + this.bids);

    },(error:any)=>{
      console.log("Errorrrrr",error);
    })
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
public onSubmit(){
  this.isSubmitted = true;
  this.id=localStorage.getItem("logged-in-user-id");
  if(!this.ionicForm.valid){
    console.log('Please provide all the required values!');
      return false;
  }else{
    const item = this.ionicForm.value;
    console.log(item);
    console.log(this.id);
    console.log(this.item_id);

    this.service.postBid(item,this.id,this.item_id).subscribe(response => {
      if(response==null){
        console.log("SUCCESS");
        this.modalCtrl.dismiss();

      }
      else{
        console.log("ERROR");
      }
  });
  }
}
}

