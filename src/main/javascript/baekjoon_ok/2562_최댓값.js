// const input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
const input = [3, 29, 38, 12, 57, 74, 40, 85, 61, "\n"];

const arr = input.slice(0,9);
// console.log("arr : ", arr);

const arrSort = arr.sort((a,b) => b-a);
// console.log("arrSort : ", arrSort);
// console.log("arrSort[0] : ", arrSort[0]);
// console.log("arr : ", arr);
let res = '';
res += arrSort[0];
res += "\n";
res += (Number(input.indexOf(arrSort[0])) + 1);
console.log(res);
