/**
 * Completable Binary Tree  : 완전 이진 트리
 * Perfect Binary Tree      : 포화 이진 트리
 * Full Binary Tree         : 전 이진 트리
 * 
 * node         : 트리를 구성하고 있는 각 요소
 * Edge(간선)   : 트리를 구성하기 위해 노드와 노드를 연결하는 선
 * Root Node    : 최상위 계층에 존재하는 노드
 * level        : 트리의 특정 깊이를 가지는 노드의 집합
 * degree(차수) : 하위 트리 개수 / 간선 수 (degree) = 각 노드가 지닌 가지의 수
 * Terminal Node ( = leaf Node, 단말 노드) : 하위에 다른 노드가 연결되어 있지 않은 노드
 * Internal Node (내부노드, 비단말 노드)    : 단말 노드를 제외한 모든 노드로 루트 노드를 포함한다.
 * 
 * 루트노드는 Level-0 부터 시작.
 * 이진트리는 트리를 구성하는 노드들의 최대 차수(degree)가 2인 노드들로 구성되는 트리이다.
 * 
 * 이진트리의 레벨 i에서 가질 수 있는 최대 노드의 수는 2^i이다. (i>=0)
 * 깊이가 k인 이진트리가 가질 수 있는 최대 노드의 수는 2^k-1이다.(k>=1)
 * 
 */

let index = 1;  // 어떤 노드의 인덱스
let leftIndex = 2*index + 1;    // 왼쪽 자식노드의 인덱스
let rightIndex = 2*index + 2;   // 오른쪽 자식노드의 인덱스

console.log("index : ", index);
console.log("leftIndex : ", leftIndex);
console.log("rightIndex : ", rightIndex);

function preOrder(node) {
    /**
     * 처음 console.log 함수로 Root 노드의 값(value)을 처리하고
     * 왼쪽 서브 트리와 오른쪽 서브 트리를 순서대로
     * 순환 호출하여 전위 순회 문제를 해결한다.
     */
    console.log("Root -> Left -> Right");
    preOrder(node => left);
    preOrder(node => right);
}
function inOrder(node) {
    /**
     * 왼쪽 서브트리를 먼저 순환 재귀 호출로 방문하고
     * console.log 함수로 루트 노드의 값(value)을 처리한다.
     * 마지막으로 오른쪽 서브 트리를 순환 재귀 호출로 방문한다.
     */
    inOrder(node => left);
    console.log("Left -> Root -> Right");
    inOrder(node => right);
}
function postOrder(node) {
    /**
     * 왼쪽 서브 트리와 오른쪽 서브 트리 순서대로
     * 순환 재귀 호출로 방문하여
     * 마지막으로 루트 노드의 값을 처리함으로써 종료된다.
     */
    postOrder(node => left);
    postOrder(node => right);
    console.log("Left -> Right -> Root");
}
/**
 * [이진트리 - 트리의 노드 개수를 계산]
 * 방문한 노드가 null 값이면 0으로 반환하고,
 * 반환 값을 순환 재귀 호출로 왼쪽 서브 트리와 오른쪽 서브 트리를 더해서 반환(return) 해줍니다.
 * 여기서 +1은 자기 자신을 의미합니다.
 * 만약에 자식 노드가 없는 단말 노드일 경우에는 반환할 때 왼쪽 서브 트리와 오른쪽 서브 트리가 0이겠죠??
 * 그래서 +1을 해줍니다.
 */
function countNode(node) {
    if(node === null) return 0;
    return 1 + countNode(node => left) + countNode(node => right);
}
/**
 * [폴더 용량 계산]
 * 폴더 용량 계산은 대표적인 후위 순회 예시로 노드가 존재하지 않을 경우 반환 값을 0으로 해주고,
 * 반환 해줄 때 자신의 값(value)과 왼쪽 서브 트리 오른쪽 서브 트리의 값을 더해줘서 반환해줍니다.
 */
function calcSize(node) {
    if(node === null) return 0;
    return node => data + calcSize(node => left) + calcSize(node => right);
}
/**
 * [이진트리 - 트리의 단말노드 개수를 계산]
 * 단말 노드의 개수를 구할 때는 자식 노드가 없을 때 반환 값을 1로 해주면 됩니다.
 * 물론 자식 노드가 아닐 경우 계속 반환을 왼쪽 서브 트리와 오른쪽 서브 트리를 해야겠죠??
 */
function countLeaf(node) {
    if(node === null) return 0;
    if((node => left === null) && (node => right === null)) return 1;
    return countLeaf(node => left) + countLeaf(node => right);
}
/**
 * [이진트리 - 서브 트리들의 높이 중에서 최대값을 구하여 반환]
 * 서브 트리의 높이를 구할 때에는 왼쪽 서브 트리와 오른쪽 서브 트리를 따로 순환 재귀 호출로 높이를 구해야 합니다.
 * 단말 노드까지 내려왔을 때 반환 값을 왼쪽과 오른쪽을 비교해서 큰 쪽이 반환되게 설정하는데
 * 여기서 +1을 각각 시켜준 이유는 자기 자신의 높이를 더해서 반환해줘야 하기 때문입니다.
 */
function calcHeight(node) {
    let hLeft=0;
    let hRight=0;
    if(node === null) return 0;
    hLeft = calcHeight(n => left);
    hRight = calcHeight(n => right);
    return (hLeft > hRight) ? hLeft+1 : hRight+1;
}