package baekjoon.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 문제_1439 {
    // [2024-02-29 JC]
    static StringBuffer sb = new StringBuffer();
    static String t, n, m, k, lastCnt, s;
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
        s = s1;
    }

    public static void when() {
        int cnt = 0;
        String comp = "-1";
        if(s.length() > 2) {
            for (int i = 1; i <= s.length(); i++) {
                String str = s.substring(i - 1, i);
                if(!str.equals(comp)) {
                    cnt++;
                    comp = str;
                }
            }
            sb.append(cnt/2);
        } else if(s.length() == 2){
            if(s.substring(0,1).equals(s.substring(1,2))) {
                sb.append(0);
            } else {
                sb.append(1);
            }
        } else {
            sb.append(0);
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}