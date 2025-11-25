/**
 * [아스키코드]
 * A=65,B=66,....,Z=90
 */
// let str = "Asdf";
let str = "Asdashg asdf asdf sadf asdff";
str = str.replace(/ /ig, '').toUpperCase();
console.log("str : " , str);

const arr = new Array(26);
for(let i=0; i<arr.length; i++) {
    arr[i] = 0;
}

for(let i=0; i<str.length; i++) {
    arr[str[i].charCodeAt(0) - 65]++;
}
// console.log("arr : ", arr);

for(let i=0; i<arr.length; i++) {
    if(arr[i] > 0) {
        console.log(`${String.fromCharCode(i+65)}의 갯수 : `, arr[i]);
    }
}