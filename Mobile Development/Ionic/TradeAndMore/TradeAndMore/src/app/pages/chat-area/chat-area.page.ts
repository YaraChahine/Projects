import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { MyAPIsService,User } from './../../services/my-apis.service';
import { AlertController } from '@ionic/angular';
import { FormGroup, FormBuilder, Validators } from "@angular/forms";

@Component({
  selector: 'app-chat-area',
  templateUrl: './chat-area.page.html',
  styleUrls: ['./chat-area.page.scss'],
})
export class ChatAreaPage implements OnInit {
  isSubmitted = false;
  ionicForm: FormGroup;
  email: any;
  id: any;
  logged_in_id: any;
  message: any = [];
  user: any = [];
  results: any = [];

  constructor(private route: ActivatedRoute,private router: Router,public _apiService: MyAPIsService,public formBuilder: FormBuilder,public alertController: AlertController) {
    this.email = JSON.parse(this.route.snapshot.paramMap.get('email'));
    this.id = JSON.parse(this.route.snapshot.paramMap.get('id'));
    this.getMessages();

  }

  ngOnInit() {
    this.getUserName();

    this.logged_in_id=localStorage.getItem("logged-in-user-id");
    this.ionicForm = this.formBuilder.group({
      Message: ['', [Validators.required]],

    })
    this.getMessages();

  }
  get errorControl() {
    return this.ionicForm.controls;
  }
  async showAlert() {
    const alert = await this.alertController.create({
      header: 'Attention',
      message: "You can't send an empty message!",
      buttons: ['OK']
    });
     await alert.present();
  }
  getUserName(){
    console.log("hi",this.email);

    this._apiService.getUserName(this.email).subscribe((res:any)=>{

      this.user=res;

      console.log("SUCCESS");
    },(error:any)=>{
      console.log("Error",error);
    })
  }
  getMessages(){
    console.log("hi",this.email);
    console.log("hi",this.logged_in_id);
    console.log("hi",this.id);

    this._apiService.getChatMessages(this.logged_in_id,this.id).subscribe((res:any)=>{

      this.results=res;
      console.log(res);
      console.log("SUCCESSSSS");
    },(error:any)=>{
      console.log("Error, error", error);
    })
  }
  public goBack(){
    this.router.navigate(['tabs/profile']);
  }
  public check(id1: number, id2: number){
    if(id1===id2){
      return 'Yes';
    }else{
      return 'No';
    }
  }
  public onSubmit(){
    this.isSubmitted = true;
    if(!this.ionicForm.valid){
      this.showAlert();
        return false;
    }else{
      const message = this.ionicForm.value;
      console.log(message);
      this.ionicForm.reset();
      this._apiService.sendMessage(this.logged_in_id,this.id,message).subscribe(response => {
        this.getMessages();

    });
    }
  }
}
