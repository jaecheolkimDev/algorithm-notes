package baekjoon.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 문제_1449 {
    // [2024-03-03 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, m, l;
    static List<Integer> list1 = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
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
        n = Integer.parseInt(s1[0]);
        l = Integer.parseInt(s1[1]);
        String[] s2 = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            list1.add(Integer.parseInt(s2[i]));
        }
    }
    public static void when() {
        Collections.sort(list1);
//        System.out.println(list1);

        int prev = list1.get(0) + (l-1);
        int cnt = 1;
        for(int i=0; i<n; i++) {
            if(list1.get(i) > prev) {
                prev = list1.get(i) + (l-1);
                cnt++;
            }
        }

        sb.append(cnt);
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}
