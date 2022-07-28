const express = require('express');
const app = express();
const multer = require("multer");
const path = require("path");
var session = require('express-session');
var bodyParser = require('body-parser');
var crypto = require('crypto');

app.set("view engine", "ejs");
app.set('views', path.join(__dirname, 'views'));

app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(express.static(__dirname));
console.log(__dirname)

app.use(session({
	secret: 'secret',
	resave: true,
	saveUninitialized: true
}));
app.use(bodyParser.urlencoded({extended : true}));
app.use(bodyParser.json());

const MongoClient = require('mongodb').MongoClient;
const connectionURL = "mongodb://localhost:27017/PizzaShopDB";

var dbo; 
MongoClient.connect(connectionURL, function (error, database) {
    if (error) throw error; 
    dbo = database.db("PizzaShopDB");
    dbo.createCollection("customers", function (err, res) {
        if (err) {
            if (err.ok == 0) {
                console.log("Collection already exist...");
                return;
            }
            throw err;
        }
        console.log("Collection customers have been created!");
        dbo.close();
    });
    console.log("Connected successfully to the MongoDB Community server.....");
});

const storageWay = multer.diskStorage({
  destination: function (req, file, callbackFct) {
    callbackFct(null, "CVUploads/");
  },
  filename: function (req, file, callbackFct) {
    callbackFct(null, file.originalname);
  },
});

const upload = multer({ storage: storageWay });

app.get("/",  (req, res) => {
  res.render("index");
});


app.get("/index.ejs", (req, res) => {
    res.render("index");
  });

app.get("/signIn.ejs", (req, res) => {
  res.render("signIn");
  });

app.get("/signUp.ejs", (req, res) => {
  res.render("signUp");
  });

app.get("/aboutUs.ejs", (req, res) => {
  res.render("aboutUs");
  });

app.get("/jobs.ejs", (req, res) => {
  res.render("jobs");
  });

app.get("/ourMenu.ejs", (req, res) => {
  res.render("ourMenu");
  });

app.get("/contactUs.ejs", (req, res) => {
  res.render("contactUs");
});

app.get("/reviews.ejs", (req, res) => {
  MongoClient.connect(connectionURL, (err, db) => {
    if (err) throw err;
        dbo.collection("Reviews").find({}).toArray((err, results) => {
          res.render("reviews",{results: results});
        });
  });


});

app.get("/makeOwnPizza.ejs", (req, res) => {
  if(req.session.loggedin==true){
    res.render("makeOwnPizza");
  }
  else{
    res.send("Please log in to access this page.");
  }
});

app.get("/processLogOut",(req, res) =>{
  if(req.session.loggedin==true){
    req.session.loggedin = false;
    res.render("index");
  }
  else{
    res.send("Please log in before you can log out.");
  }
});

app.get("/processDelete",(req, res) =>{
  if(req.session.loggedin==true){
    req.session.loggedin = false;
    res.render("index");
    MongoClient.connect(connectionURL, (err, db) => {
      if (err) throw err;
      MongoClient.connect(connectionURL, (err, db) => {
      dbo.collection("Users").deleteOne({Email: req.session.Email}, (err, result) => {
    });
  });
});
  }
  else{
    res.send("Please log in before you can delete the account.");
  }
});

app.get("/processUpdate",(req, res) =>{
  if(req.session.loggedin==true){
    res.render("updateAccount");
  }
  else{
    res.send("Please log in before you can update the account.");
  }
});

app.post("/processUpdateAcc",(req, res) =>{
  var Username = req.body.Username;
  MongoClient.connect(connectionURL, (err, db) => {

    if (err) throw err;
    const oldQuery = { Email: req.session.Email };
    const newQuery = {$set:{ Username: Username,Email: req.session.Email  }};
    dbo.collection("Users").updateOne(oldQuery, newQuery, (err, result) => {
      if (err) throw err;
      res.render("updateAccount");
    });
});
});
app.post("/processSignInForm", (req, res) => {
	var Email = req.body.Email;
  var Password = req.body.Password;
  var hash = crypto.createHash('md5').update(Password).digest('hex');
  MongoClient.connect(connectionURL, (err, db) => {
    // dbo.collection("Users").find({Email: Email},{_id: 0, Email: 0, Username: 1, Password : 0}).toArray(function (err, results) {
    //   req.session.Username = results;
    // });
        if (err) throw err;
        dbo.collection("Users").find({Email: Email,Password: hash}).toArray((err, results) => {
          if (results.length==1) {
              req.session.loggedin = true;
              req.session.Email = Email;
              res.redirect('/index.ejs');
              if (err) throw err;
              db.close();
              return;
          }
          if (results.length==0){
            res.send('Wrong username or password.');	
          }
    });
    
    });
  });

app.post("/processSignUpForm", (req, res) => {
  var Email = req.body.Email;
  var Username = req.body.Username;
  var Password = req.body.Password;
  var hash = crypto.createHash('md5').update(Password).digest('hex');
  const myOBJToInsert = { Email: Email, Username: Username, Password: hash };
  MongoClient.connect(connectionURL, function (err, db) {
    if (err) throw err;
    dbo.collection("Users").find({Email: Email}).toArray((err, results) => {
      if (results.length==0) {
        dbo.collection("Users").insertOne(myOBJToInsert, (err, result) => {
          req.session.loggedin = true;
          req.session.Email = Email;
          req.session.Username = Username;
          res.redirect('/index.ejs');
          if (err) throw err;
          db.close();
          return;
      });
      }
      if (results.length!=0){
      res.send('Email already taken.');	
      }
});

});
});
app.post("/processJobForm", upload.single("CV"), (req, res) => {
  res.render(`<p>You have sent me:
</p>`);
// Name : ${req.query.Name}
// Email : ${req.query.Email}
// Phone Number: ${req.query.phoneNum}
// date: ${req.query.orderDate}
// orderAddress: ${req.query.orderAddress}
// pizzaChosen: ${req.query.pizzaChosen}
// CV: ${req.query.CV}
});

app.get("/processOrderForm", (req, res) => {
  res.render(`<p>You have sent me:
  Name : ${req.query.Name}
  Email : ${req.query.Email}
  Phone Number: ${req.query.phoneNum}
  date: ${req.query.orderDate}
  orderAddress: ${req.query.orderAddress}
  pizzaChosen: ${req.query.pizzaChosen}
</p>`);
});

app.get("/processReviewForm", (req, res) => {
  res.render(`<p>You have sent me:
  Name : ${req.query.Name}
  Email : ${req.query.Email}
  Phone Number: ${req.query.phoneNum}
  review: ${req.query.review}
</p>`);
});

app.get("/*", (req, res) => {
  res.status(404).send("Page not found");
});
const myServer = app.listen(8081, () =>{ 
    console.log("Server is running - waiting for connections from web browsers...");    
    console.log(`Look server port is: ${myServer.address().port}`);
    console.log(`Look server address is: ${myServer.address().address}`);
});
