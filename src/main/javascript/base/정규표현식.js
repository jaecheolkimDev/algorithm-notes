/**
 * [플래그]
 * i : Ignore Case	대소문자를 구별하지 않고 검색한다.
 * g : Global	문자열 내의 모든 패턴을 검색한다.
 * m : Multi Line	문자열의 행이 바뀌더라도 검색을 계속한다.
 */

// 공백제거
let str = "Asdashg asdf asdf sadf asdff";
str = str.replace(/ /ig, '');
console.log("str : " , str);

//  cf) space가 true면 공백문자를 포함한다.
/**
 * 정규식 검사
 * 대문자
 */
function is_regExp(x) {
    // 대문자
    var reg = /^[A-Z]+$/;
    return reg.test(x);
}
function is_regExp2(x) {
    // 연산자 + , - , * , /
    // 특수문자를 특정 행동으로 해석하지 않고 문자 그대로 처리하려면 '\'를 붙여야됨.
    var reg = /^[\+\-\*\/]+$/;
    return reg.test(x);
}
function is_regExp3(x) {
    // '/' 사이에 작성함 '/'
    // []내의 문자는 or로 동작한다.
    // |를 사용하면 or의 의미를 가지게 된다.
    // ^ : 문자열의 처음을 의미한다.
    // $ : 문자열의 끝을 의미한다.
    // 특수문자를 특정 행동으로 해석하지 않고 문자 그대로 처리하려면 '\'를 붙여야됨.
    var reg = /^\([A-Z][\+|\-|\*|\/][A-Z]\)$/;
    console.log('ㅁㄴㅇㄹ : ' , x.search(reg)); // 2 ← index
    console.log('234 : ' , x.match(reg)); // [ 'is', 'is' ]
    console.log('res : ', reg.exec(x)); // [ 'is', index: 5, input: 'Is this all there is?' ]
    return reg.test(x);
}