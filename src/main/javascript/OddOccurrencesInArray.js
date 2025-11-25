// function solution() {
    let A = [9,3,9,3,9,7,9];
    const resultMap = new Map();
    let result;
    for (let i = 0; i < A.length; i++) {
        resultMap.set(A[i], (resultMap.get(A[i]) || 0) + 1);
    }
    resultMap.forEach((value, key) => {
        if (value % 2 === 1) {
            result = key;
        }
    })
    // return result;
    console.log('result', result);
// }