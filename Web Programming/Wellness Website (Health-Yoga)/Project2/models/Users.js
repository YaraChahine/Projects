const mongoose = require('mongoose');
const Schema= mongoose.Schema


const userSchema = new Schema({


name: {
    type: String
},
email: {
    type: String
},
phone: {
    type: String
},
salt: {
    type: String
},
hash :{
    type: String
}

}, {timestamps: true})


const User= mongoose.model('User', userSchema)



module.exports= User