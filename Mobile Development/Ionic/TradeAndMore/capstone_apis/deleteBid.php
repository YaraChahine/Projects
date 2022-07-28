<?php
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');
header('Access-Control-Allow-Headers: GET, POST, PUT, DELETE, OPTIONS');
include "connection.php";

$data = json_decode(file_get_contents("php://input"));

$item_id= $_GET["item_id"];

$query = "UPDATE items_bid SET is_active = 0 WHERE item_id = $item_id";

$msg = " record deleted successfully";
$json=json_encode($msg);
if ($connection->query($query) === TRUE) {
    echo $json;
  } else {
    echo "Error: " . $sql . "<br>" . $connection->error;
  }

$connection->close();