import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';

let getID = '';
export interface User{
  user_id?: number;
  FirstName: string;
  LastName: string;
  Email: string;
  PhoneNumber: number;
  Password: string;
  Location: string;
  Wishlist?: string;
  Photo?: string;
}




export interface Item{

  item_name: string;
  item_image: string;
  item_category_name: string;
  item_subcategory_name: string;
  item_description: string;
  item_type: string;
  item_price:any;
}


export interface message{

  message_id: any;
  sender_id: any;
  receiver_id: any;
  message: string;
}
@Injectable({
  providedIn: 'root'
})
export class MyAPIsService {



  private url = 'http://localhost/capstone_apis/';

  constructor(private http: HttpClient) {

  }
  checkUser(user: User){
    return this.http.post(this.url + 'logIn.php', user);
  }
  addUser(user: User){
    return this.http.post(this.url + 'SignUp.php', user);
  }

  getUserName(email: string){
    return this.http.get(this.url + 'profilePage.php?email='+email);
  }

  getSearchResults(name: string){
    return this.http.get(this.url + 'SearchResults.php?name='+name);

  }

  getFollowing(id: any){
    return this.http.get(this.url + 'FollowingResults.php?id='+id);

  }

  getFollowers(id: any){
    return this.http.get(this.url + 'FollowersResults.php?id='+id);

  }

  follow(id: any,logged_in_id : any){
    return this.http.get(this.url + 'FollowerUser.php?id1='+id+'&id2='+logged_in_id);

  }
  unfollow(id: any,logged_in_id: any){
    return this.http.get(this.url + 'UnfollowUser.php?id1='+id+'&id2='+logged_in_id);

  }
  getFollowersList(id : any){
    return this.http.get(this.url + 'FollowersListResults.php?id='+id);
  }

  getFollowingList(id : any){
    return this.http.get(this.url + 'FollowingListResults.php?id='+id);
  }


  getCategories() {
    return this.http.get(this.url + 'CategoriesResults.php');

  }



  getTypes() {
    return this.http.get(this.url + 'typesResults.php');

  }



  getSubCategories(category_id : any) {
    return this.http.get(this.url + 'SubcategoriesResults.php?category_id='+category_id);

  }

  postImage(formData){
    return this.http.get(this.url + 'postImageResults.php?img_file='+formData);

  }


  addItem(item,id){
    return this.http.post(this.url + 'addItem.php?user_id='+id,item);

  }

  postItem(){
    return this.http.get(this.url + 'postItemBid.php');
  }
  getItem(logged_in_id: any){
    return this.http.get(this.url + 'getItem.php?id=' +logged_in_id);
  }
  getUserInfo(logged_in_id){
    return this.http.get(this.url + 'getUserInfo.php?id=' +logged_in_id);

  }

  getItems(logged_in_id: any){
    return this.http.get(this.url + 'getItems.php?id=' +logged_in_id);
  }

  getReceiverItem(id){
    return this.http.get(this.url + 'getReceiverItem.php?id=' +id);

  }
  getFollowingsPosts(logged_in_id: any){
    return this.http.get(this.url + 'followingsPosts.php?followedby=' +logged_in_id);
  }

