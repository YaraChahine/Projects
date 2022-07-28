import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { BiddingsPageRoutingModule } from './biddings-routing.module';

import { BiddingsPage } from './biddings.page';
import { AddBidModalPage } from '../add-bid-modal/add-bid-modal.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    BiddingsPageRoutingModule
  ],
  declarations: [BiddingsPage, AddBidModalPage],
  entryComponents: [AddBidModalPage]
})
export class BiddingsPageModule {}
