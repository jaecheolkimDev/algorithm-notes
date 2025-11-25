// const input = require("fs").readFileSync("/dev/stdin").toString();
const input = 5;

let res = '';
for(let i=input*2-1; i>0; i= i-2) { // 9 7 5 3 1
    res += "\n";
    for(let j=i; j<input*2-1; j=j+2) {
        res += " ";
    }
    for(let j=0; j<i; j++) {
        res += "*";
    }
}
for(let i=3; i<=input*2-1; i=i+2) {
    res += "\n";
    for(let j=i; j<input*2-1; j=j+2) {
        res += " ";
    }
    for(let j=0; j<i; j++) {
        res += "*";
    }
}
console.log(res.slice(1));