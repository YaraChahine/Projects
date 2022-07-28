import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { NotificationsPageRoutingModule } from './notifications-routing.module';

import { NotificationsPage } from './notifications.page';
import { CheckItemModalPage } from '../tabs/check-item-modal/check-item-modal.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    NotificationsPageRoutingModule,
  ],
  declarations: [NotificationsPage,CheckItemModalPage],
  entryComponents : [CheckItemModalPage]
})
export class NotificationsPageModule {}
