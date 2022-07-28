import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ChatAreaPageRoutingModule } from './chat-area-routing.module';

import { ChatAreaPage } from './chat-area.page';
import {ReactiveFormsModule} from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ChatAreaPageRoutingModule,
    ReactiveFormsModule
  ],
  declarations: [ChatAreaPage]
})
export class ChatAreaPageModule {}
