import { NgStyle } from '@angular/common';
import { Component, OnInit,Input } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { MyAPIsService } from 'src/app/services/my-apis.service';
@Component({
  selector: 'app-request-bid-modal',
  templateUrl: './request-bid-modal.page.html',
  styleUrls: ['./request-bid-modal.page.scss'],
})
export class RequestBidModalPage implements OnInit {

@Input()  receiver_item_id         :number;
  @Input()  receiver_user_id         :number;
  receiver_item: any;
  item_received: any;
  request_type: string;
  requested_item_price: any;
  items : any=[];
  item_name: string;
  item_result : any;
  selected_item:any;
  text_message : string;
  user_info:any[];
  user_info_received:any;
  constructor(public _apiService: MyAPIsService,private modalCtrl: ModalController) {
    this.item_received=0;
    this.user_info_received=0;
this.item_result=0;
   }

  ngOnInit() {
    this.getItem();
   this.getItems();
   this.getUserInfo();
  }

  selectedType($event){
    for (let item in this.items)
      if( $event.target.value==this.items[item].item_name){
        this.selected_item=this.items[item];
        this.item_result=1;
        console.log("selected item is");
        console.log(this.selected_item);
      }


  }
  getItems(){
    this._apiService.getItems(localStorage.getItem("logged-in-user-id")).subscribe((res:any)=>{
      this.items=res;
      console.log("SUCCESS",res);
      console.log(this.items);

      console.log("items array",this.items.length);
    },(error:any)=>{
      console.log("Error",error);
    })
  }


  sendRequest(){
    console.log(this.receiver_user_id);
    console.log(localStorage.getItem("logged-in-user-id"));
    console.log(this.receiver_item_id);
    console.log(this.text_message);


    if (this.receiver_item[0].item_type==1){

    this._apiService.sendRequest(this.receiver_user_id,this.receiver_item_id,
      localStorage.getItem("logged-in-user-id"),this.selected_item.item_id,this.text_message).subscribe((res:any)=>{
      console.log("SUCCESS send request",res);

    },(error:any)=>{
      console.log("Error send request",error);
    })

  }
  if (this.receiver_item[0].item_type==5){

    this._apiService.sendDonationRequest(this.receiver_user_id,this.receiver_item_id,
      localStorage.getItem("logged-in-user-id"),this.text_message).subscribe((res:any)=>{
      console.log("SUCCESS send request",res);

    },(error:any)=>{
      console.log("Error send request",error);
    })

  }

  else if (this.receiver_item[0].item_type==2){
    this._apiService.sendPurchaseRequest(this.receiver_user_id,this.receiver_item_id,
      localStorage.getItem("logged-in-user-id"),this.text_message).subscribe((res:any)=>{
      console.log("SUCCESS purchase request",res);

    },(error:any)=>{
      console.log("Error pruchase request",error);
    })
  }

  else if (this.receiver_item[0].item_type==3){
    if (this.request_type=='Buy'){
      this._apiService.sendPurchaseRequest(this.receiver_user_id,this.receiver_item_id,
        localStorage.getItem("logged-in-user-id"),this.text_message).subscribe((res:any)=>{
        console.log("SUCCESS purchase request",res);

      },(error:any)=>{
        console.log("Error pruchase request",error);
      })
    }
    else if ( this.request_type=='Trade'){
      this._apiService.sendRequest(this.receiver_user_id,this.receiver_item_id,
        localStorage.getItem("logged-in-user-id"),this.selected_item.item_id,this.text_message).subscribe((res:any)=>{
        console.log("SUCCESS send request",res);

      },(error:any)=>{
        console.log("Error send request",error);
      })

    }

  }



  else if (this.receiver_item[0].item_type==4){
    this._apiService.sendTradeAndPurchaseRequest(this.receiver_user_id,this.receiver_item_id,
      localStorage.getItem("logged-in-user-id"),this.selected_item.item_id,this.requested_item_price,this.text_message).subscribe((res:any)=>{
      console.log("SUCCESS purchase request",res);

    },(error:any)=>{
      console.log("Error pruchase request",error);
    })
  }

  }
  dismissModal(){
    this.modalCtrl.dismiss();
  }



  getItem(){
    this._apiService.getReceiverItem(this.receiver_item_id).subscribe((res:any)=>{
      this.item_received=1;
      this.receiver_item=res;
      console.log("SUCCESS receiverItem",res);

    },(error:any)=>{
      console.log("Error receiverItem",error);
    })
  }

  getUserInfo(){
    this._apiService.getUserInfo(this.receiver_user_id).subscribe((res:any)=>{
      this.user_info=res;
      this.user_info_received=1;
      console.log("SUCCESS userinfo",res);

    },(error:any)=>{
      console.log("Error userinfo",error);
    })
  }
}

