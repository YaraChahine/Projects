<?php
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";


$data = json_decode(file_get_contents("php://input"));

$first_name = $data->FirstName;
$last_name = $data->LastName;
$phone_number = $data->PhoneNumber;
$email = $data->Email;
$password = hash("sha256", $data->Password);
$photo = "http://localhost/capstone_apis/profileImages/default.jpg";


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
    $query = "INSERT INTO users(first_name,last_name,phone_number,email,password,photo) VALUES (?,?,?,?,?,?)";
    $stmt = $connection->prepare($query);
    $stmt->bind_param("ssdsss", $first_name,$last_name,$phone_number,$email,$password,$photo);
    $stmt->execute();
    $json = json_encode($email);
    echo $json;
    $stmt->close();
    $connection->close();

}