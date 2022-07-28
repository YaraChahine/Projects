<?php

header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";

$data = json_decode(file_get_contents("php://input"));


$id = $_GET["id"];



//this api is responible of selecting a quote form the uqotes table whose id
//is the random number generated in the front end
//it then returns the uqote to the front end
$query = "SELECT * FROM quotes WHERE quote_id = ?";
$stmt = $connection->prepare($query);
$stmt->bind_param("i", $id);
$stmt->execute();
$results = $stmt->get_result();
$row = $results->fetch_assoc();

$stmt->close();
$connection->close();
    

    $json = json_encode($row);
    echo $json;


?>