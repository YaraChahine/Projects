import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ChangeMyPasswordPageRoutingModule } from './change-my-password-routing.module';

import { ChangeMyPasswordPage } from './change-my-password.page';
import {ReactiveFormsModule} from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ChangeMyPasswordPageRoutingModule,
    ReactiveFormsModule
  ],
  declarations: [ChangeMyPasswordPage]
})
export class ChangeMyPasswordPageModule {}
