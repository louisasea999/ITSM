var config = require('../config');
var dbHelper = require('./dbHelper');

exports.getServeHours = function (startDateString, endDateString, watchers, startWorkHour, endWorkHour) {
    var startDate = new Date(startDateString);
    var endDate = new Date(endDateString);

    if (watchers.length % 2 !== 0) {
        throw new Error('Bad watchers length.');
    }
    var serveHours = 0.0;

    for (var i = 0; i < watchers.length; i += 2) {
        // console.log(watchers[i], watchers[i + 1], getGapHours(new Date(watchers[i]), new Date(watchers[i + 1]), startWorkHour, endWorkHour));
        serveHours += getGapHours(new Date(watchers[i]), new Date(watchers[i + 1]), startWorkHour, endWorkHour);
    }
    // console.log(serveHours)
    serveHours = getGapHours(startDate, endDate, startWorkHour, endWorkHour) - serveHours;
    return format(serveHours);
}

exports.getSLAHours = function (serveHours, standardHours, timeoutCount) {
    return (serveHours - standardHours) / standardHours + timeoutCount;
}

exports.getStandardHours = function (zone, priority, done) {
    var standardHours = 0;
    getMappings(function (err, mappings) {
        if(err) {
            return done(err, 1);
        }
        for (var k = 0; k < mappings.length; k++) {
            var std = mappings[k];
            // std.zone_level is number and zone is string
            if (std.zone_level == zone && priority === ('P' + std.priority_level)) {
                standardHours = std.distance;
                break;
            }
        }
        done(null, standardHours);
    });
}

exports.getWatchers = function (histories) {
    var watchers = [];
    histories.forEach(function (his, i) {
        his.items.forEach(function (item, j) {
            if (item.field === '停表时间' && item.fieldtype === 'custom') {
                watchers.push(item.to);
            }
            if (item.field === '开表时间' && item.fieldtype === 'custom') {
                watchers.push(item.to);
            }
        })
    })

    if (watchers.length % 2 !== 0) {
        return -1
    }

    watchers.sort(function (a, b) {
        return a > b;
    })
    return watchers;
}

function format(n) {
    return parseFloat(n.toFixed(2));
}

function getHours(dd1, dd2) {
    if (dd1 > dd2) {
        return format((dd1.getTime() - dd2.getTime()) / 3600 / 1000)
    }
    return format((dd2.getTime() - dd1.getTime()) / 3600 / 1000)
}

function getDays(dd1, dd2) {
    return parseInt(getHours(dd1, dd2) / 24, 10);
}

function getGapHours(start, end, startWorkHour, endWorkHour) {
    var dh = getHours(start, end); // gap hours
    if (!startWorkHour && !endWorkHour) {
        return dh
    }
    var dd = end.getDate() - start.getDate(); // gap days

    var d1s = new Date(start.toISOString().split('T')[0] + startWorkHour)
    var d1e = new Date(start.toISOString().split('T')[0] + endWorkHour)
    var d2s = new Date(end.toISOString().split('T')[0] + startWorkHour);
    var d2e = new Date(end.toISOString().split('T')[0] + endWorkHour);
    var gap = 0.0;

    var front = 0.0;
    if (start <= d1s) {
        gap += (23 - 7);
    } else if (start >= d1e) {
        // do nothing
    } else {
        gap += getHours(start, d1e);
    }
    // console.log(gap)
    if (end >= d2e) {
        gap += (23 - 7);
    } else if (end <= d2s) {
        // do nothing
    } else {
        gap += getHours(d2s, end);
    }
    // console.log(gap)
    gap += (dd - 1) * (23 - 7);
    // console.log(gap)
    return gap;
}

function getMappings(done) {
    dbHelper.queryTable(config.db.table.sla_config, function (err, result) {
        if (err) {
            done(err, []);
        }
        if (Array.isArray(result.rows) === true) {
            done(null, result.rows)
        } else {
            done(null, []);
        }
    });
}

function getRobotToken(done) {
	dbHelper.queryTable(config.db.table.desk_robot_map, function(err, result) {
		if (err) {
            done(err, []);
        }
        if (Array.isArray(result.rows) === true) {
            done(null, result.rows)
			console.log(result.rows);
        } else {
            done(null, []);
        }
	})
}

exports.getRobotToken = getRobotToken;


function getZone(serviceDeskName, diningNo, done) {
    const str = `select ddm.dining_room_id, sd.service_desk_name, dr.dining_room_name, 
                    ddm.zone_level from itsm2.dining_desk_map as ddm, 
                    itsm2.dining_room as dr, itsm2.service_desk as sd`;
    dbHelper.queryString(str, function(err, result) {
        if(err) {
            return; done(err, null);
        }
        if (Array.isArray(result.rows) === true) {
            for(var x = 0; x < result.rows.length;x++) {
                var row = result.rows[x];
                if(row['service_desk_name'] === serviceDeskName && diningNo === row['dining_room_name']) {
                    return done(null, row['zone_level']);
                }
            }   
        }
    })
}

exports.getZone = getZone;

// getZone('服务站B', 'YUMC02', function(err, result) {
//     if(err) {
//         return;
//     }
//     console.log(result);
// });
//getRobotToken();

/*
var startDateString = '2017-04-12T06:41:45.118Z';
var endDateString = '2017-04-16T06:59:45.118Z';
var watchers = [
    '2017-04-12T10:30:45.118Z',
    '2017-04-12T12:30:45.118Z',
    '2017-04-13T16:41:45.118Z',
    '2017-04-13T23:20:45.118Z'
]
var startWorkHour = 'T00:00:00.000Z'
var endWorkHour = 'T00:00:00.000Z'

// var startWorkHour = 'T07:00:00.000Z'
// var endWorkHour = 'T23:00:00.000Z'

console.log(exports.sla(startDateString, endDateString, watchers, startWorkHour, endWorkHour));
*/