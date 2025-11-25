/**
 * [문자열 = 배열]
 *  slice(2) => 0,1번째 idx를 제외한 2번째 idx부터 문자열을 추출한다.
 */
// const input = require("fs").readFileSync("/dev/stdin").toString();
// const input = "ljes=njak";
// const input = "ddz=z=";
// const input = "nljj";
// const input = "c=c=";
// const input = "mlc-j";
// const input = "1";
// const input = "cz=";
const input = "ㅁㄴㅇㄹㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ";

let croatia = input;
let cnt = 0;
while(croatia.length > 0) {
    if(croatia.length >= 3 && (croatia.slice(0, 3) === "dz=")) {
        croatia = croatia.slice(3);
        // croatia = croatia.slice(0, croatia.indexOf("c=")) + croatia.slice(croatia.indexOf("c=")+2);
    } else if(croatia.length >= 2
    && (croatia.slice(0, 2) === "c=" || croatia.slice(0, 2) === "c-" || croatia.slice(0, 2) === "d-"
     || croatia.slice(0, 2) === "lj" || croatia.slice(0, 2) === "nj" || croatia.slice(0, 2) === "s="
     || croatia.slice(0, 2) === "z="))
    {
        croatia = croatia.slice(2);
    } else if(croatia.length >= 1) {
        console.log("croatia.slice(1) : ", croatia.slice(1));
        croatia = croatia.slice(1);
    }
    cnt++;
    continue;
}
// console.log("남아있는 문자열 : ", croatia);
// console.log("남아있는 문자열 길이 : ", croatia.length);
console.log(cnt);