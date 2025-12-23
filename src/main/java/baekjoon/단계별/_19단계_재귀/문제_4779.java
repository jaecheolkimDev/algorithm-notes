package baekjoon.단계별._19단계_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 문제_4779 {
    static StringBuffer sb = new StringBuffer();
    // [2025-12-22 JC]
    static int result = 0;
    static int tot = 0;
    static int t,m;
    static String line;
    static int[] i = new int[101] , j = new int[101] , nBasketTmp = new int[101] , nBasket = new int[101];
    static String[] tResult = new String[11];
    static List<String> testList = new ArrayList<>(), testResultList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        given();// 테스트 실행을 준비하는 단계
        when(); // 테스트를 진행하는 단계
        then(); // 테스트 결과를 검증하는 단계
    }

    public static void given() throws IOException {
        InputStream is = System.in;						// 바이트
        InputStreamReader isr = new InputStreamReader(is);// 캐릭터
        BufferedReader br = new BufferedReader(isr);    // 스트링
//        System.out.println("br.readLine() : " + br.readLine());
        // 입력은 파일의 끝에서 멈춘다.
        while((line = br.readLine()) != null && !line.isEmpty()) {
            testList.add(line);
        }
    }
    public static void when() {
        System.out.println(Arrays.asList(testList));
        for(int i=0; i<testList.size(); i++) {
//            sb.append(testList.get(i)).append("\n");
        }
    }
    public static void then() {
        System.out.print(sb.toString());
    }

    public static String cantor(int num) {
        /**
         * 3의 N승 , 문자열을 3등분한뒤, 가운데 문자열을 공백으로 바꾼다.
         * 0 | 1
         * 1 | 3
         * 2 | 9
         * 3 | 27
         */
        if(num == 0) return "-";

        for(int i=0; i<(int)Math.pow(3, num); i++) {
            // 1번째 구간
            if(i < num/3) {

            }
            // 2번째 구간
            if(num/3 <= i || i < num - num/3) {

            }
            // 3번째 구간
            if(num - num/3 <= i) {

            }
        }


    }
}
