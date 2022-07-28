import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { CheckBidModalPageRoutingModule } from './check-bid-modal-routing.module';

import { CheckBidModalPage } from './check-bid-modal.page';
import { RequestBidModalPage } from '../request-bid-modal/request-bid-modal.page';
import {ReactiveFormsModule} from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    CheckBidModalPageRoutingModule,
    ReactiveFormsModule

  ],
  declarations: [CheckBidModalPage, RequestBidModalPage],
  entryComponents : [RequestBidModalPage]

})
export class CheckBidModalPageModule {}
