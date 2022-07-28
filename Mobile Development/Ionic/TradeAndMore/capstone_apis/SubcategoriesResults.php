<?php
session_start();
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";

$data = json_decode(file_get_contents("php://input"));
$id=$_GET["category_id"];
$query = "SELECT subcategories.subcategory_id,subcategory_name
FROM categories_and_subcategories 
INNER JOIN subcategories
ON categories_and_subcategories.subcategory_id = subcategories.subcategory_id
 WHERE categories_and_subcategories.category_id=?;";

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


