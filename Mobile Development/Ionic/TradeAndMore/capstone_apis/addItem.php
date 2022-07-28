<?php

header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');
include "connection.php";


$input = file_get_contents("php://input");
$id= $_GET["user_id"];
$data=json_decode($input,true);




$item_name=            $data['item_name'] ;
$item_image=           $data['item_image'];
$item_category_name=   $data['item_category_name'];
$item_subcategory_name=$data['item_subcategory_name'];
$item_description=     $data['item_description'];
$type_id=            $data['item_type'];
$item_price=           $data['item_price'];



 
$query = "INSERT INTO items(user_id,item_name,item_image,item_category,item_subcategory,item_description,item_type,item_price) VALUES (?,?,?,?,?,?,?,?)";
$stmt = $connection->prepare($query);
$stmt->bind_param("issiisii", $id,$item_name,$item_image,$item_category_name,$item_subcategory_name,$item_description,$type_id,$item_price);
$stmt->execute();
$stmt->close();


$connection->close();

$json = json_encode($type_id);
echo $json;




