const input = require('fs').readFileSync('dev/stdin').toString().split('\n');
// const input = [2, "3 ABC", "5 /HTP", "\n"];

const nCase = input[0]; // case의 갯수

const nArr = [];    // 각 케이스의 반복횟수
const sArr = [];    // 각 케이스의 문자열
for(let i=0; i<nCase; i++) {
    nArr.push(Number(input[i+1].split(' ')[0]));
    sArr.push(input[i+1].split(' ')[1]);
}
// console.log("nArr : ", nArr);
// console.log("sArr : ", sArr);

let res = '';
for(let i=0; i<nArr.length; i++) {
    res += '\n';
    for(let j=0; j<sArr[i].length; j++) {
        for(let k=0; k<nArr[i]; k++) {
            res += sArr[i][j]
        }
    }
}
console.log("res : ", res.slice(1));