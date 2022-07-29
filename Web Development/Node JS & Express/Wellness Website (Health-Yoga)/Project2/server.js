
const express = require('express');
const path= require('path');
const mongoose = require('mongoose');
const morgan = require('morgan');
const bodyParser = require('body-parser')
const bcrypt = require('bcryptjs')
const jwt = require('jsonwebtoken')
const User = require('./models/Users')
const pending_session = require('./models/PendingSessions')
const confirmed_session = require('./models/ConfirmedSessions')
const testimonial = require('./models/Testimonials')
const image = require('./models/Image');
const recipe = require('./models/Recipes');
var crypto = require('crypto');
const cookieParser = require("cookie-parser");
const sessions = require('express-session');

// creating 24 hours from milliseconds
const oneDay = 1000 * 60 * 60 * 24;


var session;
const app = express(); //create an express app

var multer = require('multer');
  
var storage = multer.diskStorage({
    destination: (req, file, cb) => {
        cb(null, 'uploads')
    },
    filename: (req, file, cb) => {
        cb(null, file.originalname)
    }
});
  
var upload = multer({ storage: storage });
//session middleware
app.use(sessions({
  secret: "thisismysecrctekeyfhrgfgrfrty84fwir767",
  saveUninitialized: true,
  cookie: { maxAge: oneDay },
  resave: false
}));
app.use(cookieParser());
const fs = require("fs"); // To use server file system we need the built in Node js module fs
const { Server } = require("http");

app.use(express.urlencoded({ extended: true }));

app.use(express.json());

mongoose.connect('mongodb://localhost:27017/mydb', { useNewUrlParser: true, useUnifiedTopology: true })
const db = mongoose.connection
db.on('error', (err) => {
  console.log(err)
})

db.once('open', () => {
  console.log('Database Connection Established!')
})


app.use(function (req, res, next) {
  //Access-Control-Allow-Origin response header indicates whether the response can be shared with requesting code from the given origin.
  //For requests without credentials, the literal value "*" can be specified as a wildcard;
  //the value tells browsers to allow requesting code from any origin to access the resource
  res.header("Access-Control-Allow-Origin", "*");
  //Access-Control-Allow-Headers: [<header-name>[, <header-name>]*]
  res.header(
    "Access-Control-Allow-Headers",
    "Origin, X-Requested-With, Content-Type, Accept, Authorization"
  );
  // res.header("Access-Control-Allow-Methods", "PUT, POST, GET, DELETE, OPTIONS");
  //next() means move to the next defined middleware function or to your routes (app.get(), app.post())
  next();
});


app.use(express.static("Public/public"));

//Starts the Web Server and listen to a port
//you specify the port you want to listen on.
// app.listen(3030);
const myServer = app.listen(3022, () => { //myServer is an object that stores server info
  console.log("Server is running - waiting for connections from web browsers...");
  console.log(`Look server port is: ${myServer.address().port}`);
  console.log(`Lokk server address is: ${myServer.address().address}`);
});

app.get("/", function (req, res) {
  console.log("Got a GET request for the index.html!");
  //I can send a file like an HTML, txt, a pdf

  res.sendFile(__dirname + "/Public/public/" + "index.html")

  //res.sendFile(__dirname + "/views/pdf/" + "hello.pdf")

});


app.get("/login", function (req, res) {
  console.log("Got a GET request for the index.html!");
  //I can send a file like an HTML, txt, a pdf

  res.sendFile(__dirname + "/Public/public/" + "login.html")

  //res.sendFile(__dirname + "/views/pdf/" + "hello.pdf")

});




