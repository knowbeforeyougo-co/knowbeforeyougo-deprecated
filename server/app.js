const express = require('express');
const cookieParser = require('cookie-parser');
const logger = require('morgan');
const dotenv = require('dotenv');

// set up dotenv
const envFile = process.env.NODE_ENV ? `.env.${process.env.NODE_ENV}` : '.env'
dotenv.config({path: envFile})

// set up mongoose
const mongoose = require('mongoose');
mongoose.connect(process.env.MONGO_URL, {useNewUrlParser: true, useUnifiedTopology: true}).then(() => {
    console.log("Successfully connected to MongoDB");
}).catch(() => {
    console.log("Failed to connect to MongoDB");
});

const indexRouter = require('./routes/index');
const clientRouter = require('./routes/client/client');
const webRouter = require('./routes/web/web');

const app = express();

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({extended: false}));
app.use(cookieParser());

app.use('/', indexRouter);
app.use('/client', clientRouter);
app.use('/web', webRouter);

module.exports = app;
