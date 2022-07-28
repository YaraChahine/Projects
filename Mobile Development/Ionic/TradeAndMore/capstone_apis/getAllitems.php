<?php
session_start();
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";



$query = "select * from items
inner join users on items.user_id= users.user_id
inner join types on items.item_type=types.type_id
inner join categories on items.item_category=categories.category_id
inner join subcategories on items.item_subcategory=subcategories.subcategory_id";
$stmt = $connection->prepare($query);
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




