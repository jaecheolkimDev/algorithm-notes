// const input = require("fs").readFileSync("/dev/stdin").toString().split(" ");
const input = [734, 893, "\n"];

const nArr = ['', ''];
for(let i=0; i<input.length; i++) {
    for(let j=String(input[i]).length-1; j>=0; j--) {
        nArr[i] += String(input[i])[j]
    }
}
// console.log(nArr);
if(Number(nArr[0]) > Number(nArr[1])) {
    console.log(Number(nArr[0]));
} else {
    console.log(Number(nArr[1]));
}