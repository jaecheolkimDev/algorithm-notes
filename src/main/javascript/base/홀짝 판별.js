
function findParent(Node) {
    if((Node ^ 1) % 2 === 0) {  // 홀수
        console.log("INPUT값 홀수");
    } else if((Node ^ 1) % 2 !== 0) {    // 짝수
        console.log("INPUT값 짝수");
    }
}