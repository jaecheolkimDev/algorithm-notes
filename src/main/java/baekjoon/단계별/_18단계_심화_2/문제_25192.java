package baekjoon.단계별._18단계_심화_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class 문제_25192 {
    // [2025-12-03 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, m;
    static Map<String, String> map1 = new HashMap<>();
    static List<Integer> list1 = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();
    static Set<Integer> set1 = new HashSet<>();
    static String[] arr1;
    static int[] arr2;
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
        arr1 = new String[n];
        for(int i=0; i<n; i++) {
            String s2 = br.readLine();
            arr1[i] = s2;
        }
    }
    public static void when() {
        Set<String> set = new HashSet<>();
        int cnt = 0;
        int sum = 0;
        for(int i=0; i<arr1.length; i++) {
            if("ENTER".equals(arr1[i])) {
                sum += cnt;
                cnt = 0;
                set = new HashSet<>();
                continue;
            }
            if(set.contains(arr1[i])) {
                continue;
            }
            set.add(arr1[i]);
            cnt ++;
        }
        sum += cnt;
        sb.append(sum);
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}