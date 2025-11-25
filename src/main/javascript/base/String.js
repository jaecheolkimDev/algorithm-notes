let browserType = 'mozilla';

console.log("browserType.indexOf('mozilla') : ", browserType.indexOf('mozilla'));
if(browserType.indexOf('mozilla') !== -1) {
    // do stuff with the string
console.log("Sfdsdf");
  }

/**
 * split()
 * - String 객체를 지정한 구분자를 이용하여 여러 개의 문자열로 나눠서 배열로 만듦.
 *   구분자가 없으면 나눠지지 않는다.
 */
const str = 'The quick brown fox jumps over the lazy dog.';

const words = str.split(' ');
console.log(words[3]);
// expected output: "fox"

const chars = str.split('');
console.log(chars);
console.log(chars[8]);
// expected output: "k"

const strCopy = str.split();
console.log(strCopy);
// expected output: Array ["The quick brown fox jumps over the lazy dog."]

const croatia = "cz=";
console.log("slice(2) : ", croatia.slice(2) );
// slice(2) => 0,1번째 idx를 제외한 2번째 idx부터 문자열을 추출한다.