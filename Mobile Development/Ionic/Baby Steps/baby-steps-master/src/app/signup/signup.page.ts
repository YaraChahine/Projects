import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ApisService,User } from './../services/apis.service';
import { AlertController } from '@ionic/angular';
import { Storage } from '@ionic/storage';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.page.html',
  styleUrls: ['./signup.page.scss'],
})
export class SignupPage implements OnInit {

  constructor(private router: Router,private service: ApisService,public alertController: AlertController,private storage: Storage) {

  }
  ngOnInit() {
  }
  async showAlert() {
    const alert = await this.alertController.create({
      header: 'Attention',
      message: 'Email already taken.',
      buttons: ['OK']
    });
     await alert.present();
  }
  public onSubmit(form: NgForm){
    const user = form.value;
    this.service.enterUser(user).subscribe(response => {
        if(response==null){
          this.showAlert();
        }
        else{
          localStorage.setItem('email',String(response));
          this.router.navigate(['home']);
        }
    });
    }
}
