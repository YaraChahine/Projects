
  <?php
session_start();
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";

$receiver_user_id=$_GET["receiver_user_id"];
$receiver_item_id=$_GET["receiver_item_id"];
$logged_in_id=$_GET["logged_in_id"];
$text_message= $_GET["text_message"];


$query = "INSERT INTO pending_requests(sender_user_id,receiver_user_id,receiver_item_id,
request_msg) values (?,?,?,?);";
$stmt = $connection->prepare($query);
$stmt->bind_param("iiis", $logged_in_id,$receiver_user_id,$receiver_item_id,$text_message);
$stmt->execute();
$results = $stmt->get_result();
$rows=$text_message;
  
$stmt->close();




$query = "SELECT S.first_name as first_name_s,S.last_name as last_name_s, R.first_name as first_name_r,
R.last_name as last_name_r, RI.item_name as item_name_r
from users as S, users as R,  items as RI
where S.user_id=? and R.user_id=? and RI.item_id=?;";
$stmt = $connection->prepare($query);
$stmt->bind_param("iii", $logged_in_id,$receiver_user_id,$receiver_item_id);
$stmt->execute();
$results = $stmt->get_result();
$row=$results->fetch_assoc();
$stmt->close();


$query2 = "SELECT email from users where user_id=?";
$stmt2 = $connection->prepare($query2);
$stmt2->bind_param("i",$receiver_user_id);
$stmt2->execute();
$results2 = $stmt2->get_result();
$row2=$results2->fetch_assoc();
$stmt2->close();
mail($row2["email"],"Donation Request","Dear ".$row["first_name_r"]." ".$row["last_name_r"].",\n\n".
$row["first_name_s"]." ".$row["last_name_s"]." is requesting your '".$row["item_name_r"]."'.",'From: tradeandmore.customerservice@gmail.com');



$connection->close();

$json=json_encode($rows);

echo $json;


