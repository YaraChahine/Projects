import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ApisService,User } from './../services/apis.service';
import { AlertController } from '@ionic/angular';
import { Storage } from '@ionic/storage';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit{

  constructor(private router: Router, private service: ApisService,public alertController: AlertController,private storage: Storage) { }

  ngOnInit() {
  }
  async showAlert() {
    const alert = await this.alertController.create({
      header: 'Attention',
      message: 'Incorrect email or password. Please try again.',
      buttons: ['OK']
    });
     await alert.present();
  }

  public onSubmit(form: NgForm){
      const user = form.value;
      this.service.checkUser(user).subscribe(response => {
          if(response==null){
            console.log('error');
            this.showAlert();
          }
          else{
            localStorage.setItem('email',String(response));
            this.router.navigate(['home']);
          }
      });
      }
  public signup(){
    this.router.navigate(['signup']);
}
}
