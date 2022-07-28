import { Component, OnInit,Input } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { MyAPIsService } from 'src/app/services/my-apis.service';
import { ReviewAcceptModalPage } from '../review-accept-modal/review-accept-modal.page';
import { ToastController } from '@ionic/angular';

@Component({
  selector: 'app-check-request-modal',
  templateUrl: './check-request-modal.page.html',
  styleUrls: ['./check-request-modal.page.scss'],
})
export class CheckRequestModalPage implements OnInit {
  @Input()  request_id         :number;

requests: any=[];
  items:any=[];
  request:any;
  request_received:number;
  constructor(public  toastController: ToastController,private modalCtrl: ModalController,public _apiService: MyAPIsService,private service: MyAPIsService) { }

  ngOnInit() {
    this.getRequests();
    this.getItems();
    this.request_received=0;
  }

  getRequests() {


    this._apiService.getRequests(localStorage.getItem("logged-in-user-id")).subscribe(async (res: any) => {
      this.requests = res;
      
      for ( let request in this.requests) {
        if (this.requests[request].pending_request_id==this.request_id){
          this.request=this.requests[request];
          this.request_received=1;
        }
      }
  
      console.log("request saved", this.request);

    }, (error: any) => {
      console.log("REQUESTS Error");
    })


  }


  getItems() {

    this._apiService.getItems(localStorage.getItem("logged-in-user-id")).subscribe((res: any) => {
      this.items = res;
     
      console.log("SUCCESS items", res);
      console.log("items array", this.items);
    }, (error: any) => {
      console.log("Error items", error);
    })
  }


  RejectOffer(){
    this._apiService.RejectOffer(this.request_id).subscribe(async (res: any) => {

     
      console.log("SUCCESS reject", res);
      const toast = await this.toastController.create({
        message: 'Offer has been rejected',
        duration: 2000,
        color:"new"
      });
      toast.present();
      this.dismissModal();

   }, (error: any) => {
      console.log("Error rejecy", error);
    })
  }
  dismissModal(){
    let data=true;
    this.modalCtrl.dismiss({
      'dismissed': true
    });
}

async openReviewModal(){
  const modal = await this.modalCtrl.create({
    component: ReviewAcceptModalPage,
    componentProps: {
        "request":this.request,
        "items":this.items
    }

  });

  await modal.present();
}
}
