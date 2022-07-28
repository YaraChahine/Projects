import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ChangeMyPhotoPageRoutingModule } from './change-my-photo-routing.module';

import { ChangeMyPhotoPage } from './change-my-photo.page';
import {ReactiveFormsModule} from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ChangeMyPhotoPageRoutingModule,
    ReactiveFormsModule
  ],
  declarations: [ChangeMyPhotoPage]
})
export class ChangeMyPhotoPageModule {}
