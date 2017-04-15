var config = require('../config');
var util = require('../common/util');
var rq = require('../common/request');
var qs = require('querystring');

exports.getIssueList = function() {  
    return rq.getRequest(config.v2.getIssues);
};

exports.getIssueById = function(issueId) {
    return rq.getRequest(config.v2.getIssueById + issueId)
};

exports.createIssue = function(issue) {
    return rq.postRequest(config.v2.createIssue, issue);
}

exports.updateIssue = function(issueId, issue) {
    return rq.putRequest(config.v2.getIssueById + issueId, issue);
}

