/**
 * [문제]
 *  주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 * [입력]
 *  첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
 * [출력]
 *  주어진 수들 중 소수의 개수를 출력한다.
 * [예제 입력]
 *  4
 *  1 3 5 7
 * [예제 출력]
 *  3
 ***********************************************************************************************
 * 소수
 *  - 자신보다 작은 두 개의 자연수를 곱하여 만들 수 없는 1보다 큰 자연수.
 *  - kjc : 약수가 1과 자기자신
 * 문제에 대한 접근 => [에라토스테네스의 체]
 *  1. 주어진 수들에서 최대값을 구함.
 *  2. 최대값의 제곱근까지만 약수의 여부를 검증하면 빠르게 구할 수 있음.
 *  3. 몫과 나누는 수 둘 중 하나는 N제곱근 이하이기 때문임.
 */
// const input = require('fs').readFileSync('dev/stdin').toString().split('\n');
const input = [4, "1 3 5 7", "\n"];
// const input = ["kjc test", "1 2 3", "\n"];
// const input = ["kjc test", "1 2 3 4", "\n"];
// const input = ["kjc test", "1 2 3 4 5", "\n"];
// const input = ["kjc test", "1 2 3 4 5 6 7 8 9 10 11 12", "\n"];

const numArr = input[1].split(' '); /** 띄어쓰기를 제외하고 구분해서 배열을 만듬. */
console.log("1번 : 주어진 수들을 배열로 변환 : ", numArr);
// console.log("length : ", numArr.length);

// console.log('sort : ', numArr.sort((a, b) => (b - a))); /** 정렬(내림차순) */
const max = numArr.sort((a, b) => (b - a))[0];
console.log("2번 : 주어진 수들 중 최대값 : ", max);


const sqrtnumArr = Math.sqrt(max);
console.log("3번 : 최대값의 제곱근 : ", sqrtnumArr);
const floornumArr = Math.floor(sqrtnumArr); // 주어진 숫자와 같거나 작은 정수 중에서 가장 큰 수를 반환합니다.
console.log("4번 : 위의 값과 같거나 크지 않은 정수 : ", Math.floor(sqrtnumArr));

for(let i=0; i<numArr.length; i++) {
    if(numArr[i] === 1) continue;   // 주어진 수에서 2보다 큰 수들만 판단한다.(주어지는 수 : 1~1000)
    for(let j=2; j<=floornumArr; j++) {
        if(numArr[i] === j.toString()) continue;   // 같은수는 처리하지 않는다.
        if(numArr[i]%j === 0) { // 나누어지면 소수가 아님.
            numArr[i] = 0;  // 소수가 아니면 0으로 처리함.
            break;
        }
    }
}
console.log("5번 : 최종점검 결과 : ", numArr);

/** 1보단 큰 수 중에 0으로 바꾸지 않은 값은 소수임. */
let result = 0; // 주어진 수들 중 소수의 개수
for(let i=0; i<numArr.length; i++) {
    if(numArr[i] > 1) {
        result++;
    }
}
console.log("6번 : 최종결과 : ", result);