<?php
session_start();

header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";

$data = json_decode(file_get_contents("php://input"));

$email=$_GET["email"];
$password = hash("sha256", $data->Password);
$query = "UPDATE users SET password = ? where email = ?";
$stmt = $connection->prepare($query);
$stmt->bind_param("ss", $password,$email);
$stmt->execute();

    



?>