app.get("/signup", function (req, res) {
  console.log("Got a GET request for the index.html!");
  //I can send a file like an HTML, txt, a pdf

  res.render( "signup.ejs", {msg:""});

  //res.sendFile(__dirname + "/views/pdf/" + "hello.pdf")

});
app.post("/register",  upload.single('image'), function (req, res) {
  var saltt = crypto.randomBytes(16).toString('hex');
  User.find({email: req.body.email}, function(err,results){
    if (results.length==0){
      bcrypt.hash(req.body.password, 10, function (err, hashedPass) {
        if (err) {
          res.json({
            error: err
          })
        }
      })
      let user = new User({
        name: req.body.name,
        email: req.body.email,
        phone: req.body.phone,
        salt: saltt,
        hash: crypto.pbkdf2Sync(req.body.password
          , saltt,
          1000, 64, `sha512`).toString(`hex`)
    
      })
      user.save()
        .then(user => {
    
            console.log( ' User Added Successfully!')
          })
        .catch(error => {
          
           console.log( 'An error occured!')
          
        })
    
        let img = new image({
    
          name: req.body.email,
          img: {
              data: fs.readFileSync(path.join(__dirname + '/uploads/' + req.file.filename)),
              contentType: 'image/png'
          }
        })
    
        img.save()
        .then(img => {
      
       console.log(' Image Added Successfully!')
       res.render("account.ejs", {name : req.body.name, items : img})
         
        })
        .catch(error => {
          console.log("image error")
        })
    

    }
    else
    {
      res.render("signup.ejs", {msg : "User Exists"});
    }
  })
  

});




app.post("/account", function (req, res) {
  console.log("Got a GET request for the index.html!");
  //I can send a file like an HTML, txt, a pdf
  // Find user with requested email 
  User.findOne({ email: req.body.email }, function (err, user) {
    if (user === null) {
      return res.status(400).send({
        message: "User not found."
      });
    }
    else {
      if (crypto.pbkdf2Sync(req.body.password,
        user.salt, 1000, 64, `sha512`).toString(`hex`) == user.hash) {
        session = req.session;
        session.name = user.name;
        session.userid = req.body.email;
        if (req.body.email == "yarachahine88@hotmail.com") {
          return res.status(201).render("admin_account.ejs")

        }
        else {
          image.findOne({ 'name': session.userid }, (err, items) => {
            if (err) {
                console.log(err);
                res.status(500).send('An error occurred', err);
            }
            else {
              return res.status(201).render("account.ejs", { name: user.name , items: items });
            }
        });
        }
      }
      else {
        return res.status(400).send({
          message: "Wrong Password"
        });
      }
    }
  })

})

app.get("/bookYoga", (req, res) => {
  session = req.session;
  session.type = "Yoga";
  res.render("session.ejs", { titlename: "Yoga Session" });
});
app.get('/logout', (req, res) => {
  req.session.destroy();
  res.redirect('/');
});


app.get("/bookCounselling", (req, res) => {
  session = req.session;
  session.type = "Counselling";
  res.render("session.ejs", { titlename: "Counselling Session" });
});


app.get('/logout', (req, res) => {
  req.session.destroy();
  res.redirect('/');
});


app.get("/bookDiet", (req, res) => {
  session = req.session;
  session.type = "Diet";
  res.render("session.ejs", { titlename: "Session with Dietitian", photo: "https://st3.depositphotos.com/1832477/13693/v/600/depositphotos_136931152-stock-illustration-glad-smiling-female-dietitian-holding.jpg" });
});


app.post("/book/", (req, res) => {
  session = req.session;
  let sessionbook = new pending_session({

    Sessiontype: session.type,
    name: session.name,
    email: session.userid,
    date: req.body.date,
    time: req.body.time,
    deliveryMethod: req.body.deliveryMethod,
    paymentMethod: req.body.paymentMethod

  })
  sessionbook.save()
    .then(session => {
      res.json({
        message: ' Session Added Successfully!'
      })
    })
    .catch(error => {
      res.json({
        message: 'An error occured!'
      })
    })
})


app.get("/PendingRequests", (req, res) => {
  pending_session.find({}, function (err, results) {
    if (err) console.log(err); //or handle the error as you wish
    console.log(results); //results is an array of objects. Each object represent a document
    //This will print an array of the results
    //You can do whatever you want with the result, render them on the client
    //or do smth with them
    res.render("admin_pending_requests.ejs", { results });
  });
});


app.get("/seeMembers", (req, res) => {
  User.find({}, function (err, results) {
    if (err) console.log(err); //or handle the error as you wish
    console.log(results); //results is an array of objects. Each object represent a document
    //This will print an array of the results
    //You can do whatever you want with the result, render them on the client
    //or do smth with them
    res.render("admin_members.ejs", { results });
  });
});

