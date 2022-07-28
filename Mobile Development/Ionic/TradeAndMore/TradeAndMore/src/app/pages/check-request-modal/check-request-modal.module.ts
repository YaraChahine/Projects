import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { CheckRequestModalPageRoutingModule } from './check-request-modal-routing.module';

import { CheckRequestModalPage } from './check-request-modal.page';
import { ReviewAcceptModalPage } from '../review-accept-modal/review-accept-modal.page';
@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    CheckRequestModalPageRoutingModule
  ],
  declarations: [CheckRequestModalPage,ReviewAcceptModalPage],
  entryComponents : [ReviewAcceptModalPage]
})
export class CheckRequestModalPageModule {}
