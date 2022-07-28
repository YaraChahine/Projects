import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-settings',
  templateUrl: './settings.page.html',
  styleUrls: ['./settings.page.scss'],
})
export class SettingsPage implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }
  public goToEditProfile(){
    this.router.navigate(['edit-my-profile']);
  }
  public goToChangePassword(){
    this.router.navigate(['change-my-password']);
  }
  public goToChangePhoto(){
    this.router.navigate(['change-my-photo']);
  }

  public goToProfile(){

    this.router.navigate(['tabs/profile']);
}

logOut(){
  localStorage.setItem("logged-in-user-id", " ");
  this.router.navigate(['landing']);

}
}
