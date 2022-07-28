<?php
session_start();
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";



$query = "SELECT *
FROM users
;";
$stmt = $connection->prepare($query);
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


