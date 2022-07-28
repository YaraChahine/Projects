<?php
session_start();
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";

$id=$_GET["id"];

$query = "DELETE from items where item_id=?
;";
$stmt = $connection->prepare($query);
$stmt->bind_param("i", $id);
$stmt->execute();
$results = $stmt->get_result();

  
$stmt->close();
$connection->close();

$json=json_encode($id);

echo $json;


