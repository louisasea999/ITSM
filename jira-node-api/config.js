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
		createIssue: {
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
		},
		updateIssue: {
			"update":
			{
				"summary": [{
					"set": "Bug in business logic"
				}],
				"timetracking": [
					{
						"edit": {
							"originalEstimate": "1w 1d",
							"remainingEstimate": "4d"
						}
					}
				],
				"labels": [
					{ "add": "triaged" },
					{ "remove": "blocker" }
				]
			},
			"historyMetadata":
			{
				"type": "myplugin:type",
				"description": "text description",
				"descriptionKey": "plugin.changereason.i18.key",
				"activityDescription": "text description",
				"activityDescriptionKey": "plugin.activity.i18.key",
				"actor": {
					"id": "tony",
					"displayName": "Tony",
					"type": "mysystem-user",
					"avatarUrl": "http://mysystem/avatar/tony.jpg",
					"url": "http://mysystem/users/tony"
				},
				"generator": {
					"id": "mysystem-1",
					"type": "mysystem-application"
				},
				"cause": { "id": "myevent", "type": "mysystem-event" },
				"extraData": { "keyvalue": "extra data", "goes": "here" }
			}, "properties": [{ "key": "key1", "value": "" }]
		}
	}
};

module.exports = config;