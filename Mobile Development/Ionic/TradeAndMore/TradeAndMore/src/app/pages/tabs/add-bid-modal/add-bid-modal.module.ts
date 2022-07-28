import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { AddBidModalPageRoutingModule } from './add-bid-modal-routing.module';

import { AddBidModalPage } from './add-bid-modal.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    AddBidModalPageRoutingModule
  ],
  declarations: [AddBidModalPage]
})
export class AddBidModalPageModule {}
