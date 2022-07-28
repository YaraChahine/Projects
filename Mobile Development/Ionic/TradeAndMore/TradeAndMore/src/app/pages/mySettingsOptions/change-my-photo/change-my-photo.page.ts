import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { MyAPIsService,User } from './../../../services/my-apis.service';
import { AlertController } from '@ionic/angular';
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { HttpClient} from '@angular/common/http';


@Component({
  selector: 'app-change-my-photo',
  templateUrl: './change-my-photo.page.html',
  styleUrls: ['./change-my-photo.page.scss'],
})
export class ChangeMyPhotoPage implements OnInit {
  isSubmitted = false;
  email: any;
  user: any = [];
  id: any;
  image: any;
  item_img_file:any;

  constructor(private http : HttpClient,private router: Router,public service: MyAPIsService,public alertController: AlertController,public formBuilder: FormBuilder) { }

  selectedFile($event){
    this.image = $event.target.files[0];
  }
  ngOnInit() {
    this.email = localStorage.getItem("logged-in-email");
    this.id = localStorage.getItem("logged-in-user-id");
    console.log("check " + this.id);

  
  }
  


  public goToSettings(){

    this.router.navigate(['settings']);
}

async showAlert2() {
  const alert = await this.alertController.create({
    header: 'Success',
    message: 'Update successful!',
    buttons: ['OK']
  });
   await alert.present();
}

public onSubmit(){
  this.id=localStorage.getItem("logged-in-user-id");

  const formData = new FormData();
  formData.append('img_file',this.image);
  this.http.post('http://localhost/capstone_apis/changePicture.php?email='+this.email,formData).subscribe((res:any)=>{

    console.log("SUCCESS=", res);
    this.showAlert2();

    this.item_img_file=res['path'];
    console.log("item img", this.item_img_file);

  })

}
}
