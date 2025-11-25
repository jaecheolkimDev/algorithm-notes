/**
 * Number.isInteger()
 * 정수인지 판별해주는 함수이다.
 */

let n = 3;

let ret = Number.isInteger(Math.sqrt(n)) ? (Math.sqrt(n)+1)**2 : -1;

console.log("ret : " + ret);