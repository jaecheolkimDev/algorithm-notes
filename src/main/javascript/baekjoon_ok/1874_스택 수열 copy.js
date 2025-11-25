const input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
input.pop();    // 마지막 엔터 제거.
input.shift();  // 처음의 카운트 제거.

const stack = [];   // 스택.
let inputIndex = 0; // 스택의 top값과 비교할 입력값의 index.
let num = 0;    // 스택에 들어갈 값.(1,2,3,4........)
let str = '';
while(true) {
    if(stack.length === 0 || input[inputIndex] !== stack[stack.length-1]) {
        let pushValue = ++num;
        stack.push( pushValue );
        str += "\n+";
    } else if(input[inputIndex] === stack[stack.length-1]) {
        inputIndex++;
        stack.pop();
        str += "\n-";
    }
    if(num === input.length) {
        console.log("NO");
        break;
    }
    if(input.length === inputIndex) {
        console.log( str.slice(1) );
        break;
    }
}