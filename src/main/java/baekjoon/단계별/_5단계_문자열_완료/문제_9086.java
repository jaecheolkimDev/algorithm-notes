package baekjoon.단계별._5단계_문자열_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 문제_9086 {
    // [2023-12-10 JC]
    static int result = 0;
    static int tot = 0;
    static int t,m;
    static int[] i = new int[101] , j = new int[101] , nBasketTmp = new int[101] , nBasket = new int[101];
    static String[] tString = new String[11] , tResult = new String[11];
    public static void main(String[] args) throws IOException {
        given();// 테스트 실행을 준비하는 단계
        when(); // 테스트를 진행하는 단계
        then(); // 테스트 결과를 검증하는 단계
    }

    public static void given() throws IOException {
        InputStream is = System.in;						// 바이트
        InputStreamReader isr = new InputStreamReader(is);// 캐릭터
        BufferedReader br = new BufferedReader(isr);    // 스트링
        t = Integer.parseInt(br.readLine()); // 바구니의 총 갯수
        for(int i=0; i<t; i++) {
            tString[i+1] = br.readLine();
        }
    }
    public static void when() {
        for(int i=0; i<t; i++) {
            tResult[i+1] = tString[i+1].substring(0, 1) + tString[i+1].substring(tString[i+1].length()-1, tString[i+1].length());
        }
    }
    public static void then() {
        for(int i=0; i<t; i++) {
            System.out.println(tResult[i+1]);
        }
    }
}
