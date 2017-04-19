// NHDAdmin "Authorization": "Basic TkhEQWRtaW46cGFzc3dvcmRAMTIzNDU=",
// StoreUser "Authorization": "Basic U3RvcmVVc2VyOnBhc3N3b3JkQDEyMzQ1",
// localAccount "Authorization":"Basic emhpanVuLnpob3UxOTkyOnp6ajE5OTJqaXJh"
// Admin "Authorization":"{"Authorization":"Basic QWRtaW46cGFzc3dvcmRAMTIzNDU="}"
var config = {
	"debug": true,
	"baseUrl": "http://itsmpoc6341.cloudapp.net:90/rest/api/2",
	"ddRobot": "http://itsmpoc6341.cloudapp.net/itsm-ddtalk/api/vendor/robot/send",
	"ddtalk": "http://itsmpoc6341.cloudapp.net/itsm-ddtalk/api/vendor/desk",
	"db": {
		user: 'postgres',
		database: 'itsm',
		schema: 'itsm2',
		table: {
			sla_config: 'sla_config',
			sys_params: 'sys_params',
			dining_desk_map: 'dining_desk_map'
		},
		password: 'password@12345',
		host: 'itsmpoc6341.cloudapp.net',
		port: 5432,
		max: 10,
		idleTimeoutMillis: 30000,
	},
	"headers": {
		"Authorization": "Basic QWRtaW46cGFzc3dvcmRAMTIzNDU",
		"Content-Type": "application/json"
	},
	"adminHeaders": {
		"Authorization": "Basic QWRtaW46cGFzc3dvcmRAMTIzNDU",
		"Content-Type": "application/json"
	},
	"v2": {
		"projectId": "10001",
		"getIssues": "/issue/picker",
		"getIssueById": "/issue/",
		"createIssue": "/issue",
		"field": '/field'
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
		"endissue": {
			"update": {
				"comment": [
					{
						"add": {
							"body": "Comment added when resolving issue"
						}
					}
				]
			},
			"customfield_10024": [{ "set": "湖北省武汉市" }],
			"transition": {
				"id": "171"
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
				"comment": [
					{
						"add": {
							"body": "Comment added when resolving issue"
						}
					}
				]
			},
			"customfield_10024": [{ "set": "湖北省武汉市" }]
		},
		"updateVendor": {
			"update": {
				"comment": [
					{
						"add": {
							"body": "update assignee and vendor"
						}
					}
				]
			}
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
		},
		"changelog": {
			"expand": "renderedFields,names,schema,operations,editmeta,changelog,versionedRepresentations",
			"id": "10033",
			"self": "http://itsmpoc6341.cloudapp.net:90/rest/api/2/issue/10033",
			"key": "ITSM-24",
			"fields": {
				"issuetype": {
					"self": "http://itsmpoc6341.cloudapp.net:90/rest/api/2/issuetype/10002",
					"id": "10002",
					"description": "餐厅门店报修事件",
					"iconUrl": "http://itsmpoc6341.cloudapp.net:90/secure/viewavatar?size=xsmall&avatarId=10300&avatarType=issuetype",
					"name": "StoreSupportCase",
					"subtask": false,
					"avatarId": 10300
				},
				"timespent": null,
				"project": {
					"self": "http://itsmpoc6341.cloudapp.net:90/rest/api/2/project/10001",
					"id": "10001",
					"key": "ITSM",
					"name": "ITSM",
					"avatarUrls": {
						"48x48": "http://itsmpoc6341.cloudapp.net:90/secure/projectavatar?avatarId=10324",
						"24x24": "http://itsmpoc6341.cloudapp.net:90/secure/projectavatar?size=small&avatarId=10324",
						"16x16": "http://itsmpoc6341.cloudapp.net:90/secure/projectavatar?size=xsmall&avatarId=10324",
						"32x32": "http://itsmpoc6341.cloudapp.net:90/secure/projectavatar?size=medium&avatarId=10324"
					}
				},
				"fixVersions": [],
				"aggregatetimespent": null,
				"resolution": null,
				"resolutiondate": null,
				"workratio": -1,
				"lastViewed": "2017-04-17T01:54:34.892+0000",
				"watches": {
					"self": "http://itsmpoc6341.cloudapp.net:90/rest/api/2/issue/ITSM-24/watchers",
					"watchCount": 1,
					"isWatching": false
				},
				"created": "2017-04-16T09:34:11.748+0000",
				"customfield_10020": "2017-04-12T01:33:00.000+0000",
				"customfield_10021": "2017-04-16T01:34:00.000+0000",
				"priority": {
					"self": "http://itsmpoc6341.cloudapp.net:90/rest/api/2/priority/1",
					"iconUrl": "http://itsmpoc6341.cloudapp.net:90/images/icons/priorities/highest.svg",
					"name": "P0",
					"id": "1"
				},
				"labels": [],
				"customfield_10018": null,
				"customfield_10019": null,
				"timeestimate": null,
				"aggregatetimeoriginalestimate": null,
				"versions": [],
				"issuelinks": [],
				"assignee": null,
				"updated": "2017-04-17T01:35:09.909+0000",
				"status": {
					"self": "http://itsmpoc6341.cloudapp.net:90/rest/api/2/status/10001",
					"description": "问题已经准备好让经办人开始处理。",
					"iconUrl": "http://itsmpoc6341.cloudapp.net:90/images/icons/status_generic.gif",
					"name": "开放",
					"id": "10001",
					"statusCategory": {
						"self": "http://itsmpoc6341.cloudapp.net:90/rest/api/2/statuscategory/4",
						"id": 4,
						"key": "indeterminate",
						"colorName": "yellow",
						"name": "处理中"
					}
				},
				"components": [],
				"timeoriginalestimate": null,
				"description": "测试数据",
				"timetracking": {},
				"customfield_10005": null,
				"customfield_10006": null,
				"customfield_10007": null,
				"attachment": [],
				"aggregatetimeestimate": null,
				"summary": "测试数据",
				"creator": {
					"self": "http://itsmpoc6341.cloudapp.net:90/rest/api/2/user?username=StoreUser",
					"name": "StoreUser",
					"key": "storeuser",
					"emailAddress": "louisasea16@hotmail.com",
					"avatarUrls": {
						"48x48": "http://www.gravatar.com/avatar/bcd23f4432b466757bd27bf2c880e951?d=mm&s=48",
						"24x24": "http://www.gravatar.com/avatar/bcd23f4432b466757bd27bf2c880e951?d=mm&s=24",
						"16x16": "http://www.gravatar.com/avatar/bcd23f4432b466757bd27bf2c880e951?d=mm&s=16",
						"32x32": "http://www.gravatar.com/avatar/bcd23f4432b466757bd27bf2c880e951?d=mm&s=32"
					},
					"displayName": "StoreUser",
					"active": true,
					"timeZone": "UTC"
				},
				"subtasks": [
					{
						"id": "10034",
						"key": "ITSM-25",
						"self": "http://itsmpoc6341.cloudapp.net:90/rest/api/2/issue/10034",
						"fields": {
							"summary": "parent_summary",
							"status": {
								"self": "http://itsmpoc6341.cloudapp.net:90/rest/api/2/status/1",
								"description": "The issue is open and ready for the assignee to start work on it.",
								"iconUrl": "http://itsmpoc6341.cloudapp.net:90/images/icons/statuses/open.png",
								"name": "New",
								"id": "1",
								"statusCategory": {
									"self": "http://itsmpoc6341.cloudapp.net:90/rest/api/2/statuscategory/2",
									"id": 2,
									"key": "new",
									"colorName": "blue-gray",
									"name": "待办"
								}
							},
							"priority": {
								"self": "http://itsmpoc6341.cloudapp.net:90/rest/api/2/priority/1",
								"iconUrl": "http://itsmpoc6341.cloudapp.net:90/images/icons/priorities/highest.svg",
								"name": "P0",
								"id": "1"
							},
							"issuetype": {
								"self": "http://itsmpoc6341.cloudapp.net:90/rest/api/2/issuetype/10003",
								"id": "10003",
								"description": "服务商工单",
								"iconUrl": "http://itsmpoc6341.cloudapp.net:90/secure/viewavatar?size=xsmall&avatarId=10316&avatarType=issuetype",
								"name": "VendorSupportCase",
								"subtask": true,
								"avatarId": 10316
							}
						}
					}
				],
				"reporter": {
					"self": "http://itsmpoc6341.cloudapp.net:90/rest/api/2/user?username=StoreUser",
					"name": "StoreUser",
					"key": "storeuser",
					"emailAddress": "louisasea16@hotmail.com",
					"avatarUrls": {
						"48x48": "http://www.gravatar.com/avatar/bcd23f4432b466757bd27bf2c880e951?d=mm&s=48",
						"24x24": "http://www.gravatar.com/avatar/bcd23f4432b466757bd27bf2c880e951?d=mm&s=24",
						"16x16": "http://www.gravatar.com/avatar/bcd23f4432b466757bd27bf2c880e951?d=mm&s=16",
						"32x32": "http://www.gravatar.com/avatar/bcd23f4432b466757bd27bf2c880e951?d=mm&s=32"
					},
					"displayName": "StoreUser",
					"active": true,
					"timeZone": "UTC"
				},
				"customfield_10000": null,
				"aggregateprogress": {
					"progress": 0,
					"total": 0
				},
				"customfield_10001": null,
				"customfield_10002": "AA",
				"customfield_10003": "CCCC",
				"customfield_10004": null,
				"environment": null,
				"duedate": null,
				"progress": {
					"progress": 0,
					"total": 0
				},
				"comment": {
					"comments": [],
					"maxResults": 0,
					"total": 0,
					"startAt": 0
				},
				"worklog": {
					"startAt": 0,
					"maxResults": 20,
					"total": 0,
					"worklogs": []
				}
			},
			"changelog": {
				"startAt": 0,
				"maxResults": 5,
				"total": 5,
				"histories": [
					{
						"id": "10091",
						"author": {
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
						},
						"created": "2017-04-17T01:33:34.955+0000",
						"items": [
							{
								"field": "停表时间",
								"fieldtype": "custom",
								"from": null,
								"fromString": null,
								"to": "2017-04-12T01:33:00+0000",
								"toString": "12/四月/17 1:33 上午"
							}
						]
					},
					{
						"id": "10092",
						"author": {
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
						},
						"created": "2017-04-17T01:34:16.342+0000",
						"items": [
							{
								"field": "开表时间",
								"fieldtype": "custom",
								"from": null,
								"fromString": null,
								"to": "2017-04-16T01:34:00+0000",
								"toString": "16/四月/17 1:34 上午"
							}
						]
					},
					{
						"id": "10093",
						"author": {
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
						},
						"created": "2017-04-17T01:34:56.208+0000",
						"items": [
							{
								"field": "status",
								"fieldtype": "jira",
								"from": "1",
								"fromString": "New",
								"to": "10001",
								"toString": "Open"
							}
						]
					},
					{
						"id": "10094",
						"author": {
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
						},
						"created": "2017-04-17T01:35:01.602+0000",
						"items": [
							{
								"field": "status",
								"fieldtype": "jira",
								"from": "10001",
								"fromString": "Open",
								"to": "3",
								"toString": "In Progress"
							}
						]
					},
					{
						"id": "10095",
						"author": {
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
						},
						"created": "2017-04-17T01:35:09.909+0000",
						"items": [
							{
								"field": "status",
								"fieldtype": "jira",
								"from": "3",
								"fromString": "In Progress",
								"to": "10001",
								"toString": "Open"
							}
						]
					}
				]
			}
		}
	}
};

module.exports = config;