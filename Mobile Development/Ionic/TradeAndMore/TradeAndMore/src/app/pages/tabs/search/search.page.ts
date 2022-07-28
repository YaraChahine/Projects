import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { MyAPIsService } from 'src/app/services/my-apis.service';
import { AlertController } from '@ionic/angular';
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { ModalController } from '@ionic/angular';
import { CheckItemModalPage } from '../check-item-modal/check-item-modal.page';
@Component({
  selector: 'app-search',
  templateUrl: './search.page.html',
  styleUrls: ['./search.page.scss'],
})
export class SearchPage implements OnInit {
  ionicForm: FormGroup;
  searchText: string;
  searchTerm: string;

  results: any = [];
  logged_in_id: any;
  buttonValue = 'People';
  buttonItems: any[] = [];
  searchDone: Number;
  items : any=[];
  myFollowers:any=[];
  constructor(private router: Router,private modalCtrl: ModalController, private service: MyAPIsService, public alertController: AlertController, public formBuilder: FormBuilder) { }


  ngOnInit() {
    this.buttonItems = [
      { value: 'People', icon: 'grid' },
      { value: 'Items', icon: 'film' },
    ];
    this.searchDone = 0;
  }


  buttonsChanged(event) {
    console.log(event.detail.value);
    this.buttonValue = event.detail.value;


  }



  searchTermm(event) {
    if (this.buttonValue == "People") {
      console.log(this.searchTerm);
      if (this.searchTerm != "") {
        this.onSearchEventPeople();
      }
      else {
        this.results = [];
      }

    }


    if (this.buttonValue == "Items") {
      console.log(this.searchTerm);
      if (this.searchTerm != "") {
        this.onSearchEventItems();
      }
      else {
        this.items = [];
      }
      
    }


  }
  public onSearch() {


    console.log(this.searchText);
    this.service.getSearchResults(this.searchText).subscribe((res: any) => {
      this.results = res;
      console.log(" SEARCH SUCCESS", res);
    }, (error: any) => {
      console.log("search Error");
    })

  };

  public onSearchEventPeople() {


    this.service.getUsers().subscribe((res: any) => {
      this.results = res;
      this.searchDone = 1;
      console.log(" SEARCH SUCCESS", res);
    }, (error: any) => {
      console.log("search Error");
    })

  };


  public onSearchEventItems() {


    this.service.getAllitems().subscribe((res: any) => {
      this.items = res;
      this.searchDone = 1;
      console.log(" SEARCH SUCCESS", res);
    }, (error: any) => {
      console.log("search Error", error);
    })

  };


  public goTo(email : any,id : any){
    console.log("Where is the email  ? :O", email);
    console.log("Where is the id  ? :O", id);
    this.router.navigate(['check-profile', JSON.stringify(email),JSON.stringify(id)]);
  
  }

  async openItemModal(item){
    const modal = await this.modalCtrl.create({
      component: CheckItemModalPage,
  
      componentProps: {
        'item_name'       :         item.item_name,
        'item_id'         :           item.item_id,
        'user_id'         :           item.user_id,
        'item_image'      :        item.item_image,
        'item_category'   :     item.item_category,
        'item_subcategory':  item.item_subcategory,
        'item_description':  item.item_description,
        'item_type'       :         item.item_type,
         'item_price'     :       item.item_price,
         'date_uploaded'  :    item.date_uploaded,
      }
    });
  
    await modal.present();
  }
}


