import { Component, OnInit } from '@angular/core';
import { MyAPIsService } from 'src/app/services/my-apis.service';
import { Router } from '@angular/router';
import { ModalController } from '@ionic/angular';
import { ReceiptModalPage } from '../receipt-modal/receipt-modal.page';
@Component({
  selector: 'app-receipts-menu',
  templateUrl: './receipts-menu.page.html',
  styleUrls: ['./receipts-menu.page.scss'],
})
export class ReceiptsMenuPage implements OnInit {

  receipts: any=[];
  logged_in_id : any;
  constructor(private modalCtrl: ModalController,public _apiService: MyAPIsService,private router: Router) { }

  ngOnInit() {
    this.getReceipts();
    this.logged_in_id=localStorage.getItem("logged-in-user-id");
  }

  back() {
    this.router.navigate(['tabs/home']);

  }


  getReceipts(){
    this._apiService.getReceipts(localStorage.getItem("logged-in-user-id")).subscribe((res: any) => {
      this.receipts = res;
      
      console.log(" receipts SUCCES", res);
    }, (error: any) => {
      console.log("receipts Error",error);
    })
  }

  async openReceiptModal(receipt){
    console.log(receipt);

    const modal = await this.modalCtrl.create({
      component: ReceiptModalPage,
      componentProps: {
          "receipt":receipt,
      
      }
  
    });
  
    await modal.present();
  
}

}