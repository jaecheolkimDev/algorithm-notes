// const input = require('fs').readFileSync('dev/stdin').toString().split('\n');
const input = [5, "20 10 35 30 7", "\n"];

const cnt = input[0];
const arr = input[1].split(' ');
console.log("arr : ", arr);
console.log("arr : ", arr.sort((a,b) => a-b));
const resArr = arr.sort((a,b) => a-b);
const min = Number(resArr[0]);
const max = Number(resArr[cnt-1]);

console.log(`${min} ${max}`);