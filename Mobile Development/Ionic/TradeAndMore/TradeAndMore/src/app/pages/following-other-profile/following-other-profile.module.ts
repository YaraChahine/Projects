import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { FollowingOtherProfilePageRoutingModule } from './following-other-profile-routing.module';

import { FollowingOtherProfilePage } from './following-other-profile.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    FollowingOtherProfilePageRoutingModule
  ],
  declarations: [FollowingOtherProfilePage]
})
export class FollowingOtherProfilePageModule {}
