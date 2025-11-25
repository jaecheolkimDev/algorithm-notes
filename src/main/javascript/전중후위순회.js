// 모르겠다.

let pre = [27,16,9,12,54,36,72];    // ROOT L R
let inn = [9,12,16,27,36,54,72];    // L ROOT R
let post = [];                      // L R ROOT
let leftRightCnt = Math.floor(pre.length/2);
console.log("pre.length : ", pre.length);
console.log("pre.length : ", Math.floor(pre.length/2));

let preLeft = pre.slice(1, leftRightCnt+1); // 사본을 만드는 방법 => ["딸기", "망고"]
let preRight = pre.slice(1, leftRightCnt+1); // 사본을 만드는 방법 => ["딸기", "망고"]
let innLeft = inn.slice(leftRightCnt+1); // 사본을 만드는 방법 => ["딸기", "망고"]
let innRight = inn.slice(leftRightCnt+1); // 사본을 만드는 방법 => ["딸기", "망고"]
let preLeftArr = preLeft.sort((a, b) => ((a>b) - (a<b)));
let preRightArr = preRight.sort((a, b) => ((a>b) - (a<b)));
let innLeftArr = innLeft.sort((a, b) => ((a>b) - (a<b)));
let innRightArr = innRight.sort((a, b) => ((a>b) - (a<b)));
console.log("pre.length : ", preLeftArr);
console.log("pre.length : ", preRightArr);
console.log("pre.length : ", innLeftArr);
console.log("pre.length : ", innRightArr);
for(let i=0; i<preLeftArr.length; i++) {
    
}