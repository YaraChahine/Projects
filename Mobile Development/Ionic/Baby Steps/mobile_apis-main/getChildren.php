<?php
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";
$email = $_GET['email'];

$query = "SELECT * FROM children WHERE email = ?";
$stmt = $connection->prepare($query);
$stmt->bind_param("s", $email);
$stmt->execute();
$results = $stmt->get_result();
$response = [];
    
while($child = $results->fetch_assoc()) {
    $response[] = $child;
} 
$children_json = json_encode($response);
echo $children_json; 
?>