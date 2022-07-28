<?php
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";

$data = json_decode(file_get_contents("php://input"));

$bidder_id= $_GET["bidder_id"];
$item_id= $_GET["item_id"];
$price = $data->Price;

$query = "INSERT into bids(bidder_id,item_id,item_price) VALUES (?,?,?)";
$stmt = $connection->prepare($query);
$stmt->bind_param("iii", $bidder_id,$item_id,$price);
$stmt->execute();
$json=json_encode($bidder_id);


$connection->close();
?>