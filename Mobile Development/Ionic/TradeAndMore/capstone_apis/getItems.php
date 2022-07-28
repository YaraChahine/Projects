<?php
session_start();
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";

$id=$_GET["id"];

$query = "SELECT item_id,user_id,item_name,item_image,item_category,item_subcategory,item_description,item_type,item_price,date_uploaded
FROM items
WHERE user_id=?
order by date_uploaded DESC
;";
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


