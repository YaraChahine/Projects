import { Component, OnInit,Input } from '@angular/core';
import { ApisService,Children } from './../services/apis.service';
import { Router } from '@angular/router';
import { Storage } from '@ionic/storage';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-children',
  templateUrl: './children.page.html',
  styleUrls: ['./children.page.scss'],
})

export class ChildrenPage implements OnInit {

  email: string = localStorage.getItem('email');
  constructor(private router: Router,private service: ApisService,private storage: Storage) {
}
  ngOnInit() {
}
public onSubmit(form: NgForm){
  const child = form.value;
  console.log(child);
  this.service.addChildren(child).subscribe(response => {
    console.log(response);
      if(response==null){
        console.log('error');
      }
      else{
        this.router.navigate(['home']);
      }
  });
  }
}
