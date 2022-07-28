import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { TabsPage } from './tabs.page';

const routes: Routes = [
  {
    path: '',
    component: TabsPage,
    children : [

    {
      path: 'home',
      loadChildren: () => import('./home/home.module').then( m => m.HomePageModule)
    },

    {
      path: 'search',
      loadChildren: () => import('./search/search.module').then( m => m.SearchPageModule)
    },
    {
      path: 'chat',
      loadChildren: () => import('./chat/chat.module').then( m => m.ChatPageModule)
    },
    {
      path: 'biddings',
      loadChildren: () => import('./biddings/biddings.module').then( m => m.BiddingsPageModule)
    },
    {
      path: 'profile',
      loadChildren: () => import('./profile/profile.module').then( m => m.ProfilePageModule)
    },
    {
      path: '',
      redirectTo:'/tabs/profile',
      pathMatch: 'full'
    }
  ]
  },  {
    path: 'add-item-modal',
    loadChildren: () => import('./add-item-modal/add-item-modal.module').then( m => m.AddItemModalPageModule)
  },
  {
    path: 'check-item-modal',
    loadChildren: () => import('./check-item-modal/check-item-modal.module').then( m => m.CheckItemModalPageModule)
  },
  {
    path: 'request-item-modal',
    loadChildren: () => import('./request-item-modal/request-item-modal.module').then( m => m.RequestItemModalPageModule)
  },
  {
    path: 'add-bid-modal',
    loadChildren: () => import('./add-bid-modal/add-bid-modal.module').then( m => m.AddBidModalPageModule)
  },
  {
    path: 'check-bid-modal',
    loadChildren: () => import('./check-bid-modal/check-bid-modal.module').then( m => m.CheckBidModalPageModule)
  },
  {
    path: 'request-bid-modal',
    loadChildren: () => import('./request-bid-modal/request-bid-modal.module').then( m => m.RequestBidModalPageModule)
  },




];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class TabsPageRoutingModule {}
