
var c = console.log;

var year = 2017
var month = 2
var day = 3
var hour = 4 
var minute = 5
var second = 6
var millisecond = 7
var d = new Date(year,month-1,day,hour,minute,second,millisecond);

// d.getDate() => day 
// d.getDay() => 5 (0 = sunday)
//c(d.getFullYear()); => year
//c(d.getHours()); => hour
//c(d.getMilliseconds()); => millisecond
//c(d.getMinutes()); => minute
//c(d.getMonth()); => month-1
//c(d.getSeconds()); => second
//c(d.getTime()); => 1486091106007
//c(d.getTimezoneOffset()); => -60
//c(d.getUTCDate()); => day
//c(d.getUTCDay()); => 5 (0 = sunday)
//c(d.getUTCFullYear()); => year
//c(d.getUTCHours()); => hour
//c(d.getUTCMilliseconds()); => millisecond
//c(d.getUTCMinutes()); => minute
//c(d.getUTCMonth()); => month-1
//c(d.getUTCSeconds()); => second
//c(d.getYear()); => year-1900
// d.setDate(day)
// d.setFullYear(year, month-1, day);
// d.setHours(hour, minute, second, millisecond);
// d.setMilliseconds(millisecond);
// d.setMinutes(minute, second, millisecond);
// d.setMonth(month-1, day);
// d.setSeconds(second, millisecond);
// d.setTime(1486091106007);
// d.setUTCDate(day);
// d.setUTCFullYear(year, month-1, day);
// d.setUTCHours(hour, minute, second, millisecond);
// d.setUTCMilliseconds(millisecond);
// d.setUTCMinutes(minute, second, millisecond);
// d.setUTCMonth(month-1, day);
// d.setUTCSeconds(second, millisecond);
// d.setYear(year-1900);
//c(d.toDateString()); => Fri Feb 03 2017
//c(d.toGMTString()); => Fri, 03 Feb 2017 03:05:06 GMT (deprecated)
//c(d.toISOString()); => 2017-02-03T03:05:06.007Z
//c(d.toJSON()); => 2017-02-03T03:05:06.007Z
//c(d.toLocaleDateString('fr-FR')); => 03/02/2017
//c(d.toLocaleDateString('en-US')); => 2/3/2017
//c(d.toLocaleDateString('en-GB')); => 03/02/2017
//c(d.toLocaleFormat()); deprecated
//c(d.toLocaleString('fr-FR')); => 03/02/2017 à 04:05:06
//c(d.toLocaleString('en-US')); => 2/3/2017, 4:05:06 AM
//c(d.toLocaleString('en-GB')); => 03/02/2017, 04:05:06
//c(d.toLocaleTimeString('fr-FR')); => 04:05:06
//c(d.toLocaleTimeString('en-US')); => 4:05:06 AM
//c(d.toLocaleTimeString('en-GB')); => 04:05:06
//c(d.toSource()); deprecated
//c(d.toString()); => Fri Feb 03 2017 04:05:06 GMT+0100 (Paris, Madrid)
//c(d.toTimeString()); => 04:05:06 GMT+0100 (Paris, Madrid)
//c(d.toUTCString()); => Fri, 03 Feb 2017 03:05:06 GMT
//c(d.valueOf()); => 1486091106007