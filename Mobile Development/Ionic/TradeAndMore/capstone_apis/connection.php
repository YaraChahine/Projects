<?php
$server = "localhost";
$username = "root";
$password = "";
$dbname = "trade_and_more_db";

$connection = new mysqli($server, $username, $password, $dbname);

if($connection->connect_error){
	die("failed");
}
?>