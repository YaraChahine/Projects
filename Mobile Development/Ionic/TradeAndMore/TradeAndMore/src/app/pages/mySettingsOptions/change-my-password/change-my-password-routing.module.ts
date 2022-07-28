import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ChangeMyPasswordPage } from './change-my-password.page';

const routes: Routes = [
  {
    path: '',
    component: ChangeMyPasswordPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ChangeMyPasswordPageRoutingModule {}
