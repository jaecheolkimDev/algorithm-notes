// 삽입 (max heap 기준)
// 1. 힙의 가장 마지막 원소에 원하는 값을 삽입한다.
// 2. 부모가 삽입 원소보다 작다면(Max_Heap기준) 부모와 자식의 값을 교환한다.
// 3. 2번에서 부모가 없거나, 부모가 자식보다 클 경우에 종료

// 삭제 (max heap 기준)
// 1. 루트노드를 삭제하고 힙의 마지막 노드를 루트로 가져온다.
// 2. 가져온 루트와 자식노드를 비교하고 가져온 노드가 작을 경우 자식과 위치 변경
// 3. 자식 노드가 더이상 없거나, 자식보다 클 경우 종료

let Heap = [9,7,6,5,4,3,2,2,1,3];

// insert(8);
// deletee(Heap[0]);

function deletee(Node) {
    Heap.shift(Node);   // 앞에서부터 항목 제거하기.
    Heap.unshift(Heap[Heap.length-1]);   // 마지막 노드를 가져옴.
    Heap.pop();
    deleteNodeChange(1);
}

/**
 * 자식과 값 비교 후 => 노드 위치 바꾸기.
 * @param {부모의 index} hLength 
 */
function deleteNodeChange(hLength) {
    console.log("Heap : " + Heap);
    deleteCompare(hLength-1, 2*hLength-1, 2*hLength);  // index위치 전달 -> 값 비교 후 위치 바꿈.
    console.log("Heap : " + Heap);
    // let parentIndex = parseInt(hLength/2);  // 부모의 인덱스 찾기.
}

/**
 * 자식들끼리 값 비교 => 부모랑 비교 => 노드 위치 바꾸기.
 * @param {부모 index} parent 
 * @param {왼쪽자식 index} child1 
 * @param {오른쪽자식 index} child2 
 */
function deleteCompare(parent, child1, child2) {
    console.log("Heap[parent] : " + Heap[parent]);
    console.log("Heap[child1] : " + Heap[child1]);
    console.log("Heap[child2] : " + Heap[child2]);
    let tmp = 0;
    if(Heap[child1] > Heap[child2]) {
        console.log("왼쪽 자식이 더 큼");
        if(Heap[child1] > Heap[parent]) {
            console.log("부모보다 왼쪽 자식이 더 큼");
            tmp = Heap[parent];
            Heap[parent] = Heap[child1];
            Heap[child1] = tmp;
            deleteNodeChange(child1+1);
        } else {
            console.log("But, 부모가 더 큼.(끝)");
        }
        return;
    } else {
        console.log("오른쪽 자식이 더 큼");
        if(Heap[child2] > Heap[parent]) {
            console.log("부모보다 오른쪽 자식이 더 큼");
            tmp = Heap[parent];
            Heap[parent] = Heap[child2];
            Heap[child2] = tmp;
            deleteNodeChange(child2+1);
        } else {
            console.log("But, 부모가 더 큼.(끝)");
        }
        return;
    }
}

function insert(Node) {
    Heap.push(Node);
    // console.log("Heap.length : " + Heap.length);
    insertNodeChange(Heap.length);
}

/**
 * 부모와 값 비교 후 => 노드 위치 바꾸기.
 * @param {자식의 index} hLength 
 */
function insertNodeChange(hLength) {
    console.log("hLength : " + hLength);
    console.log("Heap : " + Heap);
    let parentIndex = parseInt(hLength/2);  // 부모의 인덱스 찾기.
    insertCompare(parentIndex-1, hLength-1);  // index위치 전달 -> 값 비교 후 위치 바꿈.
}

function insertCompare(parent, child) {
    console.log("Heap[parent] : " + Heap[parent]);
    console.log("Heap[child] : " + Heap[child]);
    let tmp = 0;
    if(Heap[parent] > Heap[child]) {
        console.log("부모가 더 큼(아무일도 안함)");
        return;
    } else {
        console.log("자식이 더 큼(위치 바꿈)");
        tmp = Heap[parent];
        Heap[parent] = Heap[child];
        Heap[child] = tmp;
        insertNodeChange(parent+1);
        return;
    }
}
