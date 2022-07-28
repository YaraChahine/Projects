<?php
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');
header('Access-Control-Allow-Headers: GET, POST, PUT, DELETE, OPTIONS');
include "connection.php";

$data = json_decode(file_get_contents("php://input"));

$id=$_GET["id1"];
$logged_id= $_GET["id2"];
$query = "DELETE from followers WHERE followedby = $logged_id AND follows=$id";

$msg = " record deleted successfully";
$json=json_encode($msg);
if ($connection->query($query) === TRUE) {
    echo $json;
  } else {
    echo "Error: " . $sql . "<br>" . $connection->error;
  }

$connection->close();