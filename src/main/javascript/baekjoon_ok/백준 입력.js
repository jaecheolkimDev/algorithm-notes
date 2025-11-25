// 1번째 방법 : 라인 입력 받기.
const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input.push(line)
  })
  .on('close', function () {
    console.log(input);
    process.exit();
});
////////////////////////////////////////////////////////////////////////////////////////////////////
// 2번째 방법 : 라인 입력 받기 , 줄바꿈으로 구분 , 배열형태, length-1(엔터때문)
const input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
////////////////////////////////////////////////////////////////////////////////////////////////////
// 3번째 방법
// 문자열 형태(띄어쓰기같은거없음) , 배열형태 아님.
const input = require("fs").readFileSync("/dev/stdin").toString();
const input = (require('fs').readFileSync('/dev/stdin')+'').trim();     // 가능

// 한 칸 띄어쓰기로 구분
// input[0], input[1] 배열에서 꺼내쓰면 된다.
const input = require("fs").readFileSync("/dev/stdin").toString().split(" ");

// 만약 인풋값이 숫자라면
// .map(Number);
const input = require("fs").readFileSync("/dev/stdin").toString().split(" ")
  .map(function(a) {
    return +a
  })