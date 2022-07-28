/* eslint-disable @typescript-eslint/naming-convention */
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-milestones',
  templateUrl: './milestones.page.html',
  styleUrls: ['./milestones.page.scss'],
})
export class MilestonesPage implements OnInit {
  child_name: string=localStorage.getItem('child_name');
  child_gender: string=localStorage.getItem('child_gender');
  constructor(private router: Router) { }

  ngOnInit() {
  }
  public getMem(button_id: number){
    localStorage.setItem('button_id',button_id.toString());
    this.router.navigate(['uploads']);
}
}
