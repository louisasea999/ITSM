exports.getServeHours = function(startDateString, endDateString, watchers, startWorkHour, endWorkHour) {
    var startDate = new Date(startDateString);
    var endDate = new Date(endDateString);

    if (watchers.length % 2 !== 0) {
        throw new Error('Bad watchers length.');
    }
    var serveHours = 0.0;

    for (var i = 0; i < watchers.length; i += 2) {
        console.log(watchers[i], watchers[i + 1], getGapHours(new Date(watchers[i]), new Date(watchers[i + 1]), startWorkHour, endWorkHour));
        serveHours += getGapHours(new Date(watchers[i]), new Date(watchers[i + 1]), startWorkHour, endWorkHour);
    }
    // console.log(serveHours)
    serveHours = getGapHours(startDate, endDate, startWorkHour, endWorkHour) - serveHours;
    return format(serveHours);
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
    var dd =  end.getDate() - start.getDate(); // gap days

    var d1s = new Date(start.toISOString().split('T')[0] + startWorkHour)
    var d1e = new Date(start.toISOString().split('T')[0] + endWorkHour)
    var d2s = new Date(end.toISOString().split('T')[0] + startWorkHour);
    var d2e = new Date(end.toISOString().split('T')[0] + endWorkHour);
    var gap = 0.0;
    
    var front = 0.0;
    if(start <= d1s) {
        gap += (23 - 7);
    } else if(start >= d1e) {
        // do nothing
    } else {
        gap += getHours(start, d1e);
    }
    // console.log(gap)
    if(end >= d2e) {
        gap += (23 - 7);
    } else if(end <= d2s) {
        // do nothing
    } else {
        gap += getHours(d2s, end);
    }
    // console.log(gap)
    gap += (dd - 1) * (23 - 7);
    // console.log(gap)
    return gap;
}

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