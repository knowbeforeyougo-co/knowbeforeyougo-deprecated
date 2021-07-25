const mongoose = require('mongoose');
const {Schema} = require("mongoose");
const Client = require('./Client').schema;

const organization = new Schema({
    handle: {
        type: String,
        required: true
    },
    friendly: {
        type: String,
        required: true
    },
    clients: [Client],
}, {timestamps: true});

module.exports = mongoose.model('Organization', organization, 'organizations');
