
const num = 131;
console.log("num.length : " , num.length);

console.log("num : ", (num%10));    // 1의자리
console.log("num : ", Math.floor((num%100)/10));    // 10의자리
console.log("num : ", Math.floor((num%1000)/100));  // 100의자리
console.log("num : ", Math.floor(num/100));  // 100의자리


/** 자릿수 간편하게 구하기. */
for(let i=0; i<String(num).length; i++) {
    console.log("Number(String(num)[i]) : " , String(num)[i]);
}