var config = require('./config');
var output = require('./common/output').output;
var ctrl = require('./controllers/controllers');
var express = require('express');
var util = require('util');
var multer = require('multer');

var router = express.Router();

router.get('/v1/issues', function(req, res, next) {
	ctrl.getIssueList().then(function(issues) {		
		if(typeof issues === "string") {
			res.json(JSON.parse(issues));
		} else {
			res.json(issues);
		}
	}).catch(function(err) {
		res.statusCode(err.statusCode).json(err);
		output(err);
	})
})

router.get('/v1/issues/:issueId', function(req, res, next) {
	ctrl.getIssueById(req.params.issueId).then(function(issue) {		
		if(typeof issue === "string") {
			res.json(JSON.parse(issue));
		} else {
			res.json(issue);
		}
	}).catch(function(err) {
		res.statusCode(err.statusCode).json(err);
		output(err);
	})
})

router.post('/v1/issue', function(req, res, next) {
	var issue = req.body;

	ctrl.createIssue(issue).then(function(newIssue) {
		res.json(newIssue);
	}).catch(function(err) {
		res.statusCode(err.statusCode).json(err);
		output(err);
	})
})

module.exports = router;





