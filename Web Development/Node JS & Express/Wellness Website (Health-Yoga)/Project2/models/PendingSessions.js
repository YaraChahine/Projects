const mongoose = require('mongoose');
mongoose.connect('mongodb://localhost:27017/mydb', {useNewUrlParser: true, useUnifiedTopology: true })

const Schema= mongoose.Schema


const pending_sessionSchema = new Schema({


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


const Session= mongoose.model('PendingSessions', pending_sessionSchema)



module.exports= Session