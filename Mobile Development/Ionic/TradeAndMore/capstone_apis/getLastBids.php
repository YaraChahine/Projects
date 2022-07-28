<?php


header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";

$data = json_decode(file_get_contents("php://input"));
$id=$_GET["item_id"];
$query = "SELECT bids.item_price,bids.date,users.first_name,users.last_name FROM bids INNER JOIN items_bid INNER JOIN users WHERE bids.item_id=items_bid.item_id AND bids.item_id=? AND bids.bidder_id=users.user_id ORDER by bid_id DESC limit 10";
$stmt = $connection->prepare($query);

$stmt->bind_param("i", $id);
$stmt->execute();
$results = $stmt->get_result();
while($row=$results->fetch_assoc()){
    $rows[]=$row;
}


$data = $row;
$json=json_encode($rows);

echo $json;
$stmt->close();
$connection->close();