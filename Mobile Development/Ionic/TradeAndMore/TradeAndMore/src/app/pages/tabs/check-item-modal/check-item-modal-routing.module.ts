import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CheckItemModalPage } from './check-item-modal.page';

const routes: Routes = [
  {
    path: '',
    component: CheckItemModalPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CheckItemModalPageRoutingModule {}
