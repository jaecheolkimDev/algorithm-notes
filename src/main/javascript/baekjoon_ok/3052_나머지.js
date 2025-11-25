// const input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
const input = [39, 40, 41, 42, 43, 44, 82, 83, 84, 85, "\n"];

const arr = [];
for(let i=0; i<input.length-1; i++) {
    if(arr.indexOf(input[i]%42) > -1) continue;
    arr.push(input[i]%42);
}
console.log("arr : ", arr.length);

// console.log("rest : ", 39%42); // 39
// console.log("rest : ", 40%42); // 40
// console.log("rest : ", 41%42); // 41
// console.log("rest : ", 42%42); // 0
// console.log("rest : ", 43%42); // 1
// console.log("rest : ", 44%42); // 2
// console.log("rest : ", 82%42); // 40
// console.log("rest : ", 83%42); // 41
// console.log("rest : ", 84%42); // 0
// console.log("rest : ", 85%42); // 1