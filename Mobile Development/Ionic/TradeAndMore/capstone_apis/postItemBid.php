<?php
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";

$query = "INSERT into items_on_bid(item_id,user_id,price) VALUES (1,1,10000)";
$msg = "New record created successfully";

$json=json_encode($msg);
if ($connection->query($query) === TRUE) {
    echo $json;
  } else {
    echo "Error: " . $sql . "<br>" . $connection->error;
  }

$connection->close();
?>