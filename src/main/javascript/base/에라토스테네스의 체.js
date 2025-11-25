let minMax = [1, 10];   // 1,2,3 => 1,4,9
let range = []; // MIN ~ MAX 값 넣을 배열
let limit = parseInt(Math.sqrt(minMax[1]));
let cnt = 0;

// 1. 배열을 생성하여 초기화한다.
for(let i=minMax[0]; i<=minMax[1]; i++) {
    range.push(i);
}
console.log("range : ", range);
console.log("sqrt : ", Math.sqrt(minMax[1]));
console.log("sqrt : ", parseInt(Math.sqrt(minMax[1])));

// 2. 2부터 시작해서 특정 수의 배수에 해당하는 수를 모두 지운다.
// (지울 때 자기자신은 지우지 않고, 이미 지워진 수는 건너뛴다.)
// for(let i=1; i<minMax[1]; i++) {
for(let i=1; i<limit; i++) {
    console.log("i : ", i);
    if(range[i] === 0) continue; // 이미 지워진 수라면 건너뛰기

    // 이미 지워진 숫자가 아니라면, 그 배수부터 출발하여, 가능한 모든 숫자 지우기
    for(let j=2*i+1; j<minMax[1]; j=j+i+1) {
        range[j] = 0;
    }
}
console.log("range : ", range);

// 3. 2부터 시작하여 남아있는 수를 모두 출력한다.
for(let i=0; i<=minMax[1]-minMax[0]; i++) {
    if(range[i] !== 0) {
        // console.log("range[i] : ", range[i]);
        cnt++;
    }
}
console.log("소수의 갯수 : ", cnt); // 1~97 => 26개