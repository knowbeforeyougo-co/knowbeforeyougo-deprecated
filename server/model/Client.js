const {Schema} = require("mongoose");
const mongoose = require('mongoose');

const client = new Schema({
    organizationId: {
        type: String,
        required: true
    },
    token: {
        type: String,
        required: true
    },
    location: {
        type: {
            type: String,
            enum: ['Point'],
            required: true
        },
        coordinates: {
            type: [Number],
            required: true
        }
    },
    lastStartupTime: {
        type: Date
    }
}, {timestamps: true});

module.exports = mongoose.model('Client', client);

