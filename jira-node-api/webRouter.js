var config = require('./config');
var output = require('./common/output').output;
var ctrl = require('./controllers/controllers');
var express = require('express');
var util = require('util');
var multer = require('multer');
var slaHelper = require('./common/SLA');

var router = express.Router();

router.get('/v1/issues', function(req, res, next) {
	ctrl.getIssueList().then(function(issues) {		
		if(typeof issues === "string") {
			res.json(JSON.parse(issues));
		} else {
			res.json(issues);
		}
	}).catch(function(err) {
		res.status(err.statusCode).json(err);
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
		res.status(err.statusCode).json(err);
		output(err);
	})
})

router.get('/v1/issue/changelog/:issueId', function(req, res, next) {
	ctrl.getIssueById(req.params.issueId + '?expand=changelog').then(function(issue) {		
		if(typeof issue === "string") {
			res.json(JSON.parse(issue));
		} else {
			res.json(issue);
		}
	}).catch(function(err) {
		res.status(err.statusCode).json(err);
		output(err);
	})
})

router.get('/v1/issue/sla/:issueId', function(req, res, next) {
	ctrl.getIssueById(req.params.issueId + '?expand=changelog').then(function(issue) {
		var myIssue = typeof issue === "string" ? JSON.parse(issue) : issue;
		// var myIssue = config.sample.changelog;
		var histories = myIssue.changelog.histories;
		var watchers = slaHelper.getWatchers(histories);

		if(watchers === -1) {
			res.status(400).json({error: 'Please check the issue status.'});
		}

		var endDate = '2017-04-17T09:34:11.748+0000'; // todo
		var startDate = '2017-04-12T09:34:11.748+0000'; // todo
		var startWorkHour = 'T00:00:00.000Z'
		var endWorkHour = 'T00:00:00.000Z'

		var serveHours = slaHelper.getServeHours(startDate, endDate, watchers, startWorkHour, endWorkHour);

		var sla = 0;
		var zone = 1; // todo
		var standardHours = 0; // todo
		var timeoutCount = 1; //todo
		var priority = myIssue.fields.priority.name;

		standardHours = slaHelper.getStandardHours(zone, priority);
		slaHours = slaHelper.getSLAHours(serveHours, standardHours, timeoutCount);
		var expression = `(${serveHours} - ${standardHours}) / ${standardHours} + ${timeoutCount} = ${slaHours}`

		res.json({sla: slaHours, expression: expression, issue: myIssue});
	}).catch(function(err) {
		res.status(err.statusCode).json(err);
		output(err);
	})
})

router.post('/v1/issue', function(req, res, next) {
	var issue = req.body;

	ctrl.createIssue(issue).then(function(newIssue) {
		res.json(newIssue);
	}).catch(function(err) {
		res.status(err.statusCode).json(err);
		output(err);
	})
})

router.put('/v1/issue/:issueId', function(req, res, next) {
	var issue = req.body;

	ctrl.updateIssue(req.params.issueId, issue).then(function(data) {
		res.json({status: 'ok'});
	}).catch(function(err) {
		res.status(err.statusCode).json(err);
		output(err);
	})
})

module.exports = router;





