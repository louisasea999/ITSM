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
        if (typeof issues === "string") {
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
        if (typeof issues === "string") {
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
        if (typeof issue === "string") {
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
        if (typeof issue === "string") {
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

        if (!myIssue.fields[global.customFields.endIssueDate.id]) {
            res.json({ sla: 0, expression: null, issue: myIssue });
        } else {
            var histories = myIssue.changelog.histories;
            var watchers = slaHelper.getWatchers(histories);

            if (watchers === -1) {
                res.status(400).json({ error: 'Please check the issue status.' });
                return;
            }
            var endDate = myIssue.fields[global.customFields.endIssueDate.id]; //'2017-04-19T09:34:11.748+0000'; // todo
            var startDate = myIssue.fields.created; //'2017-04-12T09:34:11.748+0000'; // todo		

            var serveHours = slaHelper.getServeHours(startDate, endDate, watchers, global.standard.workHours[0], global.standard.workHours[1]);

            var sla = 0;
            var zone = myIssue.fields[global.customFields.zone.id]; // todo
            var standardHours = 0; // todo
            var timeoutCount = 1; //todo
            var priority = myIssue.fields.priority.name;

            slaHelper.getStandardHours(zone, priority, function(err, hour) {
                if (err) {
                    res.status(400).json(err);
                }
                standardHours = hour;

                slaHours = slaHelper.getSLAHours(serveHours, standardHours, timeoutCount);
                var expression = `(${serveHours} - ${standardHours}) / ${standardHours} + ${timeoutCount} = ${slaHours}`

                res.json({ sla: slaHours, expression: expression, issue: myIssue });
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
<<<<<<< HEAD
	ctrl.getIssueById(req.params.issueId).then(function(issue) {
		var myIssue = typeof issue === "string" ? JSON.parse(issue) : issue;
		var eventType = myIssue.fields[global.customFields.eventType.id];
		var storeArea = myIssue.fields[global.customFields.storeArea.id];
		var storeNo = myIssue.fields[global.customFields.storeNo.id];
		
		if(eventType) {
			var requestUrl = config.ddtalk + "?districtname=" + storeArea + "&diningname=" + storeNo + "&vendorname=" + eventType.value;

			ctrl.extService(encodeURI(requestUrl)).then(function(result) {	
				var result = typeof result === "string" ? JSON.parse(result) : result;
				if(result && result.data && result.data.serviceDeskName) {
					// call jira robot
					ctrl.extService(encodeURI(config.ddRobot + "?issuekey=" + req.params.issueId + "&deskname=" + result.data.serviceDeskName));
					
					var serveStationId = global.customFields.serveStation.id;
					var serveStation = result.data.serviceDeskName;

					var body = config.sample.updateVendor;
					body[serveStationId] = serveStation;

					// update serve station
					ctrl.updateIssue(req.params.issueId, body);

					var vendor = eventType.value.indexOf("乙") !== -1 ? "Vendor2" : "Vendor1";
					// update assignee
					ctrl.updateAssignee(req.params.issueId, vendor);
				}
			}).catch(function(err) {
				output(err);
			});
		}
		// comment this line in prod environment
		// res.json({});
	}).catch(function(err) {
		res.json(err);
		output(err);
	})
=======
    ctrl.getIssueById(req.params.issueId).then(function(issue) {
        var myIssue = typeof issue === "string" ? JSON.parse(issue) : issue;
        var eventType = myIssue.fields[global.customFields.eventType.id];
        var storeArea = myIssue.fields[global.customFields.storeArea.id];
        var storeNo = myIssue.fields[global.customFields.storeNo.id];

        if (eventType) {
            ctrl.extService(config.ddtalk + "?districtname=" + storeArea + "&diningname=" + storeNo + "&vendorname=" + eventType.value).then(function(result) {
                if (result && result.data && result.data.serviceDeskName) {
                    ctrl.extService(config.ddRobot + "?issuekey=" + req.params.issueId + "&deskname=" + result.data.serviceDeskName);
                }
            }).catch(function(err) {
                output(err);
            });
        }
    }).catch(function(err) {
        output(err);
    })
>>>>>>> cb23e575c8cb08973ff39987c2ba609b7564273d
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
        res.json({ status: 'ok' });
    }).catch(function(err) {
        res.status(err.statusCode).json(err);
        output(err);
    })
})

router.get('/v1/user/search/:username', function(req, res, next) {
    console.log(req.params.username);
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