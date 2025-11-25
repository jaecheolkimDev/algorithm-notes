package baekjoon.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class 문제_11399 {
    // [2024-02-26 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, k, lastCnt;
    static List<Integer> list2 = new LinkedList<>();
    static List<Integer> list3 = new LinkedList<>();
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
        n = Integer.parseInt(s1);    // 1~1억
        String[] s2 = br.readLine().split(" "); // 1~10억
        for(int i=1; i<=n; i++) {
            list2.add(Integer.parseInt(s2[i-1]));
        }
    }

    public static void when() {
        Collections.sort(list2);
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += list2.get(i)*(n-i);
        }
        sb.append(sum);
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}
