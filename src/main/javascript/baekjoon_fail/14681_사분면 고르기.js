/**
 * 계속 [런타임 에러]
 * 절대 잘못된 소스라고 생각안하는데,,, 채점이 이상한거 같음.
 */

const input = require('fs').readFileSync('dev/stdin').toString().split('\n');
// const input = [12, 5];
// const input = [9, -13];
const x = Number(input[0]);
const y = Number(input[1]);
if(x > 0 && y > 0) {
    console.log(1);
} else if(x < 0 && y > 0) {
    console.log(2);
} else if(x < 0 && y < 0) {
    console.log(3);
} else if(x > 0 && y < 0) {
    console.log(4);
}