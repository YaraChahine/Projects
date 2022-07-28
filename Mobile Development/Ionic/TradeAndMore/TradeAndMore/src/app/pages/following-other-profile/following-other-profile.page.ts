import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MyAPIsService } from 'src/app/services/my-apis.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-following-other-profile',
  templateUrl: './following-other-profile.page.html',
  styleUrls: ['./following-other-profile.page.scss'],
})
export class FollowingOtherProfilePage implements OnInit {
  results : any=[];
  id: any;
  email: any;
  myFollowings : any=[];
  logged_in_id: any;

  constructor(private route: ActivatedRoute,private router: Router,private service: MyAPIsService) {
      this.id = JSON.parse(this.route.snapshot.paramMap.get('id'));
      this.email = JSON.parse(this.route.snapshot.paramMap.get('email'));

    }
  ngOnInit() {
    this.logged_in_id=localStorage.getItem("logged-in-user-id");
    this.myFollowings =[];
    this.getFollowingList();
    }
    check(result1: any,result2: any[]) {


      const checkUsername = obj => obj.user_id === result1;
      console.log(result2.some(checkUsername));
      if(result2.some(checkUsername)){
        return 'Yes';
      }else{
        return 'No';
      }
    }


  getFollowingList(){

    this.service.getFollowingList(this.id).subscribe((res:any)=>{
      this.results=res;
      console.log(" following liist SUCCESS",res);
      this.service.getFollowingList(localStorage.getItem("logged-in-user-id")).subscribe((res2:any)=>{
        this.myFollowings=res2;
        console.log("I am following",res2);
      },(error:any)=>{
        console.log("folllowers liiist Error");
      })
    },(error:any)=>{
      console.log("following liiist Error");
    })

  }
  public goTo(email : any,id : any){
    console.log("Where is the email  ? :O", email);
    console.log("Where is the id  ? :O", id);
    if (this.id==this.logged_in_id){
      this.goToProfile();
    }
    else{
    this.router.navigate(['check-profile', JSON.stringify(email),JSON.stringify(id)]);
    }
  }
  public goToProfile(){

    this.router.navigate(['tabs/profile']);
}
public follow(id: any){
  this.logged_in_id=localStorage.getItem("logged-in-user-id");
  console.log('logged in id is : '+ this.logged_in_id + 'other user id ' + id);

  this.service.follow(id,this.logged_in_id).subscribe((res:any)=>{
    this.getFollowingList();

    console.log(" follow SUCCESS",res);
  },(error:any)=>{
    console.log("follow Error");
  })
  this.getFollowingList();

  }

  public unfollow(id: any){
    this.logged_in_id=localStorage.getItem("logged-in-user-id");
    console.log('logged in id is : '+ this.logged_in_id + 'other user id ' + id);

    this.service.unfollow(id,this.logged_in_id).subscribe((res:any)=>{
      this.getFollowingList();

      console.log(" follow SUCCESS",res);
    },(error:any)=>{
      console.log("follow Error");
    })
    this.getFollowingList();

    }
}
