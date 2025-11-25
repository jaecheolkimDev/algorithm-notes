/**
 * 생각... 어차피 push하고 바로 뺄거라면 push를 안해도 상관없을듯하다.
 */
const input = [8, 4,3,6,8,7,5,2,1, "\n"];
// const input = [5, 1,2,5,3,4, "\n"];
// const input = ["MyTest", 1,4,3,5,2,6, "\n"];
// const input = ["MyTest", 1, "\n"];
// const input = ["MyTest", 1,2, "\n"];
// const input = ["MyTest", 1,2,3, "\n"];
// const input = ["MyTest", 3,1,2, "\n"];
// const input = ["MyTest", 1,3,4,2, "\n"];
// const input = ["MyTest", 1,2,3,4, "\n"];
// const input = ["MyTest", 3,1,2,4, "\n"];
// const input = ["MyTest", 4,2,3,1, "\n"];
// const input = ["MyTest", 4,3,2,1, "\n"];
// const input = ["MyTest", 4,3,2,1,5,6,7,8,9,10, "\n"];
// +[1] , 2345, ''
// -[] , 2345, 1
// +[2] , 345, 1
// -[] , 345, 12
// +[3] , 45, 12
// +[3,4] , 5, 12
// +[3,4,5] , '', 12
// -[3,4], '', 125
// +............

// const input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
input.pop();    // 마지막 엔터 제거.
input.shift();  // 처음의 카운트 제거.

const stack = [];   // 스택.
let inputIndex = 0; // 스택의 top값과 비교할 입력값의 index.
let num = 0;    // 스택에 들어갈 값.(1,2,3,4........)
let str = '';
while(true) {
    // console.log("stack.length : " , stack.length);
    // console.log("stack[stack.length-1] : " , stack[stack.length-1]);
    if(stack.length === 0 || input[inputIndex] !== stack[stack.length-1]) {
        /**
         * if(Stack 이 비었거나, Input 의 현재값이 스택의 값과 같다면)
         * Stack에 1부터 시작해서 PUSH.(+)
         */
        let pushValue = ++num;
        stack.push( pushValue );
        str += "\n+";
    } else if(input[inputIndex] === stack[stack.length-1]) {
        /**
         * if(Input 의 현재값이 스택의 값과 같다면)
         * Input의 인덱스를 다음으로 넘겨주고
         * Stack의 TOP을 POP.(-)
         */
        inputIndex++;
        stack.pop();
        str += "\n-";
    }
    console.log("str : ", str);
    console.log("[+] : num값증가, stack 쌓임.\n[-] : inputIndex값증가, stack 빠짐.");
    console.log("num : ", num);
    console.log("stack : ", stack);
    console.log(`input[${inputIndex}] : `, input[inputIndex]);
    console.log("input.length : ", input.length);
    if(num === input.length) {
        console.log("NO");
        break;
    }
    if(input.length === inputIndex) {
        // 8 === 8
        console.log( str.slice(1) );
        break;
    }
}