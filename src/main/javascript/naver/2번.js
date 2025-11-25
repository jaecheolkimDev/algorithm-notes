/**
 * 2차원 테이블
 * 각 행은 단일 책 대출에 대한 정보를 포함하는 세 개의 셀
 * - 고객의 이름
 * - 책을 빌린 날짜
 * - 책이 반환 된 날짜(비어있을수도 있고, 책이 반환 안된것.)
 * 
 * 기한이 지난 대출이 포함 된 행의 배경색은 빨간색
 */

    let table = [{
        name: '애디슨',
        day: '2014-08-14',
        returnDay: '2014-10-09'
    },{
        name: 'Val',
        day: '2014-08-14',
        returnDay: '2014-10-09'
    },{
        name: 'Patrick',
        day: '2015-11-23',
        returnDay: ''
    }];
    let cnt = 0;
    for(let i=0; i<table.length; i++) {
        if(table[i].returnDay === '' || table[i].returnDay === undefined || table[i].day > table[i].returnDay) {
            console.log(`${table[i].name} ${table[i].day} ${table[i].returnDay} ::::::::: style="background-color:red"`);
            cnt++;
        } else {
            console.log(`${table[i].name} ${table[i].day} ${table[i].returnDay}`);
        }
    }
    console.log("cnt : ", cnt);