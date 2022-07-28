<?php
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";


$data = json_decode(file_get_contents("php://input"));
$email = $data->email;
$child_name = $data->child_name;
$child_gender = $data->child_gender;
$query = "INSERT INTO children(email,child_name,child_gender) VALUES (?,?,?)";
$stmt = $connection->prepare($query);
$stmt->bind_param("sss",$email,$child_name,$child_gender);
$stmt->execute();
$stmt->close();
$json = json_encode($child_name);
echo $json;
$connection->close();
?>