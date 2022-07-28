<?php

header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";

$data = json_decode(file_get_contents("php://input"));
$id=$_GET["id"];
$query = "SELECT *, MAX(bids.item_price) AS max FROM bids INNER JOIN items_bid ON bids.item_id=items_bid.item_id WHERE bids.bidder_id = ? GROUP BY bids.item_id";
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




