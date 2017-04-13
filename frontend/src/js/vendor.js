$(function () {

    var baseUrl = 'http://localhost:8088/rest/api/2/'

    var issues = {
        "sections": [
            {
                "label": "History Search",
                "sub": "Showing 2 of 2 matching issues",
                "id": "hs",
                "issues": [
                    {
                        "key": "YUM-2",
                        "keyHtml": "YUM-2",
                        "img": "/secure/viewavatar?size=xsmall&avatarId=10318&avatarType=issuetype",
                        "summary": "Test issue 2",
                        "summaryText": "Test issue 2"
                    },
                    {
                        "key": "YUM-1",
                        "keyHtml": "YUM-1",
                        "img": "/secure/viewavatar?size=xsmall&avatarId=10318&avatarType=issuetype",
                        "summary": "Test issue retrieve",
                        "summaryText": "Test issue retrieve"
                    }
                ]
            }
        ]
    };

    var _issue = (function () {

        return {
            getIssues: function () {
                var dfd = $.Deferred();
                $.ajax({
                    url: baseUrl + 'issue/picker',
                    // url: 'https://api.spotify.com/v1/search?q=a&type=artist',
                    method: 'GET',
                    crossDomain:  true,
                    headers: {
                        'Content-Type': 'application/json',
                        'X-Atlassian-Token': 'no-check',
                        'Access-Control-Allow-Origin': '*',
                        'Authorization': 'Basic emhpanVuLnpob3UxOTkyOnp6ajE5OTJqaXJh'
                    },
                    success: function (data, status, xhr) {
                        dfd.resolve(data, status, xhr);
                    },
                    error: function (xhr) {
                        dfd.resolve(xhr);
                    }
                });
                return dfd.promise();
            }
        }

    })();

    // _issue.getIssues().done(function(data, status, xhr) {
    //     console.log(data);
    // });

    function AppViewModel() {
        this.firstName = "Bert";
        this.issues = [
            {
                "key": "YUM-2",
                "keyHtml": "YUM-2",
                "img": "/secure/viewavatar?size=xsmall&avatarId=10318&avatarType=issuetype",
                "summary": "Test issue 2",
                "summaryText": "Test issue 2"
            }, {
                "key": "YUM-1",
                "keyHtml": "YUM-1",
                "img": "/secure/viewavatar?size=xsmall&avatarId=10318&avatarType=issuetype",
                "summary": "Test issue retrieve",
                "summaryText": "Test issue retrieve"
            }, {
                "key": "YUM-1",
                "keyHtml": "YUM-1",
                "img": "/secure/viewavatar?size=xsmall&avatarId=10318&avatarType=issuetype",
                "summary": "Test issue retrieve",
                "summaryText": "Test issue retrieve"
            }, {
                "key": "YUM-1",
                "keyHtml": "YUM-1",
                "img": "/secure/viewavatar?size=xsmall&avatarId=10318&avatarType=issuetype",
                "summary": "Test issue retrieve",
                "summaryText": "Test issue retrieve"
            }, {
                "key": "YUM-1",
                "keyHtml": "YUM-1",
                "img": "/secure/viewavatar?size=xsmall&avatarId=10318&avatarType=issuetype",
                "summary": "Test issue retrieve",
                "summaryText": "Test issue retrieve"
            }, {
                "key": "YUM-1",
                "keyHtml": "YUM-1",
                "img": "/secure/viewavatar?size=xsmall&avatarId=10318&avatarType=issuetype",
                "summary": "Test issue retrieve",
                "summaryText": "Test issue retrieve"
            }, {
                "key": "YUM-1",
                "keyHtml": "YUM-1",
                "img": "/secure/viewavatar?size=xsmall&avatarId=10318&avatarType=issuetype",
                "summary": "Test issue retrieve",
                "summaryText": "Test issue retrieve"
            }, {
                "key": "YUM-1",
                "keyHtml": "YUM-1",
                "img": "/secure/viewavatar?size=xsmall&avatarId=10318&avatarType=issuetype",
                "summary": "Test issue retrieve",
                "summaryText": "Test issue retrieve"
            }, {
                "key": "YUM-9",
                "keyHtml": "YUM-1",
                "img": "/secure/viewavatar?size=xsmall&avatarId=10318&avatarType=issuetype",
                "summary": "Test issue retrieve",
                "summaryText": "Test issue retrieve"
            }, {
                "key": "YUM-10",
                "keyHtml": "YUM-1",
                "img": "/secure/viewavatar?size=xsmall&avatarId=10318&avatarType=issuetype",
                "summary": "Test issue retrieve",
                "summaryText": "Test issue retrieve"
            }, {
                "key": "YUM-11",
                "keyHtml": "YUM-1",
                "img": "/secure/viewavatar?size=xsmall&avatarId=10318&avatarType=issuetype",
                "summary": "Test issue retrieve",
                "summaryText": "Test issue retrieve"
            }
        ];
        this.detail = {
            "expand": "renderedFields,names,schema,operations,editmeta,changelog,versionedRepresentations",
            "id": "10001",
            "self": "http://localhost:8088/rest/api/2/issue/10001",
            "key": "YUM-2",
            "fields": {
                "issuetype": {
                    "self": "http://localhost:8088/rest/api/2/issuetype/10001",
                    "id": "10001",
                    "description": "A task that needs to be done.",
                    "iconUrl": "http://localhost:8088/secure/viewavatar?size=xsmall&avatarId=10318&avatarType=issuetype",
                    "name": "Task",
                    "subtask": false,
                    "avatarId": 10318
                },
                "components": [],
                "timespent": null,
                "timeoriginalestimate": null,
                "description": "s",
                "project": {
                    "self": "http://localhost:8088/rest/api/2/project/10000",
                    "id": "10000",
                    "key": "YUM",
                    "name": "YUM",
                    "avatarUrls": {
                        "48x48": "http://localhost:8088/secure/projectavatar?avatarId=10324",
                        "24x24": "http://localhost:8088/secure/projectavatar?size=small&avatarId=10324",
                        "16x16": "http://localhost:8088/secure/projectavatar?size=xsmall&avatarId=10324",
                        "32x32": "http://localhost:8088/secure/projectavatar?size=medium&avatarId=10324"
                    }
                },
                "fixVersions": [],
                "aggregatetimespent": null,
                "resolution": null,
                "timetracking": {},
                "attachment": [],
                "aggregatetimeestimate": null,
                "resolutiondate": null,
                "workratio": -1,
                "summary": "Test issue 2",
                "lastViewed": "2017-04-13T15:29:24.045+0800",
                "watches": {
                    "self": "http://localhost:8088/rest/api/2/issue/YUM-2/watchers",
                    "watchCount": 1,
                    "isWatching": true
                },
                "creator": {
                    "self": "http://localhost:8088/rest/api/2/user?username=zhijun.zhou1992",
                    "name": "zhijun.zhou1992",
                    "key": "zhijun.zhou1992",
                    "emailAddress": "zhijun.zhou1992@gmail.com",
                    "avatarUrls": {
                        "48x48": "http://localhost:8088/secure/useravatar?avatarId=10341",
                        "24x24": "http://localhost:8088/secure/useravatar?size=small&avatarId=10341",
                        "16x16": "http://localhost:8088/secure/useravatar?size=xsmall&avatarId=10341",
                        "32x32": "http://localhost:8088/secure/useravatar?size=medium&avatarId=10341"
                    },
                    "displayName": "zhijun.zhou1992@gmail.com",
                    "active": true,
                    "timeZone": "Asia/Shanghai"
                },
                "subtasks": [],
                "created": "2017-04-13T15:29:23.525+0800",
                "reporter": {
                    "self": "http://localhost:8088/rest/api/2/user?username=zhijun.zhou1992",
                    "name": "zhijun.zhou1992",
                    "key": "zhijun.zhou1992",
                    "emailAddress": "zhijun.zhou1992@gmail.com",
                    "avatarUrls": {
                        "48x48": "http://localhost:8088/secure/useravatar?avatarId=10341",
                        "24x24": "http://localhost:8088/secure/useravatar?size=small&avatarId=10341",
                        "16x16": "http://localhost:8088/secure/useravatar?size=xsmall&avatarId=10341",
                        "32x32": "http://localhost:8088/secure/useravatar?size=medium&avatarId=10341"
                    },
                    "displayName": "zhijun.zhou1992@gmail.com",
                    "active": true,
                    "timeZone": "Asia/Shanghai"
                },
                "aggregateprogress": {
                    "progress": 0,
                    "total": 0
                },
                "priority": {
                    "self": "http://localhost:8088/rest/api/2/priority/2",
                    "iconUrl": "http://localhost:8088/images/icons/priorities/high.svg",
                    "name": "High",
                    "id": "2"
                },
                "labels": [
                    "ss"
                ],
                "environment": null,
                "timeestimate": null,
                "aggregatetimeoriginalestimate": null,
                "versions": [],
                "duedate": "2017-04-28",
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
                "issuelinks": [],
                "votes": {
                    "self": "http://localhost:8088/rest/api/2/issue/YUM-2/votes",
                    "votes": 0,
                    "hasVoted": false
                },
                "worklog": {
                    "startAt": 0,
                    "maxResults": 20,
                    "total": 0,
                    "worklogs": []
                },
                "assignee": null,
                "updated": "2017-04-13T15:29:23.525+0800",
                "status": {
                    "self": "http://localhost:8088/rest/api/2/status/10000",
                    "description": "",
                    "iconUrl": "http://localhost:8088/images/icons/status_generic.gif",
                    "name": "To Do",
                    "id": "10000",
                    "statusCategory": {
                        "self": "http://localhost:8088/rest/api/2/statuscategory/2",
                        "id": 2,
                        "key": "new",
                        "colorName": "blue-gray",
                        "name": "To Do"
                    }
                }
            }
        }
    }

    // Activates knockout.js
    ko.applyBindings(new AppViewModel());

    $('#issueTable').DataTable({
        "paging": true,
        "lengthChange": false,
        "searching": false,
        "ordering": true,
        "info": true,
        "autoWidth": false,
        "pageLength": 8
    });


});