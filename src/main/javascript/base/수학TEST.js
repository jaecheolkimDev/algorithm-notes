

console.log("3**16 : ", 3**16);
console.log("1%17 : ", 1%17);

// mod 나머지 연산....
for(let i=16; i<1000000; i++) {
    if(5**i%36 === 17) {
        console.log("i : ", i); //3, 9, 15, 21..........
        break;
    }
}