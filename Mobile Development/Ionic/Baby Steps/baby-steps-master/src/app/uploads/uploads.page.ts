/* eslint-disable @typescript-eslint/naming-convention */
import { Component, OnInit,Input } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ApisService,Memories } from './../services/apis.service';

@Component({
  selector: 'app-uploads',
  templateUrl: './uploads.page.html',
  styleUrls: ['./uploads.page.scss'],
})
export class UploadsPage implements OnInit {
  // eslint-disable-next-line @typescript-eslint/naming-convention
  @Input() child_note: string;
  child_id: string = localStorage.getItem('child_id');
  button_id: string = localStorage.getItem('button_id');
  child_name: string=localStorage.getItem('child_name');
  child_gender: string=localStorage.getItem('child_gender');
  memory: Memories[];
  constructor(private service: ApisService,) { }

  ngOnInit() {
    this.service.getUploads().subscribe(response => {
      this.memory = response;
      console.log('hi' + JSON.stringify(this.memory));
  });
}
  public onSubmit(form: NgForm){
    const child = form.value;
    this.service.addNote(child).subscribe(response => {
        if(response==null){
          console.log('error');
        }
        else{
        }
    });
    }
}
