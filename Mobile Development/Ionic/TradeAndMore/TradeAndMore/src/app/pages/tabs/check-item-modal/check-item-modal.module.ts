import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { CheckItemModalPageRoutingModule } from './check-item-modal-routing.module';

import { CheckItemModalPage } from './check-item-modal.page';
import { RequestItemModalPage } from '../request-item-modal/request-item-modal.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    CheckItemModalPageRoutingModule
  ],
  declarations: [CheckItemModalPage, RequestItemModalPage],
  entryComponents : [RequestItemModalPage]
})
export class CheckItemModalPageModule {}
