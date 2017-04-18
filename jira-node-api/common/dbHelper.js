const pool = require('./db');
const config = require('../config');

const currentschema = `${config.db.database}.${config.db.schema}`


const dbconnect = function (done) {
    pool.connect(function (err, client) {
        if (err) {
            done(err, null);
        } else {
            done(null, client);
        }
    })
}

const queryTableByName = function (tablename, cb) {
    dbconnect(function (connecterr, client) {
        var result = [];

        if (connecterr) {
            cb(connecterr, result);
        } else {
            const query = client.query(`select * from ${currentschema}.${tablename}`);

            query.on('row', function(row) {
                result.push(row);
            })

            query.on('end', function() {
                cb(null, result);
            })
        }
    });
}

const queryTable = function(tablename, cb) {
    pool.query(`select * from ${currentschema}.${tablename}`, null, function(err, result) {
        cb(err, result);
    })
}

// exports.queryTableByName = queryTableByName;

exports.queryTable = queryTable;

// queryTable(config.db.table.sla_config, function (err, result) {
//     if (err) {
//         return err;
//     }
//     var rs = JSON.parse(JSON.stringify(result));
//     console.log(Array.isArray(rs.rows));
//     console.log(Array.isArray(result.rows));
// });

// show all schema
// >>select schema_name from information_schema.schemata
