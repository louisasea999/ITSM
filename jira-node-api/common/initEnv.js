const rq = require('./request');
const config = require('../config');
var output = require('./output').output;

global.customFields = {
    diningArea: {
        name: '餐厅区域',
        id: '',
        type: 'string'
    },
    slaHours: {
        name: 'SLA',
        id: '',
        type: 'number'
    },
    timeoutCounter: {
        name: 'SLA超期计数',
        id: '',
        type: 'number'
    },
    endIssueDate: {
        name: '结案时间',
        id: '',
        type: 'datetime'
    },
    endIssueDistance: {
        name: '结案距离',
        id: '',
        type: 'number'
    },
    startWatchDate: {
        name: '开表时间',
        id: '',
        type: 'datetime'
    },
    stopWatchDate: {
        name: '停表时间',
        id: '',
        type: 'datetime'
    },
    eventType: {
        name: '案件类型',
        id: '',
        type: 'select'
    },
    serveStation: {
        name: '服务站',
        id: '',
        type: 'string'
    },
    endIssueLocation: {
        name: '结案位置',
        id: '',
        type: 'string'
    },
    zone: {
        name: '餐厅与服务站Zone',
        id: '',
        type: 'string'
    },
    startProcessDate: {
        name: '开始处理时间',
        id: '',
        type: 'datetime'
    },
    processArea: {
        name: '处理区域',
        id: '',
        type: 'string'
    },
    storeNo: {
        name: '餐厅门店编号',
        id: '',
        type: 'string'
    },
    storeArea: {
        name: '餐厅区域',
        id: '',
        type: 'string'
    }
};

global.standard = {
    workHours:['T07:00:00.000Z', 'T23:00:00.000Z'],
    noWorkHours: ['T00:00:00.000Z', 'T00:00:00.000Z']
}

exports.init = function () {
    rq.getRequest(config.v2.field).then(function (allfields) {
        const fields = JSON.parse(allfields);

        for (var i = 0; i < fields.length; i++) {
            if (fields[i]['custom'] === true) {
                for (var cf in global.customFields) {
                    if (global.customFields[cf].name === fields[i].name) {
                        global.customFields[cf].id = fields[i].id;
                        global.customFields[cf].name = fields[i].name;
                        global.customFields[cf].type = fields[i].schema.type;
                    }
                }
            }
        }
    }).catch(function (err) {
        output(err);
    })
}

exports.init();