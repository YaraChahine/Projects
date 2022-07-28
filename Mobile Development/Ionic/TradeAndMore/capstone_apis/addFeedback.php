
  <?php
session_start();
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";

$sender_id=$_GET["sender_id"];
$receiver_id=$_GET["receiver_id"];
$review=$_GET["review"];
$rating=floatval($_GET["rating"]);


$request_id=$_GET["request"];

$query = "INSERT INTO feedback(sender_id,receiver_id,review,rating) values (?,?,?,?);";
$stmt = $connection->prepare($query);
$stmt->bind_param("iisd", $sender_id,$receiver_id,$review,$rating);
$stmt->execute();
$results = $stmt->get_result();
$stmt->close();




$query = "SELECT * from pending_requests 
inner join items
on pending_requests.receiver_user_id=items.user_id 
inner join users 
on pending_requests.receiver_user_id=users.user_id 
where pending_requests.sender_user_id=? and pending_requests.receiver_item_id=items.item_id and pending_requests.pending_request_id=?;";
$stmt = $connection->prepare($query);
$stmt->bind_param("ii", $receiver_id,$request_id);
$stmt->execute();
$results = $stmt->get_result();
$request=$results->fetch_assoc();
$stmt->close();




$query="SELECT user_id, first_name,last_name,email,phone_number,photo from users where user_id=?";
$stmt = $connection->prepare($query);
$stmt->bind_param("i", $sender_id);
$stmt->execute();
$results = $stmt->get_result();
$receiver_user_info=$results->fetch_assoc();
$receiver_name=$receiver_user_info["first_name"]." ".$receiver_user_info["last_name"];
$stmt->close();


$stmt = $connection->prepare($query);
$stmt->bind_param("i", $receiver_id);
$stmt->execute();
$results = $stmt->get_result();
$sender_user_info=$results->fetch_assoc();
$sender_name=$sender_user_info["first_name"]." ".$sender_user_info["last_name"];

$stmt->close();



$query="SELECT * from items where item_id=?";
$stmt = $connection->prepare($query);
$stmt->bind_param("i", $request["receiver_item_id"]);
$stmt->execute();
$results = $stmt->get_result();
$receiver_item_info=$results->fetch_assoc();
$stmt->close();

$stmt = $connection->prepare($query);
$stmt->bind_param("i", $request["sender_item_id"]);
$stmt->execute();
$results = $stmt->get_result();
$sender_item_info=$results->fetch_assoc();
$stmt->close();

$query="SELECT * from types where type_id=?";
$stmt = $connection->prepare($query);
$stmt->bind_param("i", $receiver_item_info["item_type"]);
$stmt->execute();
$results = $stmt->get_result();
$type_info=$results->fetch_assoc();
$stmt->close();




$query = "INSERT INTO receipts(sender_user_id,sender_name,sender_email,sender_phone_number,sender_photo,receiver_user_id,receiver_name,receiver_email,
receiver_phone_number,receiver_photo,exchange_type_id,exchange_type_name,sender_item_id,sender_item_name,sender_item_image,receiver_item_id,
receiver_item_name,receiver_item_image,receiver_item_price,request_date)	
 values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
$stmt = $connection->prepare($query);
$stmt->bind_param("issssissssisississis", $sender_user_info["user_id"],$sender_name,$sender_user_info["email"],$sender_user_info["phone_number"],$sender_user_info["photo"],
$receiver_user_info["user_id"],$receiver_name,$receiver_user_info["email"],$receiver_user_info["phone_number"],$receiver_user_info["photo"],$type_info["type_id"],$type_info["type_name"],
$sender_item_info["item_id"],$sender_item_info["item_name"],$sender_item_info["item_image"],
$receiver_item_info["item_id"],$receiver_item_info["item_name"],$receiver_item_info["item_image"],$receiver_item_info["item_price"],$request["request_date"]);
$stmt->execute();
$results = $stmt->get_result();
$stmt->close();




mail($sender_user_info["email"],"Request Accepted","Dear ".$sender_name.",\n\n".
$receiver_name." has accepted your request to receive their '".$receiver_item_info["item_name"]."'.",'From: tradeandmore.customerservice@gmail.com');




$query = "UPDATE pending_requests
SET request_status = 1
WHERE pending_request_id=?";
$stmt = $connection->prepare($query);
$stmt->bind_param("i", $request_id);
$stmt->execute();
$results = $stmt->get_result();
$stmt->close();


$query="DELETE FROM items where item_id=?";
$stmt = $connection->prepare($query);
$stmt->bind_param("i", $request["receiver_item_id"]);
$stmt->execute();
$results = $stmt->get_result();
$stmt->close();

if ($type_info["type_id"]==1||$type_info["type_id"]==4){
$query="DELETE FROM items where item_id=?";
$stmt = $connection->prepare($query);
$stmt->bind_param("i", $request["sender_item_id"]);
$stmt->execute();
$results = $stmt->get_result();
$stmt->close();
}


if ($type_info["type_id"]==3 && $request["sender_item_id"]!=null){
  $query="DELETE FROM items where item_id=?";
  $stmt = $connection->prepare($query);
  $stmt->bind_param("i", $request["sender_item_id"]);
  $stmt->execute();
  $results = $stmt->get_result();
  $stmt->close();
  }



  if ($type_info["type_id"]!=5){

    $query = "UPDATE users
    SET trades_sales_counter = trades_sales_counter+1
    WHERE user_id=?";
    $stmt = $connection->prepare($query);
    $stmt->bind_param("i", $sender_id);
    $stmt->execute();
    $results = $stmt->get_result();
    $stmt->close();


    $query = "UPDATE users
    SET trades_sales_counter = trades_sales_counter+1
    WHERE user_id=?";
    $stmt = $connection->prepare($query);
    $stmt->bind_param("i", $receiver_id);
    $stmt->execute();
    $results = $stmt->get_result();
    $stmt->close();


  }

  if ($type_info["type_id"]!=5){


    $query = "UPDATE users
    SET donations_counter = donations_counter+1
    WHERE user_id=?";
    $stmt = $connection->prepare($query);
    $stmt->bind_param("i", $sender_id);
    $stmt->execute();
    $results = $stmt->get_result();
    $stmt->close();


  }

  $connection->close();

$json1=json_encode($sender_item_info);

echo  $json1;


