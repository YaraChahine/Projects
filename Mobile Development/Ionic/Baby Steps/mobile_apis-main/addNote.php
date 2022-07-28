<?php
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";


$data = json_decode(file_get_contents("php://input"));
$child_id = $data->child_id;
$button_id = $data->button_id;
$child_note = $data->child_note;
$query = "INSERT INTO memories(child_id,button_id,child_note) VALUES (?,?,?)";
$stmt = $connection->prepare($query);
$stmt->bind_param("dds",$child_id,$button_id ,$child_note);
$stmt->execute();
$stmt->close();
$json = json_encode($child_note);
echo $json;
$connection->close();
?>