app.get("/submitRecipe", (req, res) => {
    res.render("submit_recipe.ejs");
  
  });


 app.post("/recipe",  upload.single('recipe-pic'), (req,res)=>{
  session = req.session;
  let recipe1 = new recipe({

    name: session.name,
    email: session.userid,
    title: req.body.title,
    ingredients: req.body.ingredients,
    Steps: req.body.steps,
    img : {data: fs.readFileSync(path.join(__dirname + '/uploads/' + req.file.filename)),
    contentType: 'image/png'
  }
  })
  recipe1.save()
  .then(session => {
    res.json({
      message: ' Recipe Added Successfully!'
    })
  })
  .catch(error => {
    res.json({
      message: 'An error occured!'
    })
  })

 }) 

 app.get("/getRecipes", (req,res) => {
  recipe.find({}, function (err, results) {
    if (err) console.log(err); 
    console.log(results); 
      res.render("members_recipes.ejs", { results });
    })
  });
  app.get("/getTestimonials", (req,res) => {
    testimonial.find({}, function (err, results) {
      if (err) console.log(err); 
      console.log(results); 
        res.render("members_testimonials.ejs", { results });
      })
    });

  app.get("/testimonial", (req,res) => {
        res.render("testimonial.ejs");
      });


  app.post("/submitTestimonial", (req,res)=> {
    session = req.session;
    let txt= req.body.text;
    let msg="";
    let im;
    image.findOne({ 'name': session.userid }, (err, items) => {
      if (err) {
          console.log(err);
          res.status(500).send('An error occurred', err);
      }
      else {
        let testimonial1= new testimonial({
          name: session.name,
          email : session.userid,
          text : txt,
          img: items.img
        })   
        testimonial1.save()
        .then(data => {
          msg="success";
        })
        .catch(error => {
          res.json({
            message: 'An error occured!'
          })
        })  
      }})
  

      res.send(msg);
  
    

  });

app.get("/seeSessions", (req, res) => {
  confirmed_session.find({}, function (err, results) {
    if (err) console.log(err); //or handle the error as you wish
    console.log(results); //results is an array of objects. Each object represent a document
    //This will print an array of the results
    //You can do whatever you want with the result, render them on the client
    //or do smth with them
    res.render("admin_confirmed_sessions.ejs", { results });
  });
});


app.get("/memberSessions", (req, res) => {
  session = req.session;
  console.log(session.userid)
  confirmed_session.find({ 'email': session.userid },  function (err, results) { 
    if (err) console.log(err); //or handle the error as you wish
    console.log(results); 
    res.render("member_confirmed_sessions.ejs", { results });
  });
});
//I am sending a DELETE AJAX fetch request once a user click the delete button
app.delete("/deleteArequest", (req, res) => {
  console.log(req.body.ID);
  pending_session.deleteOne({ _id: req.body.ID }, (err, result) => {
    if (err) {
      console.log(err); //or handle the error as you wish
      return;
    }
    console.log("Removing one document with a specific id sent by the client...");
    console.log(result); //{ deletedCount: 1 }
  });
  console.log("1 document deleted");
  res.send(`success`);
});


app.post('/ConfirmSessionRequest', (req, res) => {
  pending_session.findOne({ _id: req.body.id }, function (err, pending) {
    if (pending === null) {
      return res.status(400).send({
        message: "Session not found."
      });
    }
    else {

      let sessionConfirm = new confirmed_session({

        Sessiontype: pending.Sessiontype,
        name: pending.name,
        email: pending.email,
        date: pending.date,
        time: pending.time,
        deliveryMethod: pending.deliveryMethod,
        paymentMethod: pending.paymentMethod

      })
      sessionConfirm.save()
        .then(
          pending_session.deleteOne({ _id: pending._id}, (err, result) => {
            if (err) {
              console.log(err); //or handle the error as you wish
              return;
            }
            console.log("Removing one document with a specific id sent by the client...");
            console.log(result); //{ deletedCount: 1 }
          })
        )
        .catch(error => {
          res.json({
            message: 'An error occured!'
          })
        })
    }



  });

  res.send("success");
});

app.get('/logout', (req, res) => {
  req.session.destroy();
  res.redirect('/');
})