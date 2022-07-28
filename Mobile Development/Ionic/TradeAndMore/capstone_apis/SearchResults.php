<?php
session_start();
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";

$data = json_decode(file_get_contents("php://input"));
$name=$_GET["name"];
$name_split=[];
$name_split=explode(" ",$name);
$query = "SELECT * FROM users WHERE first_name = ? and last_name = ?";
$stmt = $connection->prepare($query);

$stmt->bind_param("ss", $name_split[0],$name_split[1]);
$stmt->execute();
$results = $stmt->get_result();
$rows=[] ;
while($row=$results->fetch_assoc()){
    $rows[]=$row;
}
$stmt->close();
$connection->close();

$json=json_encode($rows);

echo $json;










