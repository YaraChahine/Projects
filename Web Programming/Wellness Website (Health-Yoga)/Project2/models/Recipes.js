const mongoose = require('mongoose');
mongoose.connect('mongodb://localhost:27017/mydb', {useNewUrlParser: true, useUnifiedTopology: true })

const Schema= mongoose.Schema


const Recipes = new Schema({


name: {
    type: String
},
email:  {
    type:String
},
title: {
    type: String
},

ingredients: {
    type: String
},
Steps: {
    type: String
},
img:
{
    data: Buffer,
    contentType: String
}

}, {timestamps: true})


const recipe= mongoose.model('Recipes', Recipes)


module.exports= recipe