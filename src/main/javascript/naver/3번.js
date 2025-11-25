/**
 * N개의 고유 정수로 구성된 배열 A
 * 배열 A를 오름차순으로 정렬
 * 먼저, 하나 이상의 슬라이스로 분할한다.(슬라이스는 연속 된 하위 배열)
 * 그런 다음 각 슬라이스를 정렬한다.
 * 그런 다음 정렬 된 슬라이스를 동일한 순서로 결합한다.
 * 올바르게 정렬 된 배열을 반환 할 최대 슬라이스 수를 반환하는 함수.
 */
const A = [2,4,1,6,5,9,7];   // 3
// const A = [4,3,2,6,1];   //  1
// const A = [2,1,6,4,3,7];    //  3

    let cnt = 0;
    let least = 0;
    let tmp = 0;
    if(A[A.length-1] !== 1) {
        for(let i=0; i<A.length-1; i++) {
            least = i;

            // 최솟값을 탐색한다.
            for(j=i+1; j<A.length; j++){
                if(A[j]<A[least]) {
                    least = j;
                    cnt++;
                }
            }
        
            // 최솟값이 자기 자신이면 자료 이동을 하지 않는다.
            if(i != least){
                tmp = A[i];
                A[i] = A[least];
                A[least] = tmp;
            }
        }
    } else {
        cnt = 1;
    }
    console.log("cnt : ", cnt);