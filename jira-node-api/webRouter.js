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
	// ctrl.getIssueById(req.params.issueId + '?expand=changelog').then(function(issue) {
	// 	var myIssue = typeof issue === "string" ? JSON.parse(issue) : issue;
		var myIssue = config.sample.changelog;
		var histories = myIssue.changelog.histories;
		var watchers = [];

		histories.forEach(function(his, i) {
			his.items.forEach(function(item, j) {
				if(item.field === '停表时间' && item.fieldtype === 'custom') {
					watchers.push(item.to);
				}
				if(item.field === '开表时间' && item.fieldtype === 'custom') {
					watchers.push(item.to);
				}
			})
		})

		if(watchers.length % 2 !== 0) {
			console.log('stop watch and start watch are not match.');
		}

		watchers.sort(function(a, b) {
			return a > b;
		})

		var endDate = '2017-04-17T09:34:11.748+0000';
		var startDate = '2017-04-12T09:34:11.748+0000';
		var startWorkHour = 'T00:00:00.000Z'
		var endWorkHour = 'T00:00:00.000Z'

		console.log(startDate, endDate, watchers, startWorkHour, endWorkHour);

		var serveHours = slaHelper.getServeHours(startDate, endDate, watchers, startWorkHour, endWorkHour);

		console.log(serveHours);


	// }).catch(function(err) {
	// 	res.status(err.statusCode).json(err);
	// 	output(err);
	// })
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





