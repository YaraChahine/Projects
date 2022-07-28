import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ReceiptModalPageRoutingModule } from './receipt-modal-routing.module';

import { ReceiptModalPage } from './receipt-modal.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ReceiptModalPageRoutingModule
  ],
  declarations: [ReceiptModalPage]
})
export class ReceiptModalPageModule {}
