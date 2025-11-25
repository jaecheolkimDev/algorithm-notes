
// const input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
const input = ["This is String", "SPACE    1    SPACE", " S a M p L e I n P u T ", "0L1A2S3T4L5I6N7E8"];

let res = '';
for (let i = 0; i < input.length-1; i++) {
    let cntArr = [0,0,0,0];
    for(let j=0; j<input[i].length; j++) {
        if(is_regExp(input[i][j], 1)) {
            cntArr[0] += 1;
        } else if(is_regExp(input[i][j], 2)) {
            cntArr[1] += 1;
        } else if(is_regExp(input[i][j], 3)) {
            cntArr[2] += 1;
        } else if(is_regExp(input[i][j], 4)) {
            cntArr[3] += 1;
        }
    }
    res += `${cntArr[0]} ${cntArr[1]} ${cntArr[2]} ${cntArr[3]} \n`;
}
console.log(res);


//  cf) space가 true면 공백문자를 포함한다.
/**
 * 정규식 검사
 * 1. 소문자
 * 2. 대문자
 * 3. 숫자
 * 4. 공백
 */
function is_regExp(x, chk) {
    if (chk === 1) {    // 소문자
        var reg = /^[a-z]+$/;
        return reg.test(x);
    } else if(chk === 2){   // 대문자
        var reg = /^[A-Z]+$/;
        return reg.test(x);
    } else if(chk === 3){   // 숫자
        var reg = /^[0-9]+$/;
        return reg.test(x);
    } else if(chk === 4){   // 공백
        var reg = /^[ ]+$/;
        return reg.test(x);
    }
}