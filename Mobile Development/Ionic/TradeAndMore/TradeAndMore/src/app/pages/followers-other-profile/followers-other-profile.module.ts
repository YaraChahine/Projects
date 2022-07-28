import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { FollowersOtherProfilePageRoutingModule } from './followers-other-profile-routing.module';

import { FollowersOtherProfilePage } from './followers-other-profile.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    FollowersOtherProfilePageRoutingModule
  ],
  declarations: [FollowersOtherProfilePage]
})
export class FollowersOtherProfilePageModule {}
