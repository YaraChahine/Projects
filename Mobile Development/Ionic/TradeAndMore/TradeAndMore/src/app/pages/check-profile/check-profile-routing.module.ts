import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CheckProfilePage } from './check-profile.page';

const routes: Routes = [
  {
    path: '',
    component: CheckProfilePage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CheckProfilePageRoutingModule {}
