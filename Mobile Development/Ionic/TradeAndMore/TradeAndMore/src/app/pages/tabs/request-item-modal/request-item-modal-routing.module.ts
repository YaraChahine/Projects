import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RequestItemModalPage } from './request-item-modal.page';

const routes: Routes = [
  {
    path: '',
    component: RequestItemModalPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class RequestItemModalPageRoutingModule {}
