import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { MemPageRoutingModule } from './mem-routing.module';

import { MemPage } from './mem.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    MemPageRoutingModule
  ],
  declarations: [MemPage]
})
export class MemPageModule {}
