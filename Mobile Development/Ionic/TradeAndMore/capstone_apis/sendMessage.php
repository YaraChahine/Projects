<?php
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";


$data = json_decode(file_get_contents("php://input"));

$logged_id=$_GET["id1"];
$id= $_GET["id2"];
$message = $data->Message;




$query = "INSERT INTO chat(sender_id,receiver_id,message) VALUES (?,?,?)";
$stmt = $connection->prepare($query);
$stmt->bind_param("dds", $logged_id,$id,$message);
$stmt->execute();
$stmt->close();
$connection->close();

