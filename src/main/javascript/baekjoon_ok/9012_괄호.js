/**
괄호 문자열(Parenthesis String, PS)은 두 개의 괄호 기호인 ‘(’ 와 ‘)’ 만으로 구성되어 있는 문자열이다.
그 중에서 괄호의 모양이 바르게 구성된 문자열을 올바른 괄호 문자열(Valid PS, VPS)이라고 부른다.
한 쌍의 괄호 기호로 된 “( )” 문자열은 기본 VPS 이라고 부른다. 만일 x 가 VPS 라면
이것을 하나의 괄호에 넣은 새로운 문자열 “(x)”도 VPS 가 된다. 그리고 두 VPS x 와 y를 접합(concatenation)시킨
새로운 문자열 xy도 VPS 가 된다. 예를 들어 “(())()”와 “((()))” 는 VPS 이지만
“(()(”, “(())()))” , 그리고 “(()” 는 모두 VPS 가 아닌 문자열이다. 

여러분은 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다. 
 */
// const input = [6, "(())())", "(((()())()", "(()())((()))"
//     , "((()()(()))(((())))()", "()()()()(()()())()", "(()((())()(", "/n"];
const input = [3, "((", "))", "())(()", "/n"];
// const input = ["kjc TEST CASE", "()()()(((((())))))", "))((", "))))", ") ( ( )", "(", ")(", "( ( ) )"
//     ,"(                                                                                                                                              )"
//     ,"())(", "/n"];
// const input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
input.pop();    // 마지막 엔터 제거.
input.shift();  // 처음의 카운트 제거.
console.log("input : ", input);

for(let i=0; i<input.length; i++) {
    const stack1 = [];
    let bPush = false;  // ')'만 나오는 경우 대비해서 push했었는지 체크.
    let cnt1 = 0;
    let cnt2 = 0;
    for(let j=0; j<input[i].length; j++) {
        if(input[i][j] === "(") {
            stack1.push( input[i][j] );
            bPush = true;
            cnt1++;
        } else if(input[i][j] === ")") {
            stack1.pop();
            cnt2++;
        }
    }
    if(cnt1 === cnt2 && bPush && stack1.length === 0) {
        console.log("YES");
    } else {
        console.log("NO");
    }
}