import { Component, OnInit } from '@angular/core';
import { MyAPIsService } from 'src/app/services/my-apis.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { ModalController } from '@ionic/angular';
import { CheckItemModalPage } from '../check-item-modal/check-item-modal.page';

@Component({
  selector: 'app-home',
  templateUrl: './home.page.html',
  styleUrls: ['./home.page.scss'],
})
export class HomePage implements OnInit {


  suggestions : any = [];

  posts : any = [];
  location : any = [];
  id: any;
  email: any;
  
  constructor(public service: MyAPIsService, private modalCtrl: ModalController, private router: Router,private route: ActivatedRoute) {

    }

  ngOnInit() {

    this.getPosts();
    this.getLocation();
  }

openNotifications(){
  this.router.navigate(['notifications']);
}

openReceipts(){
  this.router.navigate(['receipts-menu']);
}
  getPosts(){
    this.service.getFollowingsPosts(localStorage.getItem("logged-in-user-id")).subscribe((res:any)=>{

      this.posts=res;


      console.log("SUCCESS",res);
    },(error:any)=>{
      console.log("Error");
    })
  }
  getLocation(){
    this.service.getLocation(localStorage.getItem("logged-in-user-id")).subscribe((res:any)=>{

      this.location=res;
      console.log(typeof(Object.values(this.location[0])));
      const loc = JSON.stringify(Object.values(this.location[0]));
      const partLoc = loc.substring(2,loc.length-2);
      console.log("SUCCESS",partLoc);

      this.service.getSuggestedUsers(partLoc,localStorage.getItem("logged-in-user-id")).subscribe((ress:any)=>{
        this.suggestions=ress;

        console.log("SUCCESSsss",this.suggestions);
      },(error:any)=>{
        console.log("Error");
      })



      console.log("SUCCESS",res);
    },(error:any)=>{
      console.log("Error");
    })
  }

  public goTo(email : any,id : any){

    this.router.navigate(['check-profile', JSON.stringify(email),JSON.stringify(id)]);

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
