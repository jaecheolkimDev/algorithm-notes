/**
 * 입력은 없다.
 * 10,000보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 증가하는 순서로 출력한다.
 * 
 * 셀프넘버가 아닌수
 *  => 현재수 + 각자리수 => 새로운값.
 * 
 * 셀프넘버가 아닌수를 구해서.. 체크되지 않은것들은 셀프넘버이다.!!!
 */

const arr = new Array(10001);
for(let i=0; i<arr.length; i++) {
    arr[i] = true;
}

let num = 0;
for(let i=1; i<arr.length; i++) {
    if(!arr[i]) continue;

    console.log("i : ", i);
    num = i;
    while(num < 10000) {
        // console.log("num : ", num);
        let sum = 0;
        for(let i=0; i<String(num).length; i++) {
            sum += Number(String(num)[i]);
        }
        num = num + sum;
        if(!arr[num]) continue;
        arr[num] = false;
        continue;
    }
}
// let cnt = 0;
// for(let i=0; i<arr.length; i++) {
//     if(!arr[i]) {
//         cnt++;
//     }
// }
// console.log("cnt : ", cnt);