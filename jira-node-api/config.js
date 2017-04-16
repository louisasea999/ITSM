// NHDAdmin "Authorization": "Basic TkhEQWRtaW46cGFzc3dvcmRAMTIzNDU=",
// StoreUser "Authorization": "Basic U3RvcmVVc2VyOnBhc3N3b3JkQDEyMzQ1",
var config = {
	"debug": true,
	"baseUrl": "http://itsmpoc6341.cloudapp.net:90/rest/api/2",
	"headers": {
		"Authorization": "Basic TkhEQWRtaW46cGFzc3dvcmRAMTIzNDU",
		"Content-Type": "application/json"
	},
	"v2": {
		"projectId": "10001",
		"getIssues": "/issue/picker",
		"getIssueById": "/issue/",
		"createIssue": "/issue"
	},
	"sample": {
		"createIssue": {
			"fields": {
				"project": {
					"id": "10001"
				},
				"summary": "your summary here.",
				"issuetype": {
					"id": "10001"
				},
				"priority": {
					"self": "http://itsmpoc6341.cloudapp.net:90/rest/api/2/rest/api/2/priority/2",
					"iconUrl": "http://itsmpoc6341.cloudapp.net:90/rest/api/2/images/icons/priorities/high.svg",
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
		"customIssue": {
			"fields": {
				"project": {
					"id": "10000"
				},
				"summary": "测试创建issue包含自定义字段",
				"issuetype": {
					"id": "10000"
				},
				"priority": {
					"self": "http://itsmpoc6341.cloudapp.net:90/rest/api/2/rest/api/2/priority/2",
					"iconUrl": "http://itsmpoc6341.cloudapp.net:90/rest/api/2/images/icons/priorities/high.svg",
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
				"customfield_10003": "光谷软件园",
				"description": "description",
				"duedate": "2017-04-11"
			}
		},
		"updateIssue": {
			"update": {
				"summary": [
					{
						"set": "Bug in business logic"
					}
				],
				"timetracking": [
					{
						"edit": {
							"originalEstimate": "1w 1d",
							"remainingEstimate": "4d"
						}
					}
				],
				"labels": [
					{
						"add": "triaged"
					},
					{
						"remove": "blocker"
					}
				]
			},
			"historyMetadata": {
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
				"cause": {
					"id": "myevent",
					"type": "mysystem-event"
				},
				"extraData": {
					"keyvalue": "extra data",
					"goes": "here"
				}
			},
			"properties": [
				{
					"key": "key1",
					"value": ""
				}
			]
		},
		"customFields": [
			{
				"name": "餐厅区域",
				"description": "餐厅区域",
				"type": "com.atlassian.jira.plugin.system.customfieldtypes:textfield"
			},
			{
				"name": "餐厅门店编号",
				"description": "餐厅门店编号",
				"type": "com.atlassian.jira.plugin.system.customfieldtypes:textfield"
			}
		],
		"user": {
			"reporter": {
				"self": "http://itsmpoc6341.cloudapp.net:90/rest/api/2/user?username=NHDAdmin",
				"name": "NHDAdmin",
				"key": "nhdadmin",
				"emailAddress": "louisasea16@hotmail.com",
				"avatarUrls": {
					"48x48": "http://itsmpoc6341.cloudapp.net:90/secure/useravatar?avatarId=10336",
					"24x24": "http://itsmpoc6341.cloudapp.net:90/secure/useravatar?size=small&avatarId=10336",
					"16x16": "http://itsmpoc6341.cloudapp.net:90/secure/useravatar?size=xsmall&avatarId=10336",
					"32x32": "http://itsmpoc6341.cloudapp.net:90/secure/useravatar?size=medium&avatarId=10336"
				},
				"displayName": "NHDAdmin",
				"active": true,
				"timeZone": "UTC"
			}
		}
	}
};

module.exports = config;