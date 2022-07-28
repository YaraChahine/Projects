<?php
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";

$data = json_decode(file_get_contents("php://input"));

$username = $data->username;
$email = $data->email;
$password = hash("sha256", $data->password);



$query = "SELECT * FROM users WHERE email = ?";
$stmt = $connection->prepare($query);
$stmt->bind_param("s", $email);
$stmt->execute();
$results = $stmt->get_result();
$row = $results->fetch_assoc();
$stmt->close();
if(!empty($row)) {
    echo "";
} else {
    $query = "INSERT INTO users(username,email,password) VALUES (?,?,?)";
    $stmt = $connection->prepare($query);
    $stmt->bind_param("sss", $username,$email,$password);
    $stmt->execute();
    $json = json_encode($email);
    echo $json;
    $stmt->close();
    $connection->close();

}