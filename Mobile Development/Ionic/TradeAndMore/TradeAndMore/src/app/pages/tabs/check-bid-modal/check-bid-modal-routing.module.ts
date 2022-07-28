import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CheckBidModalPage } from './check-bid-modal.page';

const routes: Routes = [
  {
    path: '',
    component: CheckBidModalPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CheckBidModalPageRoutingModule {}
