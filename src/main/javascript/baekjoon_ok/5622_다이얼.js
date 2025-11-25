/**
 * 1 => 2초
 * 2 => 3
 * 3 => 4
 * 4 => 5
 * 5 => 6
 * 6 => 7
 * 7 => 8
 * 8 => 9
 * 9 => 10
 * 0 => 11
 * 868242 => 9 7 9 3 5 3 => 36초
 */
const input = require("fs").readFileSync("/dev/stdin").toString();
// const input = ["UNUCIC", "\n"];

let cnt = 0;
for(let i=0; i<input.length; i++) {
    if(input[i] === "A" || input[i] === "B" || input[i] === "C") {
        cnt = cnt + 3;
    } else if(input[i] === "D" || input[i] === "E" || input[i] === "F") {
        cnt = cnt + 4;
    } else if(input[i] === "G" || input[i] === "H" || input[i] === "I") {
        cnt = cnt + 5;
    } else if(input[i] === "J" || input[i] === "K" || input[i] === "L") {
        cnt = cnt + 6;
    } else if(input[i] === "M" || input[i] === "N" || input[i] === "O") {
        cnt = cnt + 7;
    } else if(input[i] === "P" || input[i] === "Q" || input[i] === "R" || input[i] === "S") {
        cnt = cnt + 8;
    } else if(input[i] === "T" || input[i] === "U" || input[i] === "V") {
        cnt = cnt + 9;
    } else if(input[i] === "W" || input[i] === "X" || input[i] === "Y" || input[i] === "Z") {
        cnt = cnt + 10;
    }
}
console.log(cnt);