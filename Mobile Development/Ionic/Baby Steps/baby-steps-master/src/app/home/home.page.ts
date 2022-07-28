import { Component,OnInit,Input } from '@angular/core';
import { ApisService,Children } from './../services/apis.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit{
    // eslint-disable-next-line @typescript-eslint/naming-convention
    @Input() child_id: number;
    // eslint-disable-next-line @typescript-eslint/naming-convention
    @Input() child_name: string;
    // eslint-disable-next-line @typescript-eslint/naming-convention
    @Input() child_gender: string;
  child: Children[];


  constructor(private router: Router,private service: ApisService) { }

  ngOnInit() {
    this.service.getChildren().subscribe(response => {
      this.child = response;
      console.log('hi' + JSON.stringify(this.child));
  });
}
  public checkChild(){
      this.router.navigate(['memories']);
  }
  // eslint-disable-next-line @typescript-eslint/naming-convention
  public checkChild1(child_id: number, child_name: string,child_gender: string){
      localStorage.setItem('child_id',child_id.toString());
      console.log(localStorage.getItem('child_id'));
      localStorage.setItem('child_name',child_name);
      localStorage.setItem('child_gender',child_gender);
      this.router.navigate(['memories']);
  }
  public addChild(){
    this.router.navigate(['children']);
}
}

