var express = require('express');
var util = require('util');
var multer = require('multer');
var config = require('../config');
var output = require('../common/output').output;
var ctrl = require('../controllers/controllers');
var slaHelper = require('../common/slaHelper');

var router = express.Router();

router.get('/search/:username', function (req, res, next) {
    ctrl.getUser(req.params.username).then(function (user) {
        if (typeof user === "string") {
            res.json(JSON.parse(user));
        } else {
            res.json(user);
        }
    }).catch(function (err) {
        res.status(err.statusCode).json(err);
        output(err);
    })
})

router.get('/:username', function(req, res, next) {
    ctrl.getUser(req.params.username).then(function(user) {
        if (typeof user === "string") {
            res.json(JSON.parse(user));
        } else {
            res.json(user);
        }
    }).catch(function(err) {
        res.status(err.statusCode).json(err);
        output(err);
    })
})


module.exports = router;