const path = require("path");
const express = require("express");
const multer = require("multer");
const fs = require('fs');
const mongoose = require("mongoose");
const app = express();

let length = 0;
let filesArray = '';

app.set("view engine", "ejs");

console.log(path.join(__dirname, "views"));

app.set("views", path.join(__dirname, "views/"));

app.use('/public', express.static('public'));

app.use(express.urlencoded({ extended: true }));

app.use(express.json());

const DB_Name = "DB";
const URL_Connection = `mongodb://localhost:27017/${DB_Name}`;

mongoose.connect(URL_Connection, (error) => {
  if (error) {
    console.log(error);
    return;
  }
});

const mySchema = new mongoose.Schema({
  image: {
      type: String,
      required: true
    },
  type: {
      type: String,
      required: true
    },
  email: {
      type: String,
      required: true
    },
});

const myModel = mongoose.model("name", mySchema);

app.get("/index", (req, res) => {
  fs.readdir(path.join(__dirname, "public/uploads/"), (err, files) => {
    length = files.length;
    filesArray = files;
  
  });
  res.render("index", { length: length , files: filesArray });
});

app.get("", (req, res) => {

  res.render("splashScreen");
});

app.get("/history", (req, res) => {
  var count = 0;
  var typeCount = 0;
  myModel.find({}, function (err, results) {
    if (err) console.log(err); 
    if (results.length) {
      message = undefined;
    var query = myModel.find();
      query.count(function (err, count) {
      if (err) console.log(err)
      else     
      myModel.find({type: 'Flowchart'}, function (err, newResults) {
        typeCount = newResults.length;
        res.render("history", { results, count, typeCount, message });
});

});
}
  if (!results.length) {
    message = "No submissions yet.";
    res.render("history", { results, count, typeCount, message });
}
});
});

const storageWay = multer.diskStorage({
    destination: function (req, file, callbackFct) {
      callbackFct(null, "public/uploads/");
    },
    filename: function (req, file, callbackFct) {
      callbackFct(null, Date.now() + file.originalname ); 
    },
  });

const upload = multer({ storage: storageWay,
  fileFilter: function (req, file, callback) {
    var ext = path.extname(file.originalname);
    if(ext !== '.png' && ext !== '.jpg' && ext !== '.gif' && ext !== '.jpeg') {
        return callback(new Error('Only images are allowed'))
      }
    callback(null, true)
  }, });

app.post("/uploadFile", upload.single("uploadedFile"), (req, res) => {
  const newUpload = new myModel({
    image: req.file.path,
    type: req.body.type,
    email: req.body.email
  });
  
  newUpload.save((err, result) => {
    if (err) {
      console.log(err);
      return;
    }
  
    });
    res.send('<h1>Your submission has been received! Expect an email shortly.</h1> <a style="text-decoration:none;" href="./index">Go back</a>    ');
  });

app.get("/updateSubmission", (req, res) => {
  myModel.findById({ _id: req.query.id }, (err, result) => {
    if (err) {
      console.log(err);
      return;
    }
    res.render("updateSubmission", { ID: req.query.id, result: result });
  });
});


app.post("/updateSubmission", upload.single("uploadedFile"), (req, res) => {
  const ID= req.body.ID;
  const image = req.file.path;
  const type = req.body.type;
  const email = req.body.email;
    
  myModel.findByIdAndUpdate(ID,{image: image, type:type, email:email},
    (err, response)=>{
      res.redirect("/index");
    });

});

app.delete("/deleteSubmission", (req, res) => {
  myModel.deleteOne({ _id: req.body.ID }, (err, result) => {
    if (err) {
      console.log(err); 
      return;
    }
    res.send(`Success!`);
    });
});

app.get("/*", (req, res) => {
  res.status(404).send("Page not found");
});

const server = app.listen(8081, function () {
  const port = server.address().port;
  console.log(`app listening at  ${port}`);
});



