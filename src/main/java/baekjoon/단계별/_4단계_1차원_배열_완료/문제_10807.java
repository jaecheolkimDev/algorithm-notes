package baekjoon.단계별._4단계_1차원_배열_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 문제_10807 {
    // [2023-12-09 JC]
    static int result = 0;
    static int tot = 0;
    static int x,n,v;
    static int[] givenNumber = new int[101];
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
        String[] s = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            givenNumber[i+1] = Integer.parseInt(s[i]);
        }
        v = Integer.parseInt(br.readLine());
    }
    public static void when() {
        for(int i=0; i<n; i++) {
            if(v == givenNumber[i+1]) {
                result++;
            }
        }
    }
    public static void then() {
        System.out.println(result);
    }
}
