let cnt = 0;
// var input = require("fs").readFileSync("/dev/stdin").toString().split(" ");
let input = [1, 1500];   // 1,2,3 => 1,4,9

// 1번 - 성공함.
// let arr = new Array(input[1] - input[0] + 1);

// 2번 - 실패함.
let arr = [];
for(let i=input[0]; i<=input[1]; i++) {
    arr.push(i);
}
// console.log("arr : ", arr);

for(let i=2; i<=Math.sqrt(input[1]); i++) {
    let power = i*i;
    let minSieve = Math.ceil(input[0] / power);     // 주어진 숫자보다 크거나 같은 숫자 중 가장 작은 숫자를 integer 로 반환합니다.
    let maxSieve = Math.floor(input[1] / power);    // 주어진 숫자와 같거나 작은 정수 중에서 가장 큰 수를 반환합니다.

    for(let j=minSieve; j<=maxSieve; j++) {
        arr[j*power - input[0]] = 0;
    }
}
// console.log("arr : ", arr);

while(arr.indexOf(0) > 0) {
    arr.splice(arr.indexOf(0), 1);
}
// console.log("arr : ", arr);

// MIN 과 MAX 를 포함한 사이부분에 제곱ㄴㄴ수가 얼마나 있는지 구해줌
for(let i=0; i<arr.length; i++) {
    // if(arr[i] !== 0) {
        cnt++;
    // }
}

console.log(cnt);