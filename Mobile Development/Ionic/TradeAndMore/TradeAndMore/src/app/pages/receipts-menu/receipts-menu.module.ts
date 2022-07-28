import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ReceiptsMenuPageRoutingModule } from './receipts-menu-routing.module';

import { ReceiptsMenuPage } from './receipts-menu.page';
import { ReceiptModalPage } from '../receipt-modal/receipt-modal.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ReceiptsMenuPageRoutingModule
  ],
  declarations: [ReceiptsMenuPage,ReceiptModalPage],
  entryComponents : [ReceiptModalPage]
})
export class ReceiptsMenuPageModule {}
