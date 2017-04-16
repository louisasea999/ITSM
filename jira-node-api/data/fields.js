exports.fields = [
    {
        "id": "issuetype",
        "name": "问题类型",
        "custom": false,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "issuetype",
            "type"
        ],
        "schema": {
            "type": "issuetype",
            "system": "issuetype"
        }
    },
    {
        "id": "timespent",
        "name": "耗费时间",
        "custom": false,
        "orderable": false,
        "navigable": true,
        "searchable": false,
        "clauseNames": [
            "timespent"
        ],
        "schema": {
            "type": "number",
            "system": "timespent"
        }
    },
    {
        "id": "project",
        "name": "项目",
        "custom": false,
        "orderable": false,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "project"
        ],
        "schema": {
            "type": "project",
            "system": "project"
        }
    },
    {
        "id": "fixVersions",
        "name": "修复版本",
        "custom": false,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "fixVersion"
        ],
        "schema": {
            "type": "array",
            "items": "version",
            "system": "fixVersions"
        }
    },
    {
        "id": "aggregatetimespent",
        "name": "Σ 耗费时间",
        "custom": false,
        "orderable": false,
        "navigable": true,
        "searchable": false,
        "clauseNames": [],
        "schema": {
            "type": "number",
            "system": "aggregatetimespent"
        }
    },
    {
        "id": "resolution",
        "name": "解决结果",
        "custom": false,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "resolution"
        ],
        "schema": {
            "type": "resolution",
            "system": "resolution"
        }
    },
    {
        "id": "resolutiondate",
        "name": "已解决",
        "custom": false,
        "orderable": false,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "resolutiondate",
            "resolved"
        ],
        "schema": {
            "type": "datetime",
            "system": "resolutiondate"
        }
    },
    {
        "id": "workratio",
        "name": "工作量比率",
        "custom": false,
        "orderable": false,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "workratio"
        ],
        "schema": {
            "type": "number",
            "system": "workratio"
        }
    },
    {
        "id": "lastViewed",
        "name": "最近查看的",
        "custom": false,
        "orderable": false,
        "navigable": true,
        "searchable": false,
        "clauseNames": [
            "lastViewed"
        ],
        "schema": {
            "type": "datetime",
            "system": "lastViewed"
        }
    },
    {
        "id": "watches",
        "name": "管理关注列表",
        "custom": false,
        "orderable": false,
        "navigable": true,
        "searchable": false,
        "clauseNames": [
            "watchers"
        ],
        "schema": {
            "type": "watches",
            "system": "watches"
        }
    },
    {
        "id": "thumbnail",
        "name": "图像",
        "custom": false,
        "orderable": false,
        "navigable": true,
        "searchable": false,
        "clauseNames": []
    },
    {
        "id": "created",
        "name": "创建日期",
        "custom": false,
        "orderable": false,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "created",
            "createdDate"
        ],
        "schema": {
            "type": "datetime",
            "system": "created"
        }
    },
    {
        "id": "priority",
        "name": "优先级",
        "custom": false,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "priority"
        ],
        "schema": {
            "type": "priority",
            "system": "priority"
        }
    },
    {
        "id": "labels",
        "name": "标签",
        "custom": false,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "labels"
        ],
        "schema": {
            "type": "array",
            "items": "string",
            "system": "labels"
        }
    },
    {
        "id": "customfield_10016",
        "name": "服务站",
        "custom": true,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "cf[10016]",
            "服务站"
        ],
        "schema": {
            "type": "string",
            "custom": "com.atlassian.jira.plugin.system.customfieldtypes:textfield",
            "customId": 10016
        }
    },
    {
        "id": "customfield_10017",
        "name": "案件类型",
        "custom": true,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "cf[10017]",
            "案件类型"
        ],
        "schema": {
            "type": "option",
            "custom": "com.atlassian.jira.plugin.system.customfieldtypes:select",
            "customId": 10017
        }
    },
    {
        "id": "customfield_10018",
        "name": "处理区域",
        "custom": true,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "cf[10018]",
            "处理区域"
        ],
        "schema": {
            "type": "option",
            "custom": "com.atlassian.jira.plugin.system.customfieldtypes:select",
            "customId": 10018
        }
    },
    {
        "id": "customfield_10019",
        "name": "餐厅报修门店",
        "custom": true,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "cf[10019]",
            "餐厅报修门店"
        ],
        "schema": {
            "type": "option",
            "custom": "com.atlassian.jira.plugin.system.customfieldtypes:select",
            "customId": 10019
        }
    },
    {
        "id": "timeestimate",
        "name": "剩余的估算",
        "custom": false,
        "orderable": false,
        "navigable": true,
        "searchable": false,
        "clauseNames": [
            "remainingEstimate",
            "timeestimate"
        ],
        "schema": {
            "type": "number",
            "system": "timeestimate"
        }
    },
    {
        "id": "aggregatetimeoriginalestimate",
        "name": "Σ 原预估时间",
        "custom": false,
        "orderable": false,
        "navigable": true,
        "searchable": false,
        "clauseNames": [],
        "schema": {
            "type": "number",
            "system": "aggregatetimeoriginalestimate"
        }
    },
    {
        "id": "versions",
        "name": "影响版本",
        "custom": false,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "affectedVersion"
        ],
        "schema": {
            "type": "array",
            "items": "version",
            "system": "versions"
        }
    },
    {
        "id": "issuelinks",
        "name": "链接的问题",
        "custom": false,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [],
        "schema": {
            "type": "array",
            "items": "issuelinks",
            "system": "issuelinks"
        }
    },
    {
        "id": "assignee",
        "name": "经办人",
        "custom": false,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "assignee"
        ],
        "schema": {
            "type": "user",
            "system": "assignee"
        }
    },
    {
        "id": "updated",
        "name": "已更新",
        "custom": false,
        "orderable": false,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "updated",
            "updatedDate"
        ],
        "schema": {
            "type": "datetime",
            "system": "updated"
        }
    },
    {
        "id": "status",
        "name": "状态",
        "custom": false,
        "orderable": false,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "status"
        ],
        "schema": {
            "type": "status",
            "system": "status"
        }
    },
    {
        "id": "components",
        "name": "组件",
        "custom": false,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "component"
        ],
        "schema": {
            "type": "array",
            "items": "component",
            "system": "components"
        }
    },
    {
        "id": "issuekey",
        "name": "关键字",
        "custom": false,
        "orderable": false,
        "navigable": true,
        "searchable": false,
        "clauseNames": [
            "id",
            "issue",
            "issuekey",
            "key"
        ]
    },
    {
        "id": "timeoriginalestimate",
        "name": "初始预估",
        "custom": false,
        "orderable": false,
        "navigable": true,
        "searchable": false,
        "clauseNames": [
            "originalEstimate",
            "timeoriginalestimate"
        ],
        "schema": {
            "type": "number",
            "system": "timeoriginalestimate"
        }
    },
    {
        "id": "description",
        "name": "描述",
        "custom": false,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "description"
        ],
        "schema": {
            "type": "string",
            "system": "description"
        }
    },
    {
        "id": "customfield_10010",
        "name": "停表时间",
        "custom": true,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "cf[10010]",
            "停表时间"
        ],
        "schema": {
            "type": "datetime",
            "custom": "com.atlassian.jira.plugin.system.customfieldtypes:datetime",
            "customId": 10010
        }
    },
    {
        "id": "customfield_10011",
        "name": "开表时间",
        "custom": true,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "cf[10011]",
            "开表时间"
        ],
        "schema": {
            "type": "datetime",
            "custom": "com.atlassian.jira.plugin.system.customfieldtypes:datetime",
            "customId": 10011
        }
    },
    {
        "id": "customfield_10012",
        "name": "结案距离",
        "custom": true,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "cf[10012]",
            "结案距离"
        ],
        "schema": {
            "type": "number",
            "custom": "com.atlassian.jira.plugin.system.customfieldtypes:float",
            "customId": 10012
        }
    },
    {
        "id": "customfield_10013",
        "name": "结案时间",
        "custom": true,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "cf[10013]",
            "结案时间"
        ],
        "schema": {
            "type": "datetime",
            "custom": "com.atlassian.jira.plugin.system.customfieldtypes:datetime",
            "customId": 10013
        }
    },
    {
        "id": "customfield_10014",
        "name": "SLA超期计数",
        "custom": true,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "cf[10014]",
            "SLA超期计数"
        ],
        "schema": {
            "type": "number",
            "custom": "com.atlassian.jira.plugin.system.customfieldtypes:float",
            "customId": 10014
        }
    },
    {
        "id": "timetracking",
        "name": "时间跟踪",
        "custom": false,
        "orderable": true,
        "navigable": false,
        "searchable": true,
        "clauseNames": [],
        "schema": {
            "type": "timetracking",
            "system": "timetracking"
        }
    },
    {
        "id": "customfield_10015",
        "name": "SLA",
        "custom": true,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "cf[10015]",
            "SLA"
        ],
        "schema": {
            "type": "number",
            "custom": "com.atlassian.jira.plugin.system.customfieldtypes:float",
            "customId": 10015
        }
    },
    {
        "id": "customfield_10005",
        "name": "Use comment as description",
        "custom": true,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "cf[10005]",
            "Use comment as description"
        ],
        "schema": {
            "type": "array",
            "items": "option",
            "custom": "com.atlassian.jira.plugin.system.customfieldtypes:multicheckboxes",
            "customId": 10005
        }
    },
    {
        "id": "customfield_10006",
        "name": "餐厅区域",
        "custom": true,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "cf[10006]",
            "餐厅区域"
        ],
        "schema": {
            "type": "string",
            "custom": "com.atlassian.jira.plugin.system.customfieldtypes:textfield",
            "customId": 10006
        }
    },
    {
        "id": "security",
        "name": "安全级别",
        "custom": false,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "level"
        ],
        "schema": {
            "type": "securitylevel",
            "system": "security"
        }
    },
    {
        "id": "customfield_10007",
        "name": "餐厅门店编号",
        "custom": true,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "cf[10007]",
            "餐厅门店编号"
        ],
        "schema": {
            "type": "string",
            "custom": "com.atlassian.jira.plugin.system.customfieldtypes:textfield",
            "customId": 10007
        }
    },
    {
        "id": "customfield_10008",
        "name": "处理区域",
        "custom": true,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "cf[10008]",
            "处理区域"
        ],
        "schema": {
            "type": "string",
            "custom": "com.atlassian.jira.plugin.system.customfieldtypes:textfield",
            "customId": 10008
        }
    },
    {
        "id": "attachment",
        "name": "附件",
        "custom": false,
        "orderable": true,
        "navigable": false,
        "searchable": true,
        "clauseNames": [
            "attachments"
        ],
        "schema": {
            "type": "array",
            "items": "attachment",
            "system": "attachment"
        }
    },
    {
        "id": "aggregatetimeestimate",
        "name": "Σ 预估剩余时间",
        "custom": false,
        "orderable": false,
        "navigable": true,
        "searchable": false,
        "clauseNames": [],
        "schema": {
            "type": "number",
            "system": "aggregatetimeestimate"
        }
    },
    {
        "id": "customfield_10009",
        "name": "开始处理时间",
        "custom": true,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "cf[10009]",
            "开始处理时间"
        ],
        "schema": {
            "type": "datetime",
            "custom": "com.atlassian.jira.plugin.system.customfieldtypes:datetime",
            "customId": 10009
        }
    },
    {
        "id": "summary",
        "name": "汇总",
        "custom": false,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "summary"
        ],
        "schema": {
            "type": "string",
            "system": "summary"
        }
    },
    {
        "id": "creator",
        "name": "创建者",
        "custom": false,
        "orderable": false,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "creator"
        ],
        "schema": {
            "type": "user",
            "system": "creator"
        }
    },
    {
        "id": "subtasks",
        "name": "子任务",
        "custom": false,
        "orderable": false,
        "navigable": true,
        "searchable": false,
        "clauseNames": [
            "subtasks"
        ],
        "schema": {
            "type": "array",
            "items": "issuelinks",
            "system": "subtasks"
        }
    },
    {
        "id": "reporter",
        "name": "报告人",
        "custom": false,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "reporter"
        ],
        "schema": {
            "type": "user",
            "system": "reporter"
        }
    },
    {
        "id": "aggregateprogress",
        "name": "Σ 进度",
        "custom": false,
        "orderable": false,
        "navigable": true,
        "searchable": false,
        "clauseNames": [],
        "schema": {
            "type": "progress",
            "system": "aggregateprogress"
        }
    },
    {
        "id": "customfield_10000",
        "name": "餐厅区域",
        "custom": true,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "cf[10000]",
            "餐厅区域"
        ],
        "schema": {
            "type": "string",
            "custom": "com.atlassian.jira.plugin.system.customfieldtypes:textarea",
            "customId": 10000
        }
    },
    {
        "id": "customfield_10001",
        "name": "餐厅门店编号",
        "custom": true,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "cf[10001]",
            "餐厅门店编号"
        ],
        "schema": {
            "type": "string",
            "custom": "com.atlassian.jira.plugin.system.customfieldtypes:textarea",
            "customId": 10001
        }
    },
    {
        "id": "customfield_10002",
        "name": "餐厅门店编号",
        "custom": true,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "cf[10002]",
            "餐厅门店编号"
        ],
        "schema": {
            "type": "string",
            "custom": "com.atlassian.jira.plugin.system.customfieldtypes:textfield",
            "customId": 10002
        }
    },
    {
        "id": "customfield_10003",
        "name": "餐厅区域",
        "custom": true,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "cf[10003]",
            "餐厅区域"
        ],
        "schema": {
            "type": "string",
            "custom": "com.atlassian.jira.plugin.system.customfieldtypes:textfield",
            "customId": 10003
        }
    },
    {
        "id": "customfield_10004",
        "name": "Assignable users",
        "custom": true,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [],
        "schema": {
            "type": "any",
            "custom": "com.sentinel.jira.plugin.jira-create-tasks-on-transition-plugin:UserCheckboxListCFType",
            "customId": 10004
        }
    },
    {
        "id": "environment",
        "name": "环境",
        "custom": false,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "environment"
        ],
        "schema": {
            "type": "string",
            "system": "environment"
        }
    },
    {
        "id": "duedate",
        "name": "到期日",
        "custom": false,
        "orderable": true,
        "navigable": true,
        "searchable": true,
        "clauseNames": [
            "due",
            "duedate"
        ],
        "schema": {
            "type": "date",
            "system": "duedate"
        }
    },
    {
        "id": "progress",
        "name": "进度",
        "custom": false,
        "orderable": false,
        "navigable": true,
        "searchable": false,
        "clauseNames": [
            "progress"
        ],
        "schema": {
            "type": "progress",
            "system": "progress"
        }
    },
    {
        "id": "comment",
        "name": "备注",
        "custom": false,
        "orderable": true,
        "navigable": false,
        "searchable": true,
        "clauseNames": [
            "comment"
        ],
        "schema": {
            "type": "comments-page",
            "system": "comment"
        }
    },
    {
        "id": "worklog",
        "name": "登记工作日志",
        "custom": false,
        "orderable": true,
        "navigable": false,
        "searchable": true,
        "clauseNames": [],
        "schema": {
            "type": "array",
            "items": "worklog",
            "system": "worklog"
        }
    }
];

