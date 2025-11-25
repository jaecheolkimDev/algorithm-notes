// const input = require('fs').readFileSync('dev/stdin').toString().split('\n');
const input = ["1 1", "2 3", "3 4", "9 8", "5 2", "\n"];

console.log("input.length : ", input.length);

for(let i=0; i<input.length-1; i++) {
    let arr = input[i].split(' ');
    let x = Number(arr[0]);
    let y = Number(arr[1]);
    console.log(x+y);
}