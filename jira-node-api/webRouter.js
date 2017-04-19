var config = require('./config');
var output = require('./common/output').output;
var ctrl = require('./controllers/controllers');
var express = require('express');
var util = require('util');
var multer = require('multer');
var slaHelper = require('./common/slaHelper');

var router = express.Router();

router.get('/v1/issues', function(req, res, next) {
	ctrl.getIssueList('Task').then(function(issues) {		
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

router.get('/v1/subtasks', function(req, res, next) {
	ctrl.getIssueList('Sub-task').then(function(issues) {		
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

		if(!myIssue.fields[global.customFields.endIssueDate.id]) {
			res.json({sla: 0, expression: null, issue: myIssue});
		} else {
			var histories = myIssue.changelog.histories;
			var watchers = slaHelper.getWatchers(histories);

			if(watchers === -1) {
				res.status(400).json({error: 'Please check the issue status.'});
				return;
			}
			var endDate = myIssue.fields[global.customFields.endIssueDate.id]; //'2017-04-19T09:34:11.748+0000'; // todo
			var startDate = myIssue.fields.created;//'2017-04-12T09:34:11.748+0000'; // todo		

			var serveHours = slaHelper.getServeHours(startDate, endDate, watchers, global.standard.workHours[0], global.standard.workHours[1]);

			var sla = 0;
			var zone = myIssue.fields[global.customFields.zone.id]; // todo
			var standardHours = 0; // todo
			var timeoutCount = 1; //todo
			var priority = myIssue.fields.priority.name;

			slaHelper.getStandardHours(zone, priority, function(err, hour) {
				if(err) {
					res.status(400).json(err);
				}
				standardHours = hour;

				slaHours = slaHelper.getSLAHours(serveHours, standardHours, timeoutCount);
				var expression = `(${serveHours} - ${standardHours}) / ${standardHours} + ${timeoutCount} = ${slaHours}`

				res.json({sla: slaHours, expression: expression, issue: myIssue});
			});
		}
		
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

router.post('/v1/issue/plugin/update/:issueId', function(req, res, next) {
	ctrl.getIssueById(req.params.issueId).then(function(issue) {
		var myIssue = typeof issue === "string" ? JSON.parse(issue) : issue;
		var eventType = myIssue.fields[global.customFields.eventType.id];
		var storeArea = myIssue.fields[global.customFields.storeArea.id];
		var storeNo = myIssue.fields[global.customFields.storeNo.id];
		
		if(eventType) {
			ctrl.extService(config.ddtalk + "?districtname=" + storeArea + "&diningname=" + storeNo + "&vendorname=" + eventType.value).then(function(result) {	
				if(result && result.data && result.data.serviceDeskName) {
					ctrl.extService(config.ddRobot + "?issuekey=" + req.params.issueId + "&deskname=" + result.data.serviceDeskName);
				}
			}).catch(function(err) {
				output(err);
			});
		}	
	}).catch(function(err) {
		output(err);
	})
})

router.post('/v1/issue/end/:issueId', function(req, res, next) {
	var issueId = req.params.issueId;
	var body = req.body;

	ctrl.endIssue(issueId, body).then(function(result) {
		res.json(result);
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





