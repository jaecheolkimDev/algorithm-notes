// const input = "()(((()())(())()))(())";
const input = "(((()(()()))(())()))(()())";
// const input = require("fs").readFileSync("/dev/stdin").toString();

const arr = [];
let result = 0;
let bContinue = false;
for(let i=0; i<input.length; i++) {
// for(let i in input) {
    if(input[i] === "(") {
        let pushValue = input[i];
        arr.push( pushValue );
    } else if(input[i] === ")") {
        arr.pop();
        if(bContinue) {
            result += 1;
        } else {
            result += arr.length;
        }
        // 바로 뒤에 ')'가 이어서 나오면 그 다음에는 result+1 만 해준다.
        if(input[i+1] === ")") {
            bContinue = true;
        } else {
            bContinue = false;
        }
    }
    // console.log(`${i+1} 번쨰(${input[i]}) : `, result );
}
console.log("result : ", result );