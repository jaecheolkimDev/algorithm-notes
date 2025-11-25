/**
 * DFS : 한 우물만 판다.
 * BFS : 같은 레벨에 있는 정점들은 같이 탐색.
문제
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 
더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

입력
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 
다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 
입력으로 주어지는 간선은 양방향이다.

출력
첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
 */
// const input = require('fs').readFileSync('dev/stdin').toString().split('\n');
// const input = ["4 5 1", "1 2", "1 3", "1 4", "2 4", "3 4", "\n"];
const input = ["5 5 3", "5 4", "5 2", "1 2", "3 4", "3 1", "\n"];
// const input = ["1000 1 1000", "999 1000", "\n"];
const command = input[0].split(' ').map(Number);
console.log(" split : ", input[0].split(' '));
console.log(" split.map : ", input[0].split(' ').map(Number));

const nVertex = command[0];   // 정점의 개수
const nEdge = command[1];     // 간선의 개수
const startPoint = command[2];// 탐색을 시작할 정점의 번호

const graph = []; // 정점과 간선 연결 그래프.
const check = []; // 방문여부.

for(let i = 0; i <= nVertex; i++) graph[i] = [];     // 점점과 간선연결 그래프 초기화.
for(let i = 0; i <= nVertex; i++) check[i] = false;  // 방문여부 초기화.
console.log("DFS 초기화된 방문여부 : " , check);

for(let i = 1; i <= nEdge; i++) {   // 1 ~ 간선의 갯수 만큼
    let l = input[i].split(' ').map(Number);
    graph[l[0]][l[1]] = graph[l[1]][l[0]] = 1;
    /**
     * [1,2][1,3][1,4]와 연결된 정점에 체크.
     * [
     *  , []
     *  , [0,0,1,1,1] 정점 1 이 어느 정점과 연결되어있는지를 그래프로 표현[2차원 배열]
     *  , [0,1,0,0,1] 정점 2
     *  , [0,1,0,0,1] 정점 3
     *  , [0,1,1,1,0] 정점 4
     * ]
     */
}

/** DFS 시작 */
let DFSresult = '';

const DFS = (index) => {
    check[index] = true;
    DFSresult += index + ' ';
    for(let i = 0; i <= nVertex; i++) {
        if(check[i] === false && graph[index][i] === 1) {
            DFS(i);
        }
    }
};

DFS(startPoint);
console.log(DFSresult.trim());
/** DFS 끝 */
console.log("↑ DFS ↑\n↓ BFS ↓");
/** BFS 시작 */
for(let i = 0; i <= nVertex; i++) check[i] = false;  // 방문여부 초기화
console.log("BFS 초기화된 방문여부 : " , check);

let BFSresult = '';
const q = [];
q.push(startPoint);         // 1-1. 시작점을 QUE에 넣고
check[startPoint] = true;   // 1-2. 방문했다는 표시를 남김.
while(q.length !== 0) {
    console.log("q : " , q);
    let item = q.shift();   // 2. QUE에서 원소를 꺼내서
    BFSresult += item + ' ';
    for(let i = 0; i <= nVertex; i++) {
        if(check[i] === false && graph[item][i] === 1) {
            q.push(i);
            check[i] = true;
        }
    }
}
console.log("BFS 작업한 방문여부 : " , check);

console.log(BFSresult.trim());
/** BFS 끝 */