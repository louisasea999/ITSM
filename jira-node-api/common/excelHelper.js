const Excel = require('exceljs')
const workbook = new Excel.Workbook();

function readFile(wkbook, headers, startRow) {
    var worksheet = wkbook.getWorksheet(1);
    var rs = { error: null, result: [] };
    var hasHeader = false;

    if (headers && headers.length > 0) {
        if (headers.length !== worksheet.actualColumnCount) {
            rs.error = 'headers length is not match.';
            return rs;
        }
        hasHeader = true;
    }

    worksheet.eachRow({ includeEmpty: false }, function (row, rowNumber) {
        var rowValue = [];

        if (rowNumber > startRow) {
            row.eachCell({ includeEmpty: false }, function (cell, colNumber) {
                var obj = {};
                if (hasHeader === true) {
                    obj[headers[colNumber - 1]] = cell.value;
                } else {
                    obj[colNumber] = cell.value;
                }
                rowValue.push(obj);
            });
            rs.result.push(rowValue);
        }
    });
    return rs;
}

function parseExcel(filename, headers, startRow, done) {
    workbook.xlsx.readFile(filename).then(function (wkbook) {
        done(readFile(wkbook, headers, startRow));
    });
}

function parseCSV(filename, headers, startRow, done) {
    workbook.csv.readFile(filename).then(function (wkbook) {
        done(readFile(wkbook, headers, startRow));
    });
}

exports.parseExcel = parseExcel;

// const headers = ['category', 'department', 'role', 'description', 'permission'];

// parseExcel(__dirname + "/ITSM2.0.xlsx", headers, 2, function (data) {
//     console.log(data.result);
// });
