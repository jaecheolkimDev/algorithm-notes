const input = require('fs').readFileSync('dev/stdin').toString().split('\n');
// const input = [3, "40 80 60", "\n"];
// const input = [3, "10 20 30", "\n"];
// const input = [4, "1 100 100 100", "\n"];
// const input = [5, "1 2 4 8 16", "\n"];
// const input = [2, "3 10", "\n"];

const score = input[1].split(' ').map(Number);
score.sort((a,b) => b-a);
// console.log("자기 점수 중 최대값 : ", score[0]);

let res = 0;
for(let i=0; i<score.length; i++) {
    // console.log("score[i] : ", score[i]/score[0] * 100);
    res += score[i]/score[0] * 100;
}

console.log("res : ", res/input[0]);