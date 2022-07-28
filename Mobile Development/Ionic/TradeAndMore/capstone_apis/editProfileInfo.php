<?php
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";

$data = json_decode(file_get_contents("php://input"));
$id = $data->ID;
$first_name = $data->FirstName;
$last_name = $data->LastName;
$phone_number = $data->PhoneNumber;
$email = $data->Email;
$location = $data->Location;
$wishlist = $data->Wishlist;

$query = "SELECT * FROM users WHERE email = ? AND NOT user_id = ?";
$stmt = $connection->prepare($query);
$stmt->bind_param("sd", $email, $id);
$stmt->execute();
$results = $stmt->get_result();
$row = $results->fetch_assoc();
$stmt->close();
if(!empty($row)) {
    echo "";
} else{
    $query = "UPDATE users SET first_name = ? , last_name = ? , phone_number = ?, email = ?, location = ?, wishlist = ? WHERE user_id = ?";
    $stmt = $connection->prepare($query);
    $stmt->bind_param("ssdsssd", $first_name,$last_name,$phone_number,$email,$location,$wishlist,$id);
    $stmt->execute();
    $json = json_encode($email);
    echo $json;
    $stmt->close();
    $connection->close();

 
}
?>