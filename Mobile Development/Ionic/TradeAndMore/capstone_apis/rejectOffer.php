<?php
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";

$data = json_decode(file_get_contents("php://input"));
$id=$_GET["id"];




$query = "SELECT * from  pending_requests
WHERE pending_request_id=?;";
$stmt = $connection->prepare($query);

$stmt->bind_param("i", $id);
$stmt->execute();
$results = $stmt->get_result();
$row=$results->fetch_assoc();
$stmt->close();

$query2 = "SELECT S.first_name as first_name_s,S.last_name as last_name_s, R.first_name as first_name_r,
R.last_name as last_name_r, RI.item_name as item_name_r
from users as S, users as R,  items as RI
where S.user_id=? and R.user_id=? and RI.item_id=?;";
$stmt2 = $connection->prepare($query2);

$stmt2->bind_param("iii", $row["sender_user_id"],$row["receiver_user_id"],$row["receiver_item_id"]);
$stmt2->execute();
$results2 = $stmt2->get_result();
$row2=$results2->fetch_assoc();
$stmt2->close();





$query3 = "SELECT email from users where user_id=?";
$stmt3 = $connection->prepare($query3);
$stmt3->bind_param("i",$row["sender_user_id"]);
$stmt3->execute();
$results3 = $stmt3->get_result();
$row3=$results3->fetch_assoc();
$stmt3->close();
mail($row3["email"],"Request Rejected","Dear ".$row2["first_name_r"]." ".$row2["last_name_r"].",\n\n".
$row2["first_name_s"]." ".$row2["last_name_s"]." has rejected your request to receive '".$row2["item_name_r"]."'.",'From: tradeandmore.customerservice@gmail.com');



$query = "UPDATE pending_requests
SET request_status = 2
WHERE pending_request_id=?;";
$stmt = $connection->prepare($query);

$stmt->bind_param("i", $id);
$stmt->execute();
$results = $stmt->get_result();
$stmt->close();
$connection->close();

$json=json_encode($id);

echo $json;







?>

