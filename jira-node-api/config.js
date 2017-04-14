var config = {
	debug: true,
	baseUrl: 'http://itsmpoc6341.cloudapp.net:90/rest/api/2',
	headers: {
		'Authorization': 'Basic TkhEQWRtaW46cGFzc3dvcmRAMTIzNDU=',
		'Content-Type': 'application/json'
	},
	v2: {
		getIssues: '/issue/picker',
		getIssueById: '/issue/',
		createIssue: '/issue',
	},
	sample: {
		issue: {
			"fields": {
				"project": {
					"id": "10000"
				},
				"summary": "your summary here.",
				"issuetype": {
					"id": "10001"
				},
				"priority": {
					"self": "http://localhost:8088/rest/api/2/priority/2",
					"iconUrl": "http://localhost:8088/images/icons/priorities/high.svg",
					"name": "High",
					"id": "2"
				},
				"labels": [
					"bugfix",
					"blitz_test"
				],
				"timetracking": {
					"originalEstimate": "10",
					"remainingEstimate": "5"
				},
				"description": "your description",
				"duedate": "2017-04-11"
			}
		}
	}
};

module.exports = config;