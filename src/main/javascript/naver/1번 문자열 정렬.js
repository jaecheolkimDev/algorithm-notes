const input = "AcKwRdQOSNFJRB";
let arr = input.split('');

console.log('arr : ', input.length);

for(let i=0; i<input.length; i++) {
    // console.log('d : ', input.slice(i, 1));
    // arr.push(str.split(''));
    // input[0].split('') 함수는 구분자를 줘서 최대리밋갯수만큼 배열로 리턴함. 2개를 못나눔. 구분자필요.
}
// 잘 들어갔는지 확인.
console.log('arr : ', arr);

// 기본정렬은 안좋다.(?)
// console.log('arr3 : ', arr.sort());
// let b = arr.sort();
console.log('Result : ', arr.sort((a, b) => ((a>b) - (a<b))));
// let arrSort = arr.sort((a, b) => ((a>b) - (a<b)));
// if(arrSort.length > input[1]) {
//     console.log("arrSort : ", arrSort[input[1]-1]);
// } else {
//     console.log(-1);
// }