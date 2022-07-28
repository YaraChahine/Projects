import { Component, OnInit } from '@angular/core';
import { MyAPIsService,User } from './../../../services/my-apis.service';
import { Router } from '@angular/router';
import { ModalController } from '@ionic/angular';
import { AddBidModalPage } from '../add-bid-modal/add-bid-modal.page';
import { CheckBidModalPage } from '../check-bid-modal/check-bid-modal.page';

@Component({
  selector: 'app-biddings',
  templateUrl: './biddings.page.html',
  styleUrls: ['./biddings.page.scss'],
})
export class BiddingsPage implements OnInit {
  id:any;
  items: any = [];
  time: any;
  hours: number;
  t: number;
  minutes: number;
  seconds: number;
  item_id: any;
  timeString: any;
  otherItems: any = [];
  count: number;
  myBids: any = [];
  max: any = [];

  constructor(private router: Router,private service: MyAPIsService,private modalCtrl: ModalController) { }

  ngOnInit() {
    this.id=localStorage.getItem("logged-in-user-id");

    this.getMyItemsBid(localStorage.getItem("logged-in-user-id"));
    this.getFollowersItemsBid(localStorage.getItem("logged-in-user-id"));
    this.getMyBids(localStorage.getItem("logged-in-user-id"));

    setInterval(() => {},1000);
  }


  getMyBids(id: any){
    console.log("CHECKKKKKKKKKKKKKKKKKK",this.id);


    this.service.getMyBids(this.id).subscribe((ressss: any)=>{


      this.myBids=ressss;

      console.log("SUCCESSss",this.myBids);
    },(error:any)=>{
      console.log("Error",error);
      console.log("Error", error);
    })//
  }

  getFollowersItemsBid(id: any){
    this.id=localStorage.getItem("logged-in-user-id");
    this.service.getFollowersItemsBid(localStorage.getItem("logged-in-user-id")).subscribe((res: any)=>{
      this.otherItems=res;

      console.log("SUCCESS??!!",this.otherItems);
    },(error:any)=>{
      console.log("Errorrr",error);
    })//
  }
  getMyItemsBid(id: any){
    this.id=localStorage.getItem("logged-in-user-id");
    this.service.getMyItemsBid(localStorage.getItem("logged-in-user-id")).subscribe((res: any)=>{
      this.items=res;

      console.log("SUCCESS",this.items);
    },(error:any)=>{
      console.log("Error",error);
    })
  }

  public updateCountdown(time: any,item_id: any) {
    const splitted1 = time.split(':', 3);
    const splitted2 = splitted1[0].split('-', 3);
    const splitted3 = splitted2[2].split(' ', 2);
    const t1 = new Date(splitted2[0], splitted2[1]-1, splitted3[0], splitted3[1], splitted1[1], splitted1[2], 0);
    const t3 = new Date(t1.getTime()+24*60*60*1000);
    const t5 = new Date(splitted2[0], splitted2[1], splitted3[0], splitted3[1], splitted1[1], splitted1[2], 0);
    const t4 = Date.now();
    const t2 = new Date();
     if(t2<=t3){

    const dif = t5.getTime() - t4;

    const Seconds_from_T1_to_T2 = dif / 1000;
    const Seconds_Between_Dates = Math.abs(Seconds_from_T1_to_T2);

    const date = new Date(0);
    date.setSeconds(Seconds_Between_Dates);
    const timeString = date.toISOString().substr(11, 8);
    return timeString;
     }
    else{

      this.service.deleteBid(item_id).subscribe((result: any)=>{
        console.log("TEST",result);
        console.log("TEST1",item_id);
        this.items=result;
        return;
      },(error:any)=>{
        console.log("Error");
      })
      this.getMyItemsBid(localStorage.getItem("logged-in-user-id"));
      this.getFollowersItemsBid(localStorage.getItem("logged-in-user-id"));
      this.getMyBids(localStorage.getItem("logged-in-user-id"));
      this.service.getMyItemsBid(this.id).subscribe((res: any)=>{
        this.items=res;

      },(error:any)=>{
      })
    }


  }
  async openModal(){
    const modal = await this.modalCtrl.create({
      component: AddBidModalPage

    });

    await modal.present();
  }

  async openItemModal(item){
    const modal = await this.modalCtrl.create({
      component: CheckBidModalPage,

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

