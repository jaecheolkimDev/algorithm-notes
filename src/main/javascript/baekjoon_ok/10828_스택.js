/**
정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 다섯 가지이다.

push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */
/**
 * kjc
 * 1. 현재 input 받는 방식(한줄씩이 한 배열로 들어옴.) => if문에서 push 잘라서 써야됨.(switch 힘듦)
 */
// const input = [14, "push 1", "push 2", "top", "size", "empty", "pop", "pop", "pop", "size", "empty", "pop", "push 3", "empty", "top"];
// const input = [14, "push", 1, "push", 2, "top", "size", "empty", "pop", "pop", "pop", "size", "empty", "pop", "push", 3, "empty", "top", "\n"];
// const input = [7, "pop", "top", "push 123", "top", "pop", "top", "pop"];
// const input = [7, "pop", "top", "push", 123, "top", "pop", "top", "pop", "\n"];
// const input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
input.pop();    // 마지막 엔터 제거.
input.shift();  // 처음의 카운트 제거.
// const cnt = input[0];
// console.log("input : ", input);

let result = '';
const res = [];
for(let i=0; i<input.length; i++) {
    if(Number.isInteger(input[i])) continue;
    let resLength = res.length;
    /** 1번버전 : IF문 */
    if(input[i].indexOf("push") === 0) {  // 문자열에서 포함된 값 찾기.
        let pushValue = input[i].slice(5);  // 문자열의 특정부분 발췌.
        res.push( pushValue );
    // if(input[i] === "push") {
    //     let pushValue = input[i+1];
    //     res.push( pushValue );
    } else if(input[i] === "pop") {
        let popValue = resLength > 0 ? res.pop() : -1;
        result += `\n${popValue}`;
    } else if(input[i] === "size") {
        result += `\n${resLength}`;
    } else if(input[i] === "empty") {
        let emptyValue = resLength > 0 ? 0 : 1;
        result += `\n${emptyValue}`;
    } else if(input[i] === "top") {
        let topValue = resLength > 0 ? res[resLength-1] : -1;
        result += `\n${topValue}`;
    }
    /** 2번버전 : IF문 */
    // switch(input[i]) {
    //     case "push" :
    //         let pushValue = input[i+1];
    //         res.push( pushValue );
    //         break;
    //     case "pop" :
    //         let popValue = resLength > 0 ? res.pop() : -1;
    //         result += `\n${popValue}`;
    //         break;
    //     case "size" :
    //         result += `\n${resLength}`;
    //         break;
    //     case "empty" :
    //         let emptyValue = resLength > 0 ? 0 : 1;
    //         result += `\n${emptyValue}`;
    //         break;
    //     case "top" :
    //         let topValue = resLength > 0 ? res[resLength-1] : -1;
    //         result += `\n${topValue}`;
    //         break;
    // }
}
console.log( result.slice(1) );