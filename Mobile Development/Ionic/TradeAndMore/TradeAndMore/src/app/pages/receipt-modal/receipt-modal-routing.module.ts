import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ReceiptModalPage } from './receipt-modal.page';

const routes: Routes = [
  {
    path: '',
    component: ReceiptModalPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ReceiptModalPageRoutingModule {}
