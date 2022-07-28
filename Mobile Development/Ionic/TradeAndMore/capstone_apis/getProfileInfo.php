<?php
session_start();
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";

$data = json_decode(file_get_contents("php://input"));
$email=$_GET["email"];
$query = "SELECT first_name,last_name,phone_number,email,location,wishlist,photo FROM users WHERE email = ?";
$stmt = $connection->prepare($query);

$stmt->bind_param("s", $email);
$stmt->execute();
$results = $stmt->get_result();
$row = $results->fetch_assoc();
$stmt->close();
$connection->close();

$json=json_encode($row);

echo $json;






?>