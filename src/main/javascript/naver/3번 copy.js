/**
 * N개의 고유 정수로 구성된 배열 A
 * 배열 A를 오름차순으로 정렬
 * 먼저, 하나 이상의 슬라이스로 분할한다.(슬라이스는 연속 된 하위 배열)
 * 그런 다음 각 슬라이스를 정렬한다.
 * 그런 다음 정렬 된 슬라이스를 동일한 순서로 결합한다.
 * 올바르게 정렬 된 배열을 반환 할 최대 슬라이스 수를 반환하는 함수.
 */
const A = [2,4,1,6,5,9,7];   // 3
// const A = [4,3,2,6,1];   //  1
// const A = [2,1,6,4,3,7];    //  3

const arr = [];
arr.push(A[0]);
let cnt = 0;
// let max = 0;
// let min = 100000;
// max = Math.max.apply(null, arr);
// min = Math.min.apply(null, arr);
// 선택정렬
let least = 0;
let tmp = 0;
for(let i=1; i<A.length; i++) {
    arr.push(A[i]);
    // if(A[i] A[i-1]) {   // 앞에꺼와 비교.
    //
    // }
    // if(A[i] A[i+1]) {   // 뒤에꺼와 비교.
    //
    // }
    
}
console.log("cnt : ", cnt);