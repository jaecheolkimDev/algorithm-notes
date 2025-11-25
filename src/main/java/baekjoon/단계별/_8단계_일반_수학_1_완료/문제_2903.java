package baekjoon.단계별._8단계_일반_수학_1_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 문제_2903 {
    // [2024-03-10 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, m;
    static int[][] array;
    static List<Integer> list2 = new ArrayList<>();
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
    }
    public static void when() {
        int res = 2;
        for(int i=1; i<=n; i++) {
            res += Math.pow(2, i-1);
        }

        sb.append((int)Math.pow(res, 2));
    }

    public static void then() {
        System.out.println(sb.toString());
    }

}