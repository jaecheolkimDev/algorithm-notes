/**
 * 어떤수 N이 1이 아닌 제곱수로 나누어지지 않을 때, 이 수를 제곱ㄴㄴ수라고 한다.
 * 제곱수는 4, 9, 16, 25와 같은 것이고,
 * 제곱ㄴㄴ수는 1, 2, 3, 5, 6, 7, 10, 11, 13, ...과 같은 수이다.
 * K가 주어졌을 때, K번째 제곱ㄴㄴ수를 구하는 프로그램을 작성하시오.
 * 
 * [규칙]
 * N번째 제곱수 : (input+1)**2
 * 1번째 제곱수 = 4 = 2**2
 * 2번째 제곱수 = 9 = 3**2
 * 3번째 제곱수 = 16 = 4**2
 * 4번째 제곱수 = 25 = 5**2
 * ....
 * 4**n
 * 
 * 1,2,3,5,6,7,10,11,13,14
 * 15,17,19,21,22,23,26,29,30
 * 31.....
 * 
 * Math.ceil(Math.sqrt(input)); // 주어진 숫자보다 크거나 같은 숫자 중 가장 작은 숫자를 integer 로 반환합니다.
 */
// const input = (require('fs').readFileSync('/dev/stdin')+'').trim();     // 가능
// .map(Number);
const input = 1000000000;
let cnt = Number(input);

let res = 1;
let bSquare = false;
while(cnt > 0) {
    bSquare = false;
    if(res < 4) {
    } else {
        for(let i=2; i<=Math.ceil(Math.sqrt(res)); i++) {
            if(res>=i**2 && res%i**2 === 0) {
                bSquare = true; // 제곱수 flag
                break;
            }
        }
        if(bSquare) {
            res++;
            continue;
        }
    }
    res++;  // 몇번째수의 값.
    cnt--;  // 몇번째수인지 카운트
}
console.log("res-1 : ", res-1);
