import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
   path: '',
   redirectTo: 'landing',
   pathMatch: 'full'
  },
  {
    path: 'tabs',
    loadChildren: () => import('./pages/tabs/tabs.module').then( m => m.TabsPageModule)
  },
  {
    path: 'log-in',
    loadChildren: () => import('./pages/log-in/log-in.module').then( m => m.LogInPageModule)
  },
  {
    path: 'sign-up',
    loadChildren: () => import('./pages/sign-up/sign-up.module').then( m => m.SignUpPageModule)
  },
  {
    path: 'followers',
    loadChildren: () => import('./pages/followers/followers.module').then( m => m.FollowersPageModule)
  },
  {
    path: 'following',
    loadChildren: () => import('./pages/following/following.module').then( m => m.FollowingPageModule)
  },
  {
    path: 'check-profile/:email/:id',
    loadChildren: () => import('./pages/check-profile/check-profile.module').then( m => m.CheckProfilePageModule)
  },
  {
    path: 'followers-other-profile/:id',
    loadChildren: () => import('./pages/followers-other-profile/followers-other-profile.module').then( m => m.FollowersOtherProfilePageModule)
  },
  {
    path: 'following-other-profile/:id',
    loadChildren: () => import('./pages/following-other-profile/following-other-profile.module').then( m => m.FollowingOtherProfilePageModule)
  },
  {
    path: 'settings',
    loadChildren: () => import('./pages/settings/settings.module').then( m => m.SettingsPageModule)
  },
  {
    path: 'edit-my-profile',
    loadChildren: () => import('./pages/mySettingsOptions/edit-my-profile/edit-my-profile.module').then( m => m.EditMyProfilePageModule)
  },
  {
    path: 'change-my-password',
    loadChildren: () => import('./pages/mySettingsOptions/change-my-password/change-my-password.module').then( m => m.ChangeMyPasswordPageModule)
  },
  {
    path: 'change-my-photo',
    loadChildren: () => import('./pages/mySettingsOptions/change-my-photo/change-my-photo.module').then( m => m.ChangeMyPhotoPageModule)
  },
  {
    path: 'chat-area/:id/:email',
    loadChildren: () => import('./pages/chat-area/chat-area.module').then( m => m.ChatAreaPageModule)
  },
  {
    path: 'notifications',
    loadChildren: () => import('./pages/notifications/notifications.module').then( m => m.NotificationsPageModule)
  },
  {
    path: 'check-request-modal',
    loadChildren: () => import('./pages/check-request-modal/check-request-modal.module').then( m => m.CheckRequestModalPageModule)
  },
  {
    path: 'review-accept-modal',
    loadChildren: () => import('./pages/review-accept-modal/review-accept-modal.module').then( m => m.ReviewAcceptModalPageModule)
  },
  {
    path: 'receipts-menu',
    loadChildren: () => import('./pages/receipts-menu/receipts-menu.module').then( m => m.ReceiptsMenuPageModule)
  },
  {
    path: 'receipt-modal',
    loadChildren: () => import('./pages/receipt-modal/receipt-modal.module').then( m => m.ReceiptModalPageModule)
  },
  {
    path: 'landing',
    loadChildren: () => import('./pages/landing/landing.module').then( m => m.LandingPageModule)
  },






];
@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
