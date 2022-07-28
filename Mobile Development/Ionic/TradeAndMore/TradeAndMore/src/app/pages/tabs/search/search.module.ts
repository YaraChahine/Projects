import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { SearchPageRoutingModule } from './search-routing.module';
import { ReactiveFormsModule } from '@angular/forms';

import { SearchPage } from './search.page';
import { Ng2SearchPipeModule } from 'ng2-search-filter';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ReactiveFormsModule,
    SearchPageRoutingModule,
    Ng2SearchPipeModule
  ],
  declarations: [SearchPage]
})
export class SearchPageModule {}
