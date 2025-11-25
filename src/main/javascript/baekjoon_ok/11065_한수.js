const input = require("fs").readFileSync("/dev/stdin").toString();   // 문자열 형태의 입력
// const input = "110";
// const input = "1";
// const input = "210";
// const input = "1000";

let cnt = 0;
for(let i=1; i<=input; i++) {
    if(i < 100) {
        cnt++;
        continue;
    } else {
        let diff = 0;
        // console.log("Number(String(num)[i]) : " , String(num)[i]);
        // console.log("Number(String(num)[i]) : " , String(i).length);
        for(let j=0; j<String(i).length; j++) {
            // console.log("j : ", String(i)[j]);
            if(j === 1) {
                diff = Number(String(i)[j]) - Number(String(i)[j-1]);
            } else if(j === 2) {
                if(diff === Number(String(i)[j]) - Number(String(i)[j-1])) {
                    cnt++;
                }
            }
        }
        // console.log("length : ", i.toString().length);
    }
}
console.log("cnt : ", cnt);