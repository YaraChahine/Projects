import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { MemPage } from './mem.page';

const routes: Routes = [
  {
    path: '',
    component: MemPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class MemPageRoutingModule {}
