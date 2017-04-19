var config = require('../config');
var rp = require('request-promise');

exports.getRequest = function (url) {
	var options = {
		uri: config.baseUrl + url,
		headers: config.headers
	};
	return rp(options);
};

exports.postRequest = function(url, body) {
	var options = {
		method: 'POST',
		uri: config.baseUrl + url,
		headers: config.headers,
		body: body,
		json: true
	}
	return rp(options);
}

exports.putRequest = function(url, body) {	
	var options = {
		method: 'PUT',
		uri: config.baseUrl + url,
		headers: config.headers,
		body: body,
		json: true
	}
	return rp(options);
}

exports.endIssueRequest = function(url, body) {
	var options = {
		method: 'POST',
		uri: config.baseUrl + url,
		headers: config.adminHeaders,
		body: body,
		json: true
	}
	return rp(options);
}

exports.callExtService = function(url) {	
	return rp(url);
}