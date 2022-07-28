<?php
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";

$data = json_decode(file_get_contents("php://input"));
$id=$_GET["id"];
$query = "SELECT * from pending_requests 
left join items
on pending_requests.sender_user_id=items.user_id 
inner join users 
on pending_requests.sender_user_id=users.user_id 
where pending_requests.receiver_user_id=?
GROUP by pending_requests.pending_request_id
order by request_date DESC ";
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







?>

