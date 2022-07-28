<?php
session_start();
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";

$data = json_decode(file_get_contents("php://input"));
$logged_id=$_GET["id1"];
$id= $_GET["id2"];
$query = "SELECT * FROM chat where sender_id=? AND receiver_id=? OR sender_id=? AND receiver_id=?;";
$stmt = $connection->prepare($query);

$stmt->bind_param("iiii", $logged_id,$id,$id,$logged_id);
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

