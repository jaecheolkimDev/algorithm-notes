
// let input = "A*(B+C)";
// let input = "(A+(B*C))-(D/E)";
// let input = "A+B*C";
let input = "A+(B*C)*D*E+F";    // ABC*D*E*+F+
// const input = require('fs').readFileSync('/dev/stdin').toString().split(' ');   // 배열형태, 스페이스로 들어감.
// const input = require('fs').readFileSync('/dev/stdin').toString().split('\n');   // 배열형태, length-1(엔터때문)
// const input = require('fs').readFileSync('/dev/stdin').toString();   // 가능
// const input = (require('fs').readFileSync('/dev/stdin')+'').trim();     // 가능
let arr = [];
let str = '';
const peek = {'(':0,'+':1,'-':1,'*':2,'/':2};
postfix();
function postfix() {
    for(let i=0; i<input.length; i++) {
        if(is_regExpUpperCase(input[i])) {
            str += input[i];
        } else if(is_regExpToken(input[i])) {
            // 입력되는 연산자랑 스택의 연산자랑 우선순위 비교.
            /** 입력된 연산자가 스택의 맨 위 연산자보다 작거나 같을 경우 */
            while(arr.length > 0 && peek[input[i]] <= peek[arr[arr.length-1]]) {
                console.log(`peek[${input[i]}] : `, peek[input[i]]);
                console.log(`peek[${arr[arr.length-1]}] : `, peek[arr[arr.length-1]]);
                /** 스택의 연산자를 우선순위로 한다. */
                str += arr.pop();
            }
            /** 입력된 연산자가 스택의 맨 위 연산자보다 우선순위가 클 경우 */
            arr.push(input[i]);
        } else if("(" === input[i]) {
            arr.push(input[i]);
        } else if(")" === input[i]) {
            while(arr[arr.length-1] !== '(') {
                str += arr.pop();
            }
            arr.pop();
        } else {
            console.log('else!!!!!!!!!!!!!');
        }
        console.log("str : ", str);
        console.log("arr : ", arr);
    }
    // 마지막에 쌓인 스택을 비워준다.
    console.log("arr.length : ", arr.length);
    while(arr.length > 0) {
        str += arr.pop();
    }
    console.log(str);
}

function is_regExpUpperCase(x) {
    // 대문자
    var reg = /^[A-Z]$/;
    return reg.test(x);
}
function is_regExpToken(x) {
    // [연산자] => + , - , * , /
    // 특수문자를 특정 행동으로 해석하지 않고 문자 그대로 처리하려면 '\'를 붙여야됨.
    var reg = /^[\+|\-|\*|\/|]$/;
    return reg.test(x);
}