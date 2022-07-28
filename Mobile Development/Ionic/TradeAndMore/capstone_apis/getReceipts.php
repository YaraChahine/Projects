<?php
session_start();
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";

$id=$_GET["id"];

$query = "SELECT *
FROM receipts
WHERE sender_user_id=? or receiver_user_id=?
order by receipt_date DESC
;";
$stmt = $connection->prepare($query);
$stmt->bind_param("ii",$id, $id);
$stmt->execute();
$results = $stmt->get_result();
$rows=[];
while($row=$results->fetch_assoc()){
    $rows[]=$row;
}
  
$stmt->close();
$connection->close();

$json=json_encode($rows);

echo $json;


