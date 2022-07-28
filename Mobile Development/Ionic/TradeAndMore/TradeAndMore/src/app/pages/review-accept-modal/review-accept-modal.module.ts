import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ReviewAcceptModalPageRoutingModule } from './review-accept-modal-routing.module';

import { ReviewAcceptModalPage } from './review-accept-modal.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ReviewAcceptModalPageRoutingModule
  ],
  declarations: [ReviewAcceptModalPage]
})
export class ReviewAcceptModalPageModule {}
