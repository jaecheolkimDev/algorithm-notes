// you can write to stdout for debugging purposes, e.g.
// console.log('this is a debug message');

function solution(A) {
    let ACopy = A.slice();

    let tmp1 = 0;
    let tmp2 = 1;
    if(A[0] === 1) {
        for(let i=1; i<A.length; i++) {
            if(A[i] === A[i-1]) {
                A[i] = A[i-1] === 0 ? 1 : 0;
                tmp1++;
            }
        }
        ACopy[0] = 0;
        for(let i=1; i<ACopy.length; i++) {
            if(ACopy[i] === ACopy[i-1]) {
                ACopy[i] = ACopy[i-1] === 0 ? 1 : 0;
                tmp2++;
            }
        }
    } else {
        for(let i=1; i<A.length; i++) {
            if(A[i] === A[i-1]) {
                A[i] = A[i-1] === 0 ? 1 : 0;
                tmp1++;
            }
        }
        ACopy[0] = 1;
        for(let i=1; i<ACopy.length; i++) {
            if(ACopy[i] === ACopy[i-1]) {
                ACopy[i] = ACopy[i-1] === 0 ? 1 : 0;
                tmp2++;
            }
        }
    }

    if(tmp1 > tmp2) {
        return tmp2;
    } else {
        return tmp1;
    }

}