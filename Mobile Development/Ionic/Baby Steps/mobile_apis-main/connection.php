<?php
$server = "localhost";
$username = "root";
$password = "";
$dbname = "baby_steps_db";

$connection = new mysqli($server, $username, $password, $dbname);

if($connection->connect_error){
	die("failed");
}
?>