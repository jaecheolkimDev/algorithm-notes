package baekjoon.단계별._3단계_반복문_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 문제_25314 {
    // [2023-12-09 JC]
    static String result = "";
    static int n;
    static int[] a = new int[101], b = new int[101];
    public static void main(String[] args) throws IOException {
        given();// 테스트 실행을 준비하는 단계
        when(); // 테스트를 진행하는 단계
        then(); // 테스트 결과를 검증하는 단계
    }

    public static void given() throws IOException {
        InputStream is = System.in;						// 바이트
        InputStreamReader isr = new InputStreamReader(is);// 캐릭터
        BufferedReader br = new BufferedReader(isr);    // 스트링
        n = Integer.parseInt(br.readLine());
    }
    public static void when() {
        int longCnt = n/4;
        for(int i=0; i<longCnt; i++) {
            result = result.concat("long ");
        }
        result = result.concat("int");
    }
    public static void then() {
        System.out.println(result);
    }
}
