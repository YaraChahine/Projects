import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MyAPIsService } from 'src/app/services/my-apis.service';
import { Router } from '@angular/router';
import { ModalController } from '@ionic/angular';
import { AddItemModalPage } from '../tabs/add-item-modal/add-item-modal.page';
import { CheckItemModalPage } from '../tabs/check-item-modal/check-item-modal.page';


@Component({
  selector: 'app-check-profile',
  templateUrl: './check-profile.page.html',
  styleUrls: ['./check-profile.page.scss'],
})
export class CheckProfilePage implements OnInit {
  results: any = [];
  buttonValue = 'Reviews';
  buttonItems: any[] = [];
  email: any;
  id: any;
  user: any = [];
  following: any;
  followers: any;
  following_res: string;
  items: any = [];
  myFollowers2: any = [];
  logged_in_id: any;
  reviews: any;
  items_counter: any;

  constructor(private route: ActivatedRoute, public _apiService: MyAPIsService, private router: Router, private modalCtrl: ModalController) {

    console.log("email????", this.email);
    console.log("id????", this.id);

  }

  ngOnInit() {
    this.email = JSON.parse(this.route.snapshot.paramMap.get('email'));
    this.id = JSON.parse(this.route.snapshot.paramMap.get('id'));
    this.getItemsCounter();

    this.getUserName();
   

    this.buttonItems=[
      {value:'Reviews', icon:'grid'},
      {value:'Items', icon:'film'},
      {value: 'Donations',icon:'images'},
    ];

    this.buttonValue='Items';

    console.log("HI", this.myFollowers2);

  }

  ionViewWillEnter(){
    this.getUserName();

    this.getItems();
    this.getItemsCounter();
    this.buttonValue='Items';
  }

  getItemsCounter(){

    this._apiService.getItemsCounter(this.id).subscribe((res:any)=>{
      this.items_counter=res["count(item_id)"];
      console.log(" counter SUCCES",res);
    },(error:any)=>{
      console.log("counter Error",error);
    })
  }
  buttonsChanged(event){
    console.log(event.detail.value);
    this.buttonValue= event.detail.value;

    if (this.buttonValue=='Items' || this.buttonValue=='Donations' ){
this.getItems();
  
    }

    if (this.buttonValue=='Reviews'){
      this.getReviews();
    }

  }
  public goTo(email : any,id : any){
    console.log("Where is the email  ? :O", email);
    console.log("Where is the id  ? :O", id);
    this.router.navigate(['check-profile', JSON.stringify(email),JSON.stringify(id)]);
  
  }

getItems(){
  this._apiService.getItems(this.id).subscribe((res:any)=>{
    this.items=res;
    console.log("SUCCESS",res);
    console.log("items array",this.items.length);
  },(error:any)=>{
    console.log("Error",error);
  })

}
  check(result1: any, result2: any[]) {

    const checkUsername = obj => obj.user_id === result1;
    if (result2.some(checkUsername)) {
      return 'Yes';
    } else {
      return 'No';
    }




  }
  goToChats(id: any, email: any) {
    console.log("Where is the id111  ? :O", id);
    console.log("Where is the email 222  ? :O", this.email);

    this.router.navigate(['chat-area', JSON.stringify(id), JSON.stringify(this.email)]);

  }
  getUserName() {
    console.log("hi", this.email);

    this._apiService.getUserName(this.email).subscribe((res: any) => {

      this.user = res;
      this.getFollowing();
      this.getReviews();
      this.getFollowers();
      this.getFollowersList();

      console.log("SUCCESS");
    }, (error: any) => {
      console.log("Error");
    })
  }


  getFollowing() {

    console.log("USER ID IS: " + this.id);
    this._apiService.getFollowing(this.id).subscribe((res: any) => {
      this.following_res = JSON.stringify(res);
      this.following = res["count(followedby)"];
      console.log("following: " + this.following);
      console.log(" FOLLOWING SUCCES", res);
    }, (error: any) => {
      console.log("FOLLOWING Error");
    })
  }
  getReviews() {
    this._apiService.getReviews(this.id).subscribe((res: any) => {

      this.reviews = res;
      console.log(" reviews SUCCESS", res);
    }, (error: any) => {
      console.log("reviews Error");
    })
  }

  getFollowers() {
    this._apiService.getFollowers(this.id).subscribe((res: any) => {

      this.followers = res["count(follows)"];
      console.log("followers: " + this.followers);
      console.log(" followers SUCCESS", res);
    }, (error: any) => {
      console.log("followers Error");
    })
  }

  public goToFollowers() {

    this.router.navigate(['followers-other-profile', JSON.stringify(this.id)]);
  }
  public goToFollowing() {

    this.router.navigate(['following-other-profile', JSON.stringify(this.id)]);
  }

  public follow(id: any) {
    this.logged_in_id = localStorage.getItem("logged-in-user-id");
    console.log('logged in id is : ' + this.logged_in_id + 'other user id ' + id);

    this._apiService.follow(id, this.logged_in_id).subscribe((res: any) => {

      console.log(" follow SUCCESS", res);
      this.getFollowersList();

    }, (error: any) => {
      console.log("follow Error");
    })
    this.getFollowers();
  }

  public unfollow(id: any) {
    this.logged_in_id = localStorage.getItem("logged-in-user-id");
    console.log('logged in id is : ' + this.logged_in_id + 'other user id ' + id);

    this._apiService.unfollow(id, this.logged_in_id).subscribe((res: any) => {

      console.log(" follow SUCCESS", res);
      this.getFollowersList();

    }, (error: any) => {
      console.log("follow Error");
    })
    this.getFollowers();

  }
  getFollowersList() {

    this._apiService.getFollowersList(this.id).subscribe((res: any) => {
      this.results = res;
      console.log(" followers liist SUCCESS", res);
    }, (error: any) => {
      console.log("folllowers liiist Error");
    })
    this._apiService.getFollowingList(localStorage.getItem("logged-in-user-id")).subscribe((res2: any) => {
      this.myFollowers2 = res2;
      console.log("I am following", res2);
      console.log("I am following 22", this.myFollowers2);

    }, (error: any) => {
      console.log("folllowers liiist Error");
    })

  }

  public goToSettings() {

    this.router.navigate(['settings']);
  }
  async openModal() {
    const modal = await this.modalCtrl.create({
      component: AddItemModalPage

    });

    await modal.present();
  }

  async openItemModal(item) {
    const modal = await this.modalCtrl.create({
      component: CheckItemModalPage,

      componentProps: {
        'item_name': item.item_name,
        'item_id': item.item_id,
        'user_id': item.user_id,
        'item_image': item.item_image,
        'item_category': item.item_category,
        'item_subcategory': item.item_subcategory,
        'item_description': item.item_description,
        'item_type': item.item_type,
        'item_price': item.item_price,
        'date_uploaded': item.date_uploaded,
      }
    });

    await modal.present();
  }

}
