<?php

session_start();

header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Content-Type');

include "connection.php";

$data = json_decode(file_get_contents("php://input"));

$email=$_GET["email"];

if (isset($_FILES["img_file"]) && $_FILES["img_file"]["error"] != UPLOAD_ERR_NO_FILE) {
    $img_file = (str_replace(".", "", microtime(true)));
    $ext = pathinfo($_FILES["img_file"]["name"], PATHINFO_EXTENSION);
    $img_file = $img_file . "." . $ext;
    $tempname = $_FILES["img_file"]["tmp_name"];
   
    $folder = 'profileImages/'.$img_file;
   
    $mime = mime_content_type($tempname);
$type = substr($mime, 0, strpos($mime, "/")); 
   
    if ((strcasecmp($type, "image") == 0)) {
        if (!move_uploaded_file($tempname, $folder))  {
          $invalid=true;
          $msg="Error in saving image file to server, try again";
         
        }
        $path= 'http://localhost/capstone_apis/'.$folder;
            $query = "UPDATE users SET photo = ? where email = ?";
            $stmt = $connection->prepare($query);
            $stmt->bind_param("ss",$path,$email);
            $stmt->execute();



            $stmt->close();
            $connection->close();

            
           
    }
    else {
      $invalid=true;
      $msg="Invalid image file.";
    }
} else {
  $invalid=true;
  $msg="Please upload a photo";
}


$row = array('path' => $path);

$json = json_encode($row);
echo $json;


    



?>