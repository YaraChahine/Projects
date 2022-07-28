import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { RequestItemModalPageRoutingModule } from './request-item-modal-routing.module';

import { RequestItemModalPage } from './request-item-modal.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    RequestItemModalPageRoutingModule
  ],
  declarations: [RequestItemModalPage]
})
export class RequestItemModalPageModule {}
