import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AddBidModalPage } from './add-bid-modal.page';

const routes: Routes = [
  {
    path: '',
    component: AddBidModalPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AddBidModalPageRoutingModule {}
