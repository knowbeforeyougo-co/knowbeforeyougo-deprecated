const mongoose = require('mongoose');
const {Schema} = require("mongoose");

const snapshot = new Schema({
    clientId: {
        type: String,
        required: true
    },
    macAddresses: [String]
}, {timestamps: true});

module.exports = mongoose.model('Snapshot', snapshot, 'snapshots');
