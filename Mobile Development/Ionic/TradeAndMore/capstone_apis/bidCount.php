<?php
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";

$data = json_decode(file_get_contents("php://input"));
$id=$_GET["item_id"];
$query = "SELECT COUNT(*) as count FROM bids WHERE item_id = ?";
$stmt = $connection->prepare($query);

$stmt->bind_param("i", $id);
$stmt->execute();
$results = $stmt->get_result();
$row = $results->fetch_assoc();
$stmt->close();
$connection->close();

$json=json_encode($row);

echo $json;