exports.issueTypes = [
  {
    "self": "http://itsmpoc6341.cloudapp.net:90/rest/api/2/issuetype/10002",
    "id": "10002",
    "description": "餐厅门店报修事件",
    "iconUrl": "http://itsmpoc6341.cloudapp.net:90/secure/viewavatar?size=xsmall&avatarId=10300&avatarType=issuetype",
    "name": "StoreSupportCase",
    "subtask": false,
    "avatarId": 10300
  },
  {
    "self": "http://itsmpoc6341.cloudapp.net:90/rest/api/2/issuetype/10003",
    "id": "10003",
    "description": "服务商工单",
    "iconUrl": "http://itsmpoc6341.cloudapp.net:90/secure/viewavatar?size=xsmall&avatarId=10316&avatarType=issuetype",
    "name": "VendorSupportCase",
    "subtask": true,
    "avatarId": 10316
  },
  {
    "self": "http://itsmpoc6341.cloudapp.net:90/rest/api/2/issuetype/10000",
    "id": "10000",
    "description": "需要完成的任务。",
    "iconUrl": "http://itsmpoc6341.cloudapp.net:90/secure/viewavatar?size=xsmall&avatarId=10318&avatarType=issuetype",
    "name": "任务",
    "subtask": false,
    "avatarId": 10318
  },
  {
    "self": "http://itsmpoc6341.cloudapp.net:90/rest/api/2/issuetype/10001",
    "id": "10001",
    "description": "问题的子任务",
    "iconUrl": "http://itsmpoc6341.cloudapp.net:90/secure/viewavatar?size=xsmall&avatarId=10316&avatarType=issuetype",
    "name": "子任务",
    "subtask": true,
    "avatarId": 10316
  }
];