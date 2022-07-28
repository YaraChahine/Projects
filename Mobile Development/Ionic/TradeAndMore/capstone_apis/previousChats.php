<?php
session_start();
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";

$data = json_decode(file_get_contents("php://input"));
$logged_id=$_GET["id"];
$query = "SELECT DISTINCT(chat.sender_id) as id,users.email,users.first_name,users.last_name,users.photo FROM chat INNER JOIN users where chat.sender_id=? AND users.user_id=chat.receiver_id OR chat.receiver_id=? AND users.user_id=chat.sender_id";
$stmt = $connection->prepare($query);

$stmt->bind_param("ii", $logged_id,$logged_id);
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
