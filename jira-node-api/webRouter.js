var config = require('./config');
var output = require('./common/output').output;
var ctrl = require('./controllers/controllers');
var express = require('express');
var util = require('util');
var multer = require('multer');
var slaHelper = require('./common/slaHelper');

var router = express.Router();

module.exports = router;