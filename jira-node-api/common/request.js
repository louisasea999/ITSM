var config = require('../config');
var rp = require('request-promise');

exports.getRequest = function (url) {
	var options = {
		uri: url,
		headers: config.headers
	};
	return rp(options);
};

exports.postRequest = function(url, body) {
	var options = {
		method: 'POST',
		uri: url,
		headers: config.headers
	}
	return rp(options);
}