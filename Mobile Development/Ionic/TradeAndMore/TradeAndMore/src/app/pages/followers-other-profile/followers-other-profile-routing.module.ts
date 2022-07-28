import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { FollowersOtherProfilePage } from './followers-other-profile.page';

const routes: Routes = [
  {
    path: '',
    component: FollowersOtherProfilePage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class FollowersOtherProfilePageRoutingModule {}
