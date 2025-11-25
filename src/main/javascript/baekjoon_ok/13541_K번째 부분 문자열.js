let arr = [];
const input = ["abab", 4];
// const input = require('fs').readFileSync('/dev/stdin').toString().split('\n');

for(let i=0; i<input[0].length; i++) {
    // console.log('d : ', input[0].slice(i, i+1));
    for(let j=i; j<input[0].length; j++) {
        arr.push(input[0].slice(i, j+1));
        // input[0].split('') 함수는 구분자를 줘서 최대리밋갯수만큼 배열로 리턴함. 2개를 못나눔. 구분자필요.
    }
}
// 잘 들어갔는지 확인.
console.log('arr1 : ', arr);

// 기본정렬은 안좋다.(?)
// console.log('arr3 : ', arr.sort());
// let b = arr.sort();
console.log('arr2 : ', arr.sort((a, b) => ((a>b) - (a<b))));
let arrSort = arr.sort((a, b) => ((a>b) - (a<b)));
if(arrSort.length > input[1]) {
    console.log("arrSort : ", arrSort[input[1]-1]);
} else {
    console.log(-1);
}

// 정렬이 똑같은지 확인
// for(let i=0; i<arr.length; i++) {
//     if(a[i] === b[i]) {
//     } else {
//         console.log('틀ㄹㄹㄹㄹㄹㄹ');
//     }
// }
