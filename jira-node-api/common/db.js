var pg = require('pg');
var config = require('../config');

exports.mappings = [
    {
        "priority": 0,
        "zone": 1,
        "sla": 4,
        "remark": "7*16(7:00~23:00)"
    },
    {
        "priority": 0,
        "zone": 2,
        "sla": 8,
        "remark": "7*16(7:00~23:00)"
    },
    {
        "priority": 0,
        "zone": 3,
        "sla": 12,
        "remark": "7*16(7:00~23:00)"
    },
    {
        "priority": 0,
        "zone": 4,
        "sla": 24,
        "remark": "7*16(7:00~23:00)"
    },
    {
        "priority": 1,
        "zone": 1,
        "sla": 8,
        "remark": "7*16(7:00~23:00)"
    },
    {
        "priority": 1,
        "zone": 2,
        "sla": 12,
        "remark": "7*16(7:00~23:00)"
    },
    {
        "priority": 1,
        "zone": 3,
        "sla": 18,
        "remark": "7*16(7:00~23:00)"
    },
    {
        "priority": 1,
        "zone": 4,
        "sla": 32,
        "remark": "7*16(7:00~23:00)"
    },
    {
        "priority": 2,
        "zone": 1,
        "sla": 22,
        "remark": "7*16(7:00~23:00)"
    },
    {
        "priority": 2,
        "zone": 2,
        "sla": 24,
        "remark": "7*16(7:00~23:00)"
    },
    {
        "priority": 2,
        "zone": 3,
        "sla": 36,
        "remark": "7*16(7:00~23:00)"
    },
    {
        "priority": 2,
        "zone": 4,
        "sla": 48,
        "remark": "7*16(7:00~23:00)"
    },
    {
        "priority": 3,
        "zone": 1,
        "sla": 480,
        "remark": "不去除非工作时间"
    },
    {
        "priority": 3,
        "zone": 2,
        "sla": 480,
        "remark": "不去除非工作时间"
    },
    {
        "priority": 3,
        "zone": 3,
        "sla": 480,
        "remark": "不去除非工作时间"
    },
    {
        "priority": 3,
        "zone": 4,
        "sla": 480,
        "remark": "不去除非工作时间"
    }
]

const dbConfig = {
  user: config.db.user,
  database: config.db.database,
  password: config.db.password,
  host: config.db.host,
  port: config.db.port, 
  max: config.db.max, 
  idleTimeoutMillis: config.db.idleTimeoutMillis 
};

const pool = new pg.Pool(dbConfig);

pool.on('error', function (err, client) {
  console.error('idle client error', err.message, err.stack);
});

exports.query = function (text, values, callback) {
  return pool.query(text, values, callback);
};

exports.connect = function (callback) {
  return pool.connect(callback);
};