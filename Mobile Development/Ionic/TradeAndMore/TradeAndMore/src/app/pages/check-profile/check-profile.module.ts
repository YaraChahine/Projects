import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { CheckProfilePageRoutingModule } from './check-profile-routing.module';

import { CheckProfilePage } from './check-profile.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    CheckProfilePageRoutingModule
  ],
  declarations: [CheckProfilePage]
})
export class CheckProfilePageModule {}
