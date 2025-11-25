    /**
     * 머리 꼬리 연속된 동전
     * 역전되어야 하는 최소 코인 수는?
     */
    // const A = [1,0,1,0,1,1];    // 1
    // const A = [1,1,0,1,1];      // 2
    // const A = [1,0,1];          // 0
    const A = [0,1,1,0];        // 2


    let ACopy = A.slice();
    // console.log("ACopy : ", ACopy);

    let tmp1 = 0;
    let tmp2 = 1;
    if(A[0] === 1) {
        for(let i=1; i<A.length; i++) {
            if(A[i] === A[i-1]) {
                A[i] = A[i-1] === 0 ? 1 : 0;
                // console.log(`A[${i-1}] : `, A[i-1]);
                // console.log(`A[${i}] : `, A[i]);
                tmp1++;
            }
        }
        ACopy[0] = 0;
        // console.log("ACopy : ", ACopy);
        for(let i=1; i<ACopy.length; i++) {
            // console.log(`ACopy[${i}] : `, ACopy[i]);
            if(ACopy[i] === ACopy[i-1]) {
                ACopy[i] = ACopy[i-1] === 0 ? 1 : 0;
                tmp2++;
            }
        }
    } else {
        for(let i=1; i<A.length; i++) {
            if(A[i] === A[i-1]) {
                A[i] = A[i-1] === 0 ? 1 : 0;
                // console.log(`A[${i-1}] : `, A[i-1]);
                // console.log(`A[${i}] : `, A[i]);
                tmp1++;
            }
        }
        ACopy[0] = 1;
        // console.log("ACopy : ", ACopy);
        for(let i=1; i<ACopy.length; i++) {
            // console.log(`ACopy[${i}] : `, ACopy[i]);
            if(ACopy[i] === ACopy[i-1]) {
                ACopy[i] = ACopy[i-1] === 0 ? 1 : 0;
                tmp2++;
            }
        }
    }

    if(tmp1 > tmp2) {
        console.log("tmp2 : ", tmp2);
    } else {
        console.log("tmp1 : ", tmp1);
    }
