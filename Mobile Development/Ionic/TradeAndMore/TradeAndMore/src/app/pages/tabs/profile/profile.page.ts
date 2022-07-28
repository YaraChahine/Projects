import { Component, OnInit ,ViewChild} from '@angular/core';
import { MyAPIsService } from 'src/app/services/my-apis.service';
import { Router } from '@angular/router';
import { IonicModule } from '@ionic/angular';
import { ModalController } from '@ionic/angular';
import { AddItemModalPage } from '../add-item-modal/add-item-modal.page';
import { CheckItemModalPage } from '../check-item-modal/check-item-modal.page';



@Component({
  selector: 'app-profile',
  templateUrl: './profile.page.html',
  styleUrls: ['./profile.page.scss'],
})
export class ProfilePage implements OnInit {

  email;
  buttonValue='grid';
  buttonItems: any[]=[];
  user: any = [];
  items : any = [];
  following:any ;
  followers:any;
  following_res:string;
  categories: any={};
  subcategories:any={};
  types:any={};
  reviews : any=[];
  items_counter: any;
  items_counter_res: any;

  constructor(public _apiService: MyAPIsService,private router: Router,
    private modalCtrl: ModalController) {

    this.email=localStorage.getItem("logged-in-email");
    console.log("email="+this.email);

    this.getUserName();    

    this.categories={'1':""}
    var dict = {
      FirstName: "Chris",
      "one": 1,
      1: "some value"
    };

   }

  ngOnInit() {


  this.getUserName();
    this.buttonItems=[
      {value:'Reviews', icon:'grid'},
      {value:'Items', icon:'film'},
      {value: 'Donations',icon:'images'},
    ];
  }

  ionViewWillEnter(){
    this.getUserName();

    this.getItems();
    this.getItemsCounter();
    this.buttonValue='Items';
  }



  buttonsChanged(event){
    console.log(event.detail.value);
    this.buttonValue= event.detail.value;

    if (this.buttonValue=='Items' || this.buttonValue=='Donations' ){

      this._apiService.getItems(localStorage.getItem("logged-in-user-id")).subscribe((res:any)=>{
        this.items=res;
        console.log("SUCCESS",res);
        console.log("items array",this.items.length);
      },(error:any)=>{
        console.log("Error",error);
      })
    }

    if (this.buttonValue=='Reviews'){
      this.getReviews();
    }

  }

  getUserName(){
    this._apiService.getUserName(this.email).subscribe((res:any)=>{

      this.user=res;
      localStorage.setItem("logged-in-user-id",this.user.user_id);

      console.log("SUCCESS");
      this.getReviews();

      this.getFollowing();
      this.getFollowers();
      this.getItemsCounter();
  
    },(error:any)=>{
      console.log("Error");
    })
  }


  getFollowing(){

    console.log("USER ID IS: " +localStorage.getItem("logged-in-user-id"));
    this._apiService.getFollowing(localStorage.getItem("logged-in-user-id")).subscribe((res:any)=>{
      this.following_res=JSON.stringify(res);
      this.following=res["count(followedby)"];
      console.log("following: "+ this.following);
      console.log(" FOLLOWING SUCCES",res);
    },(error:any)=>{
      console.log("FOLLOWING Error");
    })
  }

  getItemsCounter(){

    this._apiService.getItemsCounter(localStorage.getItem("logged-in-user-id")).subscribe((res:any)=>{
      this.items_counter_res=JSON.stringify(res);
      this.items_counter=res["count(item_id)"];
      console.log(" counter SUCCES",res);
    },(error:any)=>{
      console.log("counter Error",error);
    })
  }

  getFollowers(){
    this._apiService.getFollowers(localStorage.getItem("logged-in-user-id")).subscribe((res:any)=>{

      this.followers=res["count(follows)"];
      console.log("followers: "+ this.followers);
      console.log(" followers SUCCESS",res);
    },(error:any)=>{
      console.log("followers Error");
    })
  }

  
  getReviews(){
    this._apiService.getReviews(localStorage.getItem("logged-in-user-id")).subscribe((res:any)=>{

      this.reviews=res;
      console.log(" reviews SUCCESS",res);
    },(error:any)=>{
      console.log("reviews Error");
    })
  }

  public goToFollowers(){

    this.router.navigate(['followers']);
}
public goToFollowing(){

  this.router.navigate(['following']);
}

public goToSettings(){

  this.router.navigate(['settings']);
}
async openModal(){
  const modal = await this.modalCtrl.create({
    component: AddItemModalPage

  });


  await modal.present();

  const { data } = await modal.onDidDismiss();
  console.log(data);
  if (data['dimissed']==true){
    this.getItems();
  }
}

public goTo(email : any,id : any){
  console.log("Where is the email  ? :O", email);
  console.log("Where is the id  ? :O", id);
  this.router.navigate(['check-profile', JSON.stringify(email),JSON.stringify(id)]);

}

removeItem(item){
  this._apiService.removeItem(item.item_id).subscribe((res:any)=>{


    console.log(" remove SUCCESS",res);
this.getItems();


  },(error:any)=>{
    console.log("remove Error");
  })
}


getItems(){
this._apiService.getItems(localStorage.getItem("logged-in-user-id")).subscribe((res:any)=>{
  this.items=res;
  console.log("SUCCESS",res);
  console.log("items array",this.items.length);
},(error:any)=>{
  console.log("Error",error);
})
}
async openItemModal(item){
  const modal = await this.modalCtrl.create({
    component: CheckItemModalPage,

    componentProps: {
      'item_name'       :         item.item_name,
      'item_id'         :           item.item_id,
      'user_id'         :           item.user_id,
      'item_image'      :        item.item_image,
      'item_category'   :     item.item_category,
      'item_subcategory':  item.item_subcategory,
      'item_description':  item.item_description,
      'item_type'       :         item.item_type,
       'item_price'     :       item.item_price,
       'date_uploaded'  :    item.date_uploaded,
    }
  });

  await modal.present();
}

}
