
  <?php
session_start();
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";

$sender_id=$_GET["sender_id"];
$receiver_id=$_GET["receiver_id"];
$review=$_GET["review"];
$rating=floatval($_GET["rating"]);


$request_id=$_GET["request"];

$query = "INSERT INTO feedback(sender_id,receiver_id,review,rating) values (?,?,?,?);";
$stmt = $connection->prepare($query);
$stmt->bind_param("iisd", $sender_id,$receiver_id,$review,$rating);
$stmt->execute();
$results = $stmt->get_result();
$stmt->close();

$query = "UPDATE pending_requests
SET review_written = 1
WHERE pending_request_id=?";
$stmt = $connection->prepare($query);
$stmt->bind_param("i", $request_id);
$stmt->execute();
$results = $stmt->get_result();
$stmt->close();

$connection->close();


$json1=json_encode($sender_id);

echo  $json1;


