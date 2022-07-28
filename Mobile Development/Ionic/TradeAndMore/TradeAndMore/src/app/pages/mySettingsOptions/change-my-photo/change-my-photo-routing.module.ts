import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ChangeMyPhotoPage } from './change-my-photo.page';

const routes: Routes = [
  {
    path: '',
    component: ChangeMyPhotoPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ChangeMyPhotoPageRoutingModule {}
