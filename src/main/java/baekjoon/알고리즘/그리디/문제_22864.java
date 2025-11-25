package baekjoon.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 문제_22864 {
    // [2024-02-25 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, k, m, a, b, c, d;
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
        String[] s1 = br.readLine().split(" ");
        a = Integer.parseInt(s1[0]);
        b = Integer.parseInt(s1[1]);
        c = Integer.parseInt(s1[2]);
        m = Integer.parseInt(s1[3]);
    }
    public static void when() {
        int sum = 0;
        int currentFatigue = 0; // 현재 피로도
        int currentWork = 0; // 현재 일
        for(int i=0; i<24; i++) {
            if(currentFatigue + a > m) {
                currentFatigue -= c;    // 회복
                if(currentFatigue < 0) currentFatigue = 0;  // 음수일때 0처리
            } else {
                currentFatigue += a;
                currentWork  += b;
            }
        }

        sb.append(currentWork);
    }

    public static void then() {
        System.out.println(sb.toString());
    }

}