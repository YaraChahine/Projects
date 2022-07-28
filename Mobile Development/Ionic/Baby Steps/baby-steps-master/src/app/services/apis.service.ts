/* eslint-disable @typescript-eslint/naming-convention */
import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Storage } from '@ionic/storage';
let child_id='';
let button_id='';
let email='';
export interface User{
  user_id?: number;
  username: string;
  email: string;
  password: string;
}

export interface Children{
  child_id?: number;
  email: string;
  child_name: string;
  child_gender: string;
}

export interface Memories{
  child_id: string;
  button_id: string;
  child_note?: string;
  child_image?: string;
}
@Injectable({
  providedIn: 'root'
})
export class ApisService  {
  private url = 'http://localhost/mobile_apis/';

  constructor(private http: HttpClient,private storage: Storage) {

   }
    checkUser(user: User){
      return this.http.post(this.url + 'logIn.php', user);
    }
    enterUser(user: User){
      return this.http.post(this.url + 'SignUp.php', user);
    }
    getChildren(){
      email = localStorage.getItem('email');
      console.log(`${this.url}getChildren.php?email=${email}`);
      return this.http.get<[Children]>(`${this.url}getChildren.php?email=${email}`);
    }
    addChildren(child: Children){
      email = localStorage.getItem('email');
      console.log(this.url + 'addChildren.php?email=' + localStorage.getItem('email'));
      return this.http.post(this.url + 'addChildren.php?email=' + localStorage.getItem('email'), child);
    }
    addNote(memory: Memories){
      child_id = localStorage.getItem('child_id');
      console.log(this.url + 'addNote.php?child_id=' + localStorage.getItem('child_id'));
      return this.http.post(this.url + 'addNote.php?child_id=' + localStorage.getItem('child_id'), memory);
    }
    getUploads(){
      child_id = localStorage.getItem('child_id');
      button_id = localStorage.getItem('button_id');
      console.log(`${this.url}getUploads.php?child_id=${child_id}&button_id=${button_id}`);
      return this.http.get<[Memories]>(`${this.url}getUploads.php?child_id=${child_id}&button_id=${button_id}`);
    }
}
