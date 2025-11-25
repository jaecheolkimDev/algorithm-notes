package baekjoon.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 문제_2810 {
    // [2024-03-09 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, k;
    static String s;
    public static void main(String[] args) throws IOException {
        given();// 테스트 실행을 준비하는 단계
        when(); // 테스트를 진행하는 단계
        then(); // 테스트 결과를 검증하는 단계
    }

    public static void given() throws IOException {
        InputStream is = System.in;						// 바이트
        InputStreamReader isr = new InputStreamReader(is);// 캐릭터
        BufferedReader br = new BufferedReader(isr);    // 스트링
        String s1 = br.readLine();
        n = Integer.parseInt(s1);
        String s2 = br.readLine();
        s = s2;
    }

    public static void when() {
        int cnt =0;
        while(!s.equals(s.replace("LL", "S"))) {
            s = s.replace("LL", "S");
            cnt++;
        }
        if(cnt == 0) {
            sb.append(n);
        } else {
            sb.append(s.length()+1);
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}