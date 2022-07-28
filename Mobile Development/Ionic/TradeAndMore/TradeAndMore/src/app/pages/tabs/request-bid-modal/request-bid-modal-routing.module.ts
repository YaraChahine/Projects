import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RequestBidModalPage } from './request-bid-modal.page';

const routes: Routes = [
  {
    path: '',
    component: RequestBidModalPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class RequestBidModalPageRoutingModule {}
