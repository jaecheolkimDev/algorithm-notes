const input = [8];
let sqrt = Math.sqrt(input[0]);
let minSieve = Math.ceil(sqrt);     // 주어진 숫자보다 크거나 같은 숫자 중 가장 작은 숫자를 integer 로 반환합니다.
let maxSieve = Math.floor(sqrt);    // 주어진 숫자와 같거나 작은 정수 중에서 가장 큰 수를 반환합니다.
console.log("sqrt : ", sqrt);
console.log("minSieve : ", minSieve);
console.log("maxSieve : ", maxSieve);