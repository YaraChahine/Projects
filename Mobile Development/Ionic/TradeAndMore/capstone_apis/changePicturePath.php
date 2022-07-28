<?php
session_start();

header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";

$data = json_decode(file_get_contents("php://input"));

$email=$_GET["email"];
$path=$_GET["path"];

            $query = "UPDATE users SET photo = ? where email = ?";
            $stmt = $connection->prepare($query);
            $stmt->bind_param("ss",$path,$email);
            $stmt->execute();



            $stmt->close();
            $connection->close();