<?php
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";
$child_id = $_GET['child_id'];
$button_id = $_GET['button_id'];

$query = "SELECT * FROM memories WHERE child_id = ? and button_id = ?";
$stmt = $connection->prepare($query);
$stmt->bind_param("dd", $child_id, $button_id);
$stmt->execute();
$results = $stmt->get_result();
$response = [];
    
while($child = $results->fetch_assoc()) {
    $response[] = $child;
} 
$children_json = json_encode($response);
echo $children_json; 
?>