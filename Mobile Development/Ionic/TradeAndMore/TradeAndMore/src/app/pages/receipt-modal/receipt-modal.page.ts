import { Component, OnInit, Input } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { MyAPIsService } from 'src/app/services/my-apis.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-receipt-modal',
  templateUrl: './receipt-modal.page.html',
  styleUrls: ['./receipt-modal.page.scss'],
})
export class ReceiptModalPage implements OnInit {
  @Input()  receipt         :any;

  constructor(private modalCtrl: ModalController,private router: Router,public _apiService: MyAPIsService,) { }

  ngOnInit() {
  }

  public goTo(email : any,id : any){
    console.log("Where is the email  ? :O", email);
    console.log("Where is the id  ? :O", id);
    if (id=localStorage.getItem("logged-in-user-id")){
      this.goToProfile();
    }
    else{
    this.router.navigate(['check-profile', JSON.stringify(email),JSON.stringify(id)]);
    }
  }

  public goToProfile(){

    this.router.navigate(['tabs/profile']);
}


  dismissModal(){
    this.modalCtrl.dismiss();
}


}
