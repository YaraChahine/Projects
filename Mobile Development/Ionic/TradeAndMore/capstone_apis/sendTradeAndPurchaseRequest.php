
  <?php
session_start();
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";

$receiver_user_id=$_GET["receiver_user_id"];
$receiver_item_id=$_GET["receiver_item_id"];
$logged_in_id=$_GET["logged_in_id"];
$logged_in_item_id=$_GET["logged_in_item_id"];
$item_price=$_GET["item_price"];
$text_message= $_GET["text_message"];


$query = "INSERT INTO pending_requests(sender_user_id,receiver_user_id,sender_item_id,receiver_item_id,requested_item_price,
request_msg) values (?,?,?,?,?,?);";
$stmt = $connection->prepare($query);
$stmt->bind_param("iiiiis", $logged_in_id,$receiver_user_id,$logged_in_item_id,$receiver_item_id,$item_price,$text_message);
$stmt->execute();
$results = $stmt->get_result();
$rows=$text_message;
  
$stmt->close();
$connection->close();

$json=json_encode($rows);

echo $json;


