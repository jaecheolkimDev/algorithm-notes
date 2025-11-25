// const input = require("fs").readFileSync("/dev/stdin").toString();
const input = 5;

let res = '';
for(let i=1; i<=input; i++) {
    res += "\n";
    for(let j=0; j<i; j++) {
        res += "*";
    }
}
for(let i=input-1; i>0; i--) {
    res += "\n";
    for(let j=0; j<i; j++) {
        res += "*";
    }
}
console.log(res.slice(1));