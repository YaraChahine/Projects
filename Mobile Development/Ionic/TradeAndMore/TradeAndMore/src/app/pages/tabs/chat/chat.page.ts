import { Component, OnInit } from '@angular/core';
import { MyAPIsService,User } from './../../../services/my-apis.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { ChangeDetectorRef} from '@angular/core';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.page.html',
  styleUrls: ['./chat.page.scss'],
})
export class ChatPage implements OnInit {
  logged_in_id: any;
  results: any = [];
  results3: any = [];
  results2: any = [];
  email: any;
  id: any;
  constructor(public _apiService: MyAPIsService,private router: Router,private route: ActivatedRoute,private cdr: ChangeDetectorRef) {
    this.id = JSON.parse(this.route.snapshot.paramMap.get('id'));
   }
  ngOnInit() {
    this.logged_in_id=localStorage.getItem("logged-in-user-id");
    this.getPreviousChats(this.logged_in_id);

  }
  ngAfterContentChecked(): void {
    this.cdr.detectChanges();
  }
  public check(id1: any, id2: any){

    if(id1!=id2){

      return 'Yes';
    } else{

      return 'No';
    }

}
check2(result1: any,result2: any[]) {

  const checkUsername = obj => obj.id === result1;
  if(result2.some(checkUsername)){
    return 'Yes';
  }else{
    return 'No';
  }




}


  getPreviousChats(logged_in_id: any){
    this._apiService.getPreviousChats(this.logged_in_id).subscribe((res:any)=>{

      this.results=res;
      console.log(res);
      console.log("1" + this.results);
      console.log("SUCCESS");
    },(error:any)=>{
      console.log("Error");
    })
    this._apiService.getPreviousChats2(this.logged_in_id).subscribe((ress:any)=>{

      this.results2=ress;
      console.log(ress);
      console.log("2" + this.results2);


      console.log("SUCCESS");
    },(error:any)=>{
      console.log("Error");
    })
  }




  goToChats(id: any,email: any){
    console.log("Where is the id111  ? :O", id);
    this._apiService.getEmail(this.id).subscribe((res:any)=>{

      this.results3=res;
      console.log(res);
      console.log("33" + this.results3);


      console.log("SUCCESS");
    },(error:any)=>{
      console.log("Error");
    })
    console.log("Where is the email  ? :O", email);

    this.router.navigate(['chat-area', JSON.stringify(id), JSON.stringify(email)]);

  }

  }
