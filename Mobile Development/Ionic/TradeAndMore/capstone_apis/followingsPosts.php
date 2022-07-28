<?php
session_start();
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";

$data = json_decode(file_get_contents("php://input"));
$id=$_GET["followedby"];
$query = "SELECT U.first_name,U.photo,U.last_name,U.email,I.item_id,I.user_id,I.item_name,I.item_image,I.item_category,I.item_subcategory,I.item_description,I.item_type,I.item_price,I.date_uploaded
from users as U inner join items as I
on U.user_id=I.user_id where U.user_id in(SELECT U.user_id
FROM  followers as F INNER JOIN users as U
ON  F.follows = U.user_id where F.followedby=?) order by I.date_uploaded;";

$stmt = $connection->prepare($query);

$stmt->bind_param("i", $id);
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


