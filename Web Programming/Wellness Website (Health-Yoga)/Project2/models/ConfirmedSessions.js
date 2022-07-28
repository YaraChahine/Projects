const mongoose = require('mongoose');
mongoose.connect('mongodb://localhost:27017/mydb', {useNewUrlParser: true, useUnifiedTopology: true })

const Schema= mongoose.Schema


const ConfirmedSessions = new Schema({


Sessiontype: {
    type: String
},
name:  {
    type:String
},
email: {
    type: String
},

date: {
    type: String
},
time: {
    type: String
},
deliveryMethod: {
    type: String
},
paymentMethod: {
    type: String
}


}, {timestamps: true})


const ConfirmedSession= mongoose.model('ConfirmedSessions', ConfirmedSessions)


module.exports= ConfirmedSession