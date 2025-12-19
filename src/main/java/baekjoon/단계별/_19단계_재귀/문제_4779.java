package baekjoon.단계별._19단계_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 문제_4779 {
    // [2025-12-17 JC]
    static int result = 0;
    static int tot = 0;
    static int m;
    static int[] n = new int[31] , nStudent = new int[31] , k = new int[101] , nBasket = new int[101];
    public static void main(String[] args) throws IOException {
        given();// 테스트 실행을 준비하는 단계
        when(); // 테스트를 진행하는 단계
        then(); // 테스트 결과를 검증하는 단계
    }

    public static void given() throws IOException {
        InputStream is = System.in;						// 바이트
        InputStreamReader isr = new InputStreamReader(is);// 캐릭터
        BufferedReader br = new BufferedReader(isr);    // 스트링
        for(int i=0; i<28; i++) {
            n[i+1] = Integer.parseInt(br.readLine());
        }
        br.
        for(int i=0; i<30; i++) {
            nStudent[i+1] = i+1;
        }
    }
    public static void when() {
        for(int i=0; i<28; i++) {
            nStudent[n[i+1]] = 0;
        }
    }
    public static void then() {
        for(int i=0; i<30; i++) {
            if(nStudent[i+1] != 0) {
                System.out.println(nStudent[i+1]);
            }
        }
    }
}
