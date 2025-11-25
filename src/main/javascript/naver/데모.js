// let A = [1,3,6,4,1,2];
// let A = [1,2,3];
// let A = [-1, -3];
let A = [-1, -3, 6, 1];

console.log('arr2 : ', A.sort((a, b) => ((a>b) - (a<b))));

let arr = A.sort((a, b) => ((a>b) - (a<b)));

/**
 * 케이스
 * 1. 양수일때
 * 2. 음수일때
 * 3. 섞여있을때
 */
let ans = 1;    // 1.양수 , 3.섞여있을때, 1이 나오면 값 증가 후 비교.
if(A[A.length - 1] <= 0){ // 2. 음수일때
    return 1;
}
for(let i=0; i < A.length; i++){
    if(A[i] > 0 && A[i] == ans){    // 핵심.
        ans++;
    }
}
console.log("ans : ", ans);