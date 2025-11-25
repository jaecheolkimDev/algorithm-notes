package baekjoon.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class 문제_10610 {
    // [2024-02-29 JC]
    static StringBuffer sb = new StringBuffer();
    static String t, n, m, k, lastCnt;
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
        n = s1;
    }

    public static void when() {
        if(n.length() >= 2) {
            for (int i = 1; i <= n.length(); i++) {
                list1.add(Integer.parseInt(n.substring(i - 1, i)));
            }
        } else {
            list1.add(Integer.parseInt(n));
        }

        Collections.sort(list1);
//        System.out.println(list1);

        int size = list1.size();
        int sum = 0;
        for(int i=0; i<size; i++) {
            sum += list1.get(i);
        }

        if(list1.get(0) == 0) {
            if(sum%3 == 0) {
                for(int i=size; i>0; i--) {
                    sb.append(list1.get(i-1));
                }
            }
        }

        if(sb.isEmpty()) {
            sb.append("-1");
        }

    }

    public static void then() {
        System.out.println(sb.toString());
    }
}