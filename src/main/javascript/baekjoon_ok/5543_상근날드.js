// const input = require('fs').readFileSync('dev/stdin').toString().split('\n');
const input = [800, 700, 900, 198, 330, "\n"];
const input = [1999, 1999, 100, 189, 100, "\n"];
const input = [500, 400, 300, 200, 100, "\n"];
const burgerArr = input.slice(0,3);
const drinkArr = input.slice(3,5);

console.log("burgerArr : ", burgerArr);
console.log("drinkArr : ", drinkArr);
console.log("burgerArr : ", burgerArr.sort((a,b) => a-b));
console.log("drinkArr : ", drinkArr.sort((a,b) => a-b));
const burger = burgerArr.sort((a,b) => a-b)[0];
const drink = drinkArr.sort((a,b) => a-b)[0];
console.log(Number(burger) + Number(drink) - 50);
