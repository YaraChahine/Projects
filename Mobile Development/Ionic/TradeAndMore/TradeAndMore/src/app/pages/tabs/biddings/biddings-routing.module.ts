import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { BiddingsPage } from './biddings.page';

const routes: Routes = [
  {
    path: '',
    component: BiddingsPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class BiddingsPageRoutingModule {}
