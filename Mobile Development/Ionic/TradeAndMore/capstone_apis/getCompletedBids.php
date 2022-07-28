<?php
session_start();
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";

$data = json_decode(file_get_contents("php://input"));
$id=$_GET["id"];
$query = "SELECT bids.item_price,bids.date,users.first_name,users.last_name,items_bid.is_active,items_bid.item_id,items_bid.item_name
FROM bids INNER JOIN items_bid INNER JOIN users WHERE bids.item_id=items_bid.item_id 
AND items_bid.user_id=? AND bids.bidder_id=users.user_id ORDER by bid_id;";
$stmt = $connection->prepare($query);

$stmt->bind_param("i", $id);
$stmt->execute();
$results = $stmt->get_result();
$rows=[];
while($row=$results->fetch_assoc()){
    $rows[]=$row;
}
  
$stmt->close();
$connection->close();

$json=json_encode($rows);

echo $json;
