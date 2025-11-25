package baekjoon.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class 문제_2217 {
    // [2024-02-27 JC]
    static StringBuffer sb = new StringBuffer();
    static int t, n, m, k, lastCnt;
    static List<Integer> list1 = new ArrayList<>();
    static int[] array1;
    static List<String> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
    static int[] array3;
    static List<Integer> sorted = new LinkedList<>();
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
        n = Integer.parseInt(s1);    // 5~500,000
        for(int i=1; i<=n; i++) {
            String s2 = br.readLine();
            list1.add(Integer.parseInt(s2));
        }
    }

    public static void when() {
        Collections.sort(list1);
//        System.out.println("list1 : " + list1);

        long ans = 0;
        long max = Long.MIN_VALUE;
        for(int i=0; i<n; i++) {
            ans = (n-i) * list1.get(i);
            if(max < ans) {
                max = ans;
            }
        }

        sb.append(max);
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}