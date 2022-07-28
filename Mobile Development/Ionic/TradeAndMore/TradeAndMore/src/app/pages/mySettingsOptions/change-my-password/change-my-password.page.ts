import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { MyAPIsService,User } from './../../../services/my-apis.service';
import { AlertController } from '@ionic/angular';
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { ToastController } from '@ionic/angular';

@Component({
  selector: 'app-change-my-password',
  templateUrl: './change-my-password.page.html',
  styleUrls: ['./change-my-password.page.scss'],
})


export class ChangeMyPasswordPage implements OnInit {
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

  constructor(public  toastController: ToastController,private router: Router,public service: MyAPIsService,public alertController: AlertController,public formBuilder: FormBuilder) { }

  ngOnInit() {
    this.email = localStorage.getItem("logged-in-email");
    this.id = localStorage.getItem("logged-in-user-id");
    console.log("check " + this.id);

    this.ionicForm = this.formBuilder.group({
      Password: ['', [Validators.required, Validators.pattern('(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&].{3,}'),Validators.minLength(8)]],
    })
  }
  get errorControl() {
    return this.ionicForm.controls;
  }

  public goToSettings(){

    this.router.navigate(['settings']);
}

async showAlert2() {
  const alert = await this.alertController.create({
    header: 'Success',
    message: 'Update successful!',
    buttons: ['OK'],
    cssClass: 'alert',

    });
   await alert.present();
}

public onSubmit(){
  this.isSubmitted = true;
  if(!this.ionicForm.valid){
    console.log('Please provide all the required values!');
      return false;
  }else{
    const user = this.ionicForm.value;
    console.log(user);
    console.log(this.email);
    this.service.changePassword(this.email,user).subscribe(response => {
      if(response==null){
        this.showAlert2();

      }
      else{
        this.showAlert2();
      }
  });
  }
}
}
