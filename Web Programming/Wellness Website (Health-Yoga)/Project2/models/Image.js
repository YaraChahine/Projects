var mongoose = require('mongoose');
  
var imageSchema = new mongoose.Schema({
    name: String,
    img:
    {
        data: Buffer,
        contentType: String
    }
});
  
//Image is a model which has a schema imageSchema
const image = mongoose.model('Image', imageSchema);
module.exports = image;