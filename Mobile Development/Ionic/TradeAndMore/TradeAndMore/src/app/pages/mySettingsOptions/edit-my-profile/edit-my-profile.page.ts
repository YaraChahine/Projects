import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { MyAPIsService,User } from './../../../services/my-apis.service';
import { AlertController } from '@ionic/angular';
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { Local } from 'protractor/built/driverProviders';

@Component({
  selector: 'app-edit-my-profile',
  templateUrl: './edit-my-profile.page.html',
  styleUrls: ['./edit-my-profile.page.scss'],
})
export class EditMyProfilePage implements OnInit {
  isSubmitted = false;
  ionicForm: FormGroup;
  email: any;
  user: any = [];
  id: any;
  first_name: any;
  last_name: any;
  phone_number: any;
  location: any;
  wishlist: any;

  constructor(private router: Router,public service: MyAPIsService,public alertController: AlertController,public formBuilder: FormBuilder) { }

  ngOnInit() {
    this.email = localStorage.getItem("logged-in-email");
    this.getProfileInfo();
    this.id = localStorage.getItem("logged-in-user-id");
    console.log("check " + this.id);

    this.ionicForm = this.formBuilder.group({
      ID: [this.id],
      FirstName: [this.first_name, [Validators.required, Validators.pattern('.*\\S.*[a-zA-z]'),Validators.maxLength(30)]],
      LastName: [this.last_name, [Validators.required, Validators.pattern('.*\\S.*[a-zA-z]'),Validators.maxLength(30)]],
      PhoneNumber: [this.user.phone_number, [Validators.required]],
      Email: [this.email, [Validators.required, Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$')]],
      Location: [this.user.location, [Validators.required]],
      Wishlist: [this.user.wishlist],
    })
  }
  get errorControl() {
    return this.ionicForm.controls;
  }


async showAlert() {
  const alert = await this.alertController.create({
    header: 'Attention',
    message: 'Email already taken.',
    buttons: ['OK']
  });
   await alert.present();
}

async showAlert2() {
  const alert = await this.alertController.create({
    header: 'Success',
    message: 'Update successful!',
    buttons: ['OK'],
    cssClass : 'alert'
  });
   await alert.present();
}


public goToSettings(){

  this.router.navigate(['settings']);
}

getProfileInfo(){
  console.log("hi",this.email);

  this.service.getProfileInfo(this.email).subscribe((res:any)=>{

    this.user=res;

    console.log(this.user);
    console.log(this.user.first_name);
    this.first_name = this.user.first_name;
    this.last_name = this.user.last_name;
    this.phone_number = this.user.phone_number;
    this.location = this.user.location;
    this.wishlist = this.user.wishlist;
    this.ionicForm.controls.FirstName.setValue(this.first_name);
    this.ionicForm.controls.LastName.setValue(this.last_name);
    this.ionicForm.controls.PhoneNumber.setValue(this.phone_number);
    this.ionicForm.controls.Location.setValue(this.location);
    this.ionicForm.controls.Wishlist.setValue(this.wishlist);
    console.log("check " + this.user.wishlist);

    console.log("SUCCESS");
  },(error:any)=>{
    console.log("Error");
  })
}
public onSubmit(){
  this.isSubmitted = true;
  if(!this.ionicForm.valid){
    console.log('Please provide all the required values!');
      return false;
  }else{
    localStorage.setItem("logged-in-email",this.ionicForm.value.Email);
    const user = this.ionicForm.value;
    console.log(user);
    this.service.editProfileInfo(user).subscribe(response => {
      if(response==null){
        this.showAlert();
      }
      else{
        this.showAlert2();
      }
  });
  }
}
}
