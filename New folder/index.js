let date = new Date();


let week = ["sun", "mon", "tue", "wed", "thu", "fri", "sat"];

let day = week[date.getDay()]

let hr = date.getHours();
let min = date.getMinutes();
let sec = date.getSeconds();

let amPm = hr > 12? "PM": "AM";
hr = hr % 12;

console.log(day, "\n", hr, amPm, min, sec);