import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { RequestBidModalPageRoutingModule } from './request-bid-modal-routing.module';

import { RequestBidModalPage } from './request-bid-modal.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    RequestBidModalPageRoutingModule
  ],
  declarations: [RequestBidModalPage]
})
export class RequestBidModalPageModule {}
