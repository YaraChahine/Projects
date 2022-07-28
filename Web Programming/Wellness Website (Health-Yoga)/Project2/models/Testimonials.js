const mongoose = require('mongoose');
mongoose.connect('mongodb://localhost:27017/mydb', {useNewUrlParser: true, useUnifiedTopology: true })

const Schema= mongoose.Schema


const Testimonial = new Schema({


name: {
    type: String
},
email: {
    type: String
},
text : {
    type: String
},
img:
{
    data: Buffer,
    contentType: String
}
}, {timestamps: true})


const testimonial= mongoose.model('testimonials', Testimonial)



module.exports= testimonial