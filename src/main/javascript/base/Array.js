/**
 * [JavaScript Array => 자주 사용하는 연산]
 * 1. JavaScript 의 배열 만들기.
 *  JavaScript 에서 배열의 길이와 요소의 자료형은 고정되어 있지 않습니다.
 *  배열의 길이가 언제든지 늘어나거나 줄어들 수 있기 때문에 JavaScript 배열들은 밀집도가 보장되지 않습니다.
 *  보통 이 성질은 편리하지만, 목적에 맞지 않는다면 형식화 배열(typed array)을 사용하는 것을 고려해보세요.
 * 
 * 2. 인덱스로 배열의 항목에 접근하기
 * 3. 배열의 항목들을 순환하며 처리하기
 * 4. 배열 끝에 항목 추가하기
 * 5. 배열 끝에서부터 항목 제거하기
 * 6. 배열 앞에서부터 항목 제거하기
 * 7. 배열 앞에 항목 추가하기
 * 8. 배열 안 항목의 인덱스 찾기
 * 9. 인덱스 위치에 있는 항목 제거하기
 * 10. 인덱스 위치에서부터 여러개의 항목 제거하기
 * 11. 배열 복사하기
 * 12. arr.join(); => 배열의 요소들을 하나의 문자열로 합치기.
 * 13. Array.from()
 * 14. Array.sort()
 */

// 1
let fruits = ['사과', '바나나'];
console.log(fruits.length); // 2

// 2
let first = fruits[0];  // 사과
let last = fruits[fruits.length - 1];   // 바나나

// 3
fruits.forEach(function (item, index, array) {
    console.log(item, index);   // 사과 0 , 바나나 1
});

// 4
let newLength = fruits.push('오렌지');  // ["사과", "바나나", "오렌지"]

// 5
last = fruits.pop(); // 끝에있던 '오렌지'를 제거 => ["사과", "바나나"]

// 6
first = fruits.shift(); // 제일 앞의 '사과'를 제거 => ["바나나"]

// 7
newLength = fruits.unshift('딸기'); // 앞에 추가 => ["딸기", "바나나"]

// 8
fruits.push('망고');    // ["딸기", "바나나", "망고"]
let pos = fruits.indexOf("바나나"); // 1

// 9
let removedItem = fruits.splice(pos, 1); // 항목을 제거하는 방법 => ["딸기", "망고"]

// 10
let vegetables = ['양배추', '순무', '무', '당근'];
console.log(vegetables);    // ["양배추", "순무", "무", "당근"]
let removedItems = vegetables.splice(1, 2);   // 배열에서 항목을 제거하는 방법 => 1 인덱스부터 2개의 항목을 제거함
console.log(vegetables);    // ["양배추", "당근"] (원 배열 vegetables의 값이 변함)
console.log(removedItems);  // ["순무", "무"]

// 11
let shallowCopy = fruits.slice(); // 사본을 만드는 방법 => ["딸기", "망고"]

/**
 * 12. arr.join();
 * 배열의 요소들을 하나의 문자열로 합치기.
 * 구분자가 없으면 자동으로 , 가 붙음.
 */
let str = removedItems.join(''); 

const tableData = [{id: 1, number: 100}, {id: 2, number: 200}];
console.log("tableData ", tableData);

/**
 * 13. Array.from()
 *  유사 배열 객체(array-like object)나 반복 가능한 객체(iterable object)를
 *  얕게 복사해 새로운Array 객체를 만듭니다.
 */
console.log(Array.from('foo'));
// expected output: Array ["f", "o", "o"]

console.log(Array.from([1, 2, 3], x => x + x));
// expected output: Array [2, 4, 6]

/**
 * 14. Array.sort()
 *  배열의 요소를 적절한 위치에 정렬한 후 그 배열을 반환합니다.
 *  정렬은 stable sort가 아닐 수 있습니다. 기본 정렬 순서는 문자열의 유니코드 코드 포인트를 따릅니다.
 * - 정렬한 배열. 원 배열이 정렬되는 것에 유의하세요. 복사본이 만들어지는 것이 아닙니다.
 */
const months = ['March', 'Jan', 'Feb', 'Dec'];
months.sort();
console.log(months);
// expected output: Array ["Dec", "Feb", "Jan", "March"]

const array1 = [1, 30, 4, 21, 100000];
array1.sort();
console.log(array1);
// expected output: Array [1, 100000, 21, 30, 4]

const input = ["1 3 5 7"];
const number = input[0].split(' '); /** 띄어쓰기를 제외하고 구분해서 배열을 만듬. */

console.log('숫자정렬 내림차순 : ', number.sort((a, b) => (b - a)));
console.log('숫자정렬 오름차순 : ', number.sort((a, b) => (a - b)));
console.log('문자정렬 : ', months.sort((a, b) => ((a>b) - (a<b))));