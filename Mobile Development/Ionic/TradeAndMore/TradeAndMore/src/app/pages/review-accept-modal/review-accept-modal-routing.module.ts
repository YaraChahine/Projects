import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ReviewAcceptModalPage } from './review-accept-modal.page';

const routes: Routes = [
  {
    path: '',
    component: ReviewAcceptModalPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ReviewAcceptModalPageRoutingModule {}
