import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { FollowingOtherProfilePage } from './following-other-profile.page';

const routes: Routes = [
  {
    path: '',
    component: FollowingOtherProfilePage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class FollowingOtherProfilePageRoutingModule {}
