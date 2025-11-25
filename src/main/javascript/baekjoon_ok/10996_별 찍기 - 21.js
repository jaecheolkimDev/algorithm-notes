// const input = require("fs").readFileSync("/dev/stdin").toString();
const input = 3;
// console.log("input/2 : ", Math.ceil(input/2));
const input2 = Math.ceil(input/2);
let res = '';
for(let i=0; i<input; i++) {
    res += "\n";
    for(let j=0; j<input2; j++) {
        // console.log("j : ", j);
        if(j !== 0) {
            res += " ";
        }
        res += "*";
    }
    res += "\n";
    let limit = input%2 === 0 ? input2 : input2-1;
    for(let j=0; j<limit; j++) {
        // console.log("k : ", j);
        res += " *";
    }
}
console.log(res.slice(1));