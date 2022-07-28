import { Component, OnInit,Input } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { MyAPIsService } from 'src/app/services/my-apis.service';
import { ToastController } from '@ionic/angular';

@Component({
  selector: 'app-review-accept-modal',
  templateUrl: './review-accept-modal.page.html',
  styleUrls: ['./review-accept-modal.page.scss'],
})
export class ReviewAcceptModalPage implements OnInit {
  @Input()  request         :any;
  @Input()  items         :any;
  review: string;
  rating: string;

  user : any=[];
  id:any;
  constructor(public  toastController: ToastController,private modalCtrl: ModalController,public _apiService: MyAPIsService) { }

  ngOnInit() {
this.getUserInfo();
this.id=localStorage.getItem("logged-in-user-id");
  }

getUserInfo(){
  this._apiService.getUserInfo(this.request.receiver_user_id).subscribe((res: any) => {
  this.user=res;
    console.log(" got user info SUCCES", res);

  }, (error: any) => {
    console.log("got user info Error",error);
  })
}


  addFeedback(){
    
    this._apiService.addFeedback(localStorage.getItem("logged-in-user-id"),this.request.sender_user_id,this.review,this.rating,this.request["pending_request_id"]).subscribe(async (res: any) => {

      console.log(" add feedbck SUCCES", res);
      console.log("add feedbck saved", this.request);
      console.log(" REQUESTs SUCCES", res);
      const toast = await this.toastController.create({
        message: 'You have accepted the offer',
        duration: 2000,
        color:"new"
      });
      toast.present();
      this.dismissModal();

    }, (error: any) => {
      console.log("add feedbck Error",error);
    })
  }

  addFeedback2(){
    
    this._apiService.addFeedback2(localStorage.getItem("logged-in-user-id"),this.request.receiver_user_id,this.review,this.rating,this.request["pending_request_id"]).subscribe(async (res: any) => {

      console.log(" add feedbck2 SUCCES", res);
      console.log("add feedbck2 saved", this.request);
      console.log(" REQUESTs SUCCES", res);
      const toast = await this.toastController.create({
        message: 'You have accepted the offer',
        duration: 2000,
        color:"new"
      });
      toast.present();
      this.dismissModal();
    }, (error: any) => {
      console.log("add feedbck2 Error",error);
    })
  }

  dismissModal(){
    this.modalCtrl.dismiss();
}



}
