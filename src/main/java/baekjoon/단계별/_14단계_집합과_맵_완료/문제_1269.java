package baekjoon.단계별._14단계_집합과_맵_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class 문제_1269 {
    // [2024-03-13 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, m, k, lastCnt, a, b;
    static List<String> list1 = new ArrayList<>();
    static List<String> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
    static List<Integer> sorted = new LinkedList<>();
    static Map<String, Integer> map1 = new HashMap<>();
    static Map<Integer, String> map2 = new HashMap<>();
    static Set<Integer> set1 = new HashSet<>();
    static Set<Integer> set2 = new HashSet<>();
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
        String[] s2 = br.readLine().split(" ");
        for(int i=0; i<a; i++) {
            set1.add(Integer.parseInt(s2[i]));
        }
        String[] s3 = br.readLine().split(" ");
        for(int i=0; i<b; i++) {
            set2.add(Integer.parseInt(s3[i]));
        }
    }

    public static void when() {
        Set<Integer> set3 = new HashSet<>(set1);
        Set<Integer> set4 = new HashSet<>(set2);
        set3.removeAll(set4);
        int num1 = set3.size();

        set3 = new HashSet<>(set1);
        set4 = new HashSet<>(set2);
        set4.removeAll(set3);
        int num2 = set4.size();

//        System.out.println(set1);
//        System.out.println(set2);
//        System.out.println(set3);
//        System.out.println(set4);

        sb.append(num1 + num2);
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}