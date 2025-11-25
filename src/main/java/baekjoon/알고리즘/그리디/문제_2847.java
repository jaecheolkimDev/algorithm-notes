package baekjoon.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 문제_2847 {
    // [2024-03-05 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, m;
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
        for(int i=0; i<n; i++) {
            String s2 = br.readLine();
            list2.add(Integer.parseInt(s2));
        }
    }
    public static void when() {
        int sum = 0;
        int prev = list2.get(n-1);
        for(int i=n-2; i>=0; i--) {
            if(prev <= list2.get(i)) {
                sum += list2.get(i) - prev + 1;
                prev = list2.get(i) - (list2.get(i) - prev + 1);
            } else {
                prev = list2.get(i);
            }
        }

        sb.append(sum);
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}