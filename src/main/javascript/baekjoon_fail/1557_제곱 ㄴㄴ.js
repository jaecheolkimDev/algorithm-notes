/**
 * 어떤수 N이 1이 아닌 제곱수로 나누어지지 않을 때, 이 수를 제곱ㄴㄴ수라고 한다.
 * 제곱수는 4, 9, 16, 25와 같은 것이고,
 * 제곱ㄴㄴ수는 1, 2, 3, 5, 6, 7, 10, 11, 13, ...과 같은 수이다.
 * K가 주어졌을 때, K번째 제곱ㄴㄴ수를 구하는 프로그램을 작성하시오.
 * 
 * [규칙]
 * 1번째 제곱수 = 4 = 2**2
 * 2번째 제곱수 = 9 = 3**2
 * 3번째 제곱수 = 16 = 4**2
 * 4번째 제곱수 = 25 = 5**2
 * ....
 * 4**n
 * 
 */
// const input = (require('fs').readFileSync('/dev/stdin')+'').trim();     // 가능
// .map(Number);
const input = 13;
// const input = 1000000000;
let mathCeil = Math.ceil(Math.sqrt(input)); // 주어진 숫자보다 크거나 같은 숫자 중 가장 작은 숫자를 integer 로 반환합니다.
console.log("mathCeil : ", mathCeil);
// let testNum = 1000000000;
// console.log("testNum : ", testNum);
// console.log("root(testNum) 근사값 : ", Math.ceil(Math.sqrt(testNum)));

let arrSquare = []; // 제곱수가 들어갈 배열. 4, 9, 16......
let nono = [];

// 1. 제곱수를 구해서 arr배열에 넣는다.
for(let i=2; i<=mathCeil; i++) {
    if(i>=4 && (i ^ 1) % 2 !== 0) continue;
    arrSquare.push(i**2);
}
console.log("arrSquare : ", arrSquare);

for(let i=1; i<input*2; i++) {
    nono.push(i);
}
// console.log("nono : ", nono);

for(let i=0; i<arrSquare.length; i++) {
    for(let j=0; j<nono.length; j++) {
        if(nono[j] === 0) continue;
        if(nono[j]%arrSquare[i] === 0) {
            nono[j] = 0;
        }
    }
}
// console.log("nono : ", nono);

while(nono.indexOf(0) > 0) {
    nono.splice(nono.indexOf(0), 1);
}
// console.log("nono : ", nono);

console.log("nono[input] : ", nono[input-1]);

/**
 * 1,2,3,5,6
 * 7,10,11,13,14
 * 15,17,19,21,22
 * 23
 */
/**
 */
// console.log("N번째 제곱수 : ", (input+1)**2);