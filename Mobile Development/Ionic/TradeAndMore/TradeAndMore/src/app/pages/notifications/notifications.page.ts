import { Component, OnInit } from '@angular/core';
import { MyAPIsService } from 'src/app/services/my-apis.service';
import { Router } from '@angular/router';
import { ModalController } from '@ionic/angular';
import { CheckRequestModalPage } from '../check-request-modal/check-request-modal.page';
import { ReviewAcceptModalPage } from '../review-accept-modal/review-accept-modal.page';
import { ToastController } from '@ionic/angular';
import { CheckBidModalPage } from '../tabs/check-bid-modal/check-bid-modal.page';

@Component({
  selector: 'app-notifications',
  templateUrl: './notifications.page.html',
  styleUrls: ['./notifications.page.scss'],
})
export class NotificationsPage implements OnInit {


  requests: any = [];
  items: any = [];
  buttonValue = 'Received';
  buttonItems: any[] = [];
  sent_requests: any = [];
  request:any=[];
  bids:any=[];
  completed_bids: any = [];
  constructor(public  toastController: ToastController,private modalCtrl: ModalController,public _apiService: MyAPIsService,private router: Router) { }

  ngOnInit() {
    this.getRequests();
    this.getSentRequests();
    this.getItems();
    this.getCompletedBids();
    this.buttonItems = [
      { value: 'Received', icon: 'grid' },
      { value: 'Sent', icon: 'film' },
    ];



  }
  ionViewWillEnter(){
    this.getRequests();
    this.getSentRequests();
    this.getItems();
    this.buttonValue='Received';
  }


  



  public goTo(email : any,id : any){
    console.log("Where is the email  ? :O", email);
    console.log("Where is the id  ? :O", id);

    this.router.navigate(['check-profile', JSON.stringify(email),JSON.stringify(id)]);

  }
  getRequests() {


    this._apiService.getRequests(localStorage.getItem("logged-in-user-id")).subscribe((res: any) => {
      this.requests = res;

      console.log(" REQUESTs SUCCES", res);
    }, (error: any) => {
      console.log("REQUESTS Error");
    })


  }
  back() {
    this.router.navigate(['tabs/home']);

  }
  getSentRequests() {


    this._apiService.getSentRequests(localStorage.getItem("logged-in-user-id")).subscribe((res: any) => {


      this.sent_requests = res;

      console.log(" REQUESTs SUCCES", res);
    }, (error: any) => {
      console.log("REQUESTS Error", error);
    })


  }

  buttonsChanged(event) {
    console.log(event.detail.value);
    this.buttonValue = event.detail.value;


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

  getCompletedBids(){
    console.log("???????", localStorage.getItem("logged-in-user-id"));

    this._apiService.getCompletedBids(localStorage.getItem("logged-in-user-id")).subscribe((res: any) => {


      this.completed_bids = res;
      console.log("completed_bids array", this.completed_bids);

      console.log(" bids SUCCES", res);
    }, (error: any) => {
      console.log("bids Error", error);
    })
  }

  async hey(id){
    const modal = await this.modalCtrl.create({
      component: CheckRequestModalPage,
      componentProps: {
          "request_id" : id
      }

    });

   
    await modal.present();

    const { data } = await modal.onDidDismiss();
    console.log(data);
    if (data['dimissed']==true){
      this.getRequests();
    }
  }


getRequestFromId(id){
  console.log(id);

  for ( let request in this.requests) {
    console.log(this.requests[request].pending_request_id);
    if (this.requests[request].pending_request_id==id){
      this.request=this.requests[request];
    }
  }
}

  async openReviewModal(request){
    if(request.review_written==0){
    console.log(request);

    const modal = await this.modalCtrl.create({
      component: ReviewAcceptModalPage,
      componentProps: {
          "request":request,
          "items":this.items
      }

    });


    await modal.present();
  }
  else{
    console.log("You can only write a review once!");
    const toast = await this.toastController.create({
      message: 'You can only write a review once!',
      duration: 2000,
      color:"new"
    });
    toast.present();

  }


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
