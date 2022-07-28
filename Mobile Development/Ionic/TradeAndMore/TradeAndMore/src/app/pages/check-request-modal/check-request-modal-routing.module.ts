import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CheckRequestModalPage } from './check-request-modal.page';

const routes: Routes = [
  {
    path: '',
    component: CheckRequestModalPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CheckRequestModalPageRoutingModule {}