  deleteBid(item_id: any){
    return this.http.get(this.url + 'deleteBid.php?item_id=' +item_id);
}

getProfileInfo(email: string){
  return this.http.get(this.url + 'getProfileInfo.php?email='+email);
}
editProfileInfo(user: User){
  return this.http.post(this.url + 'editProfileInfo.php', user);
}
changePassword(email: string,user){
  return this.http.post(this.url + 'updatePassword.php?email='+email,user);

}
changePicture(email: string,user){
  return this.http.post(this.url + 'changePicture.php?email='+email,user);

}
sendMessage(logged_in_id: any,id: any,message){
  return this.http.post(this.url + 'sendMessage.php?id1='+logged_in_id+'&id2='+id,message);

}
getChatMessages(logged_in_id: any,id: any){
  return this.http.get(this.url + 'getChatMessages.php?id1='+logged_in_id+'&id2='+id);

}
getPreviousChats(logged_in_id: any){
  return this.http.get(this.url + 'previousChats.php?id='+logged_in_id);

}

getPreviousChats2(logged_in_id: any){
  return this.http.get(this.url + 'previousChats2.php?id='+logged_in_id);

}
getEmail(id: any){
  return this.http.get(this.url + 'getEmail.php?id='+id);

}

sendRequest(receiver_user_id,receiver_item_id,logged_in_id,logged_in_item_id,text_message){
  return this.http.get(this.url + 'sendRequest.php?receiver_user_id=' +receiver_user_id+'&receiver_item_id='+receiver_item_id+
  '&logged_in_id='+logged_in_id+'&logged_in_item_id='+logged_in_item_id+'&text_message='+text_message);

}

sendDonationRequest(receiver_user_id,receiver_item_id,logged_in_id,text_message){
  return this.http.get(this.url + 'sendDonationRequest.php?receiver_user_id=' +receiver_user_id+'&receiver_item_id='+receiver_item_id+
  '&logged_in_id='+logged_in_id+'&text_message='+text_message);

}
getRequests(id){
  return this.http.get(this.url + 'getRequests.php?id=' +id);

}

getSentRequests(id){
  return this.http.get(this.url + 'sentRequests.php?id=' +id);

}


sendPurchaseRequest(receiver_user_id,receiver_item_id,logged_in_id,text_message){
  return this.http.get(this.url + 'sendPurchaseRequest.php?receiver_user_id=' +receiver_user_id+'&receiver_item_id='+receiver_item_id+
  '&logged_in_id='+logged_in_id+'&text_message='+text_message);

}
sendTradeAndPurchaseRequest(receiver_user_id,receiver_item_id,logged_in_id,logged_in_item_id,item_price,text_message){
  return this.http.get(this.url + 'sendTradeAndPurchaseRequest.php?receiver_user_id=' +receiver_user_id+'&receiver_item_id='+receiver_item_id+
  '&logged_in_id='+logged_in_id+'&logged_in_item_id='+logged_in_item_id+'&item_price='+item_price+'&text_message='+text_message);

}


RejectOffer(id){
  return this.http.get(this.url + 'rejectOffer.php?id=' +id);

}
addFeedback(sender_id,receiver_id,review,rating,request){
  return this.http.get(this.url + 'addFeedback.php?sender_id=' +sender_id+'&receiver_id='+receiver_id+'&review='+review+'&rating='+rating+'&request=' + request);

}

addFeedback2(sender_id,receiver_id,review,rating,request){
  return this.http.get(this.url + 'addFeedback2.php?sender_id=' +sender_id+'&receiver_id='+receiver_id+'&review='+review+'&rating='+rating+'&request=' + request);

}


getReceipts(id){
  return this.http.get(this.url + 'getReceipts.php?id=' +id);

}
getReviews(id){
  return this.http.get(this.url + 'getReviews.php?id=' +id);

}
getUsers(){
  return this.http.get(this.url + 'getUsers.php');

}

getAllitems(){
  return this.http.get(this.url + 'getAllitems.php');

}

removeItem(item_id){
  return this.http.get(this.url + 'removeItem.php?id='+item_id);
}
  getLocation(id){
  return this.http.get(this.url + 'getLocation.php?id=' +id);

}
getSuggestedUsers(location : string, id: any){
  return this.http.get(this.url + 'getSuggestedUsers.php?location=' +location+'&id='+id);

}

addItemBid(item,id){
  return this.http.post(this.url + 'addItemBid.php?user_id='+id,item);

}
getMyItemsBid(logged_in_id: any){
  return this.http.get(this.url + 'getMyItemsBid.php?id=' +logged_in_id);
}
getFollowersItemsBid(logged_in_id: any){
  return this.http.get(this.url + 'getFollowersItemsBid.php?id=' +logged_in_id);

}
postBid(item, logged_in_id: any, item_id: any){
  return this.http.post(this.url + 'postBid.php?bidder_id=' +logged_in_id +'&item_id='+item_id,item);
}
getLastBid(item_id: any){
  return this.http.get(this.url + 'getLastBid.php?item_id=' +item_id);

}
getBidsCount(item_id: any){
  return this.http.get(this.url + 'bidCount.php?item_id=' +item_id);

}
getMyBids(id: any){
  return this.http.get(this.url + 'getMyBids.php?id=' +id);

}

getItemsCounter(id) {
  return this.http.get(this.url + 'getItemsCounter.php?id='+id);
}

getMax(id: any ,item_id: any) {
  return this.http.get(this.url + 'getMax.php?id='+id);
}
getLastBids(item_id: any){
  return this.http.get(this.url + 'getLastBids.php?item_id=' +item_id);

}
getCompletedBids(id: any){
  return this.http.get(this.url + 'getCompletedBids.php?id=' +id);

}
}
