import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ChatAreaPage } from './chat-area.page';

const routes: Routes = [
  {
    path: '',
    component: ChatAreaPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ChatAreaPageRoutingModule {}
