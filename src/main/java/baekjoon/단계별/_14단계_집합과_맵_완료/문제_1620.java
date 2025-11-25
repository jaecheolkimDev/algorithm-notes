package baekjoon.단계별._14단계_집합과_맵_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class 문제_1620 {
    // [2024-03-13 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, m, k, lastCnt;
    static List<String> list1 = new ArrayList<>();
    static List<String> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
    static List<Integer> sorted = new LinkedList<>();
    static Map<String, Integer> map1 = new HashMap<>();
    static Map<Integer, String> map2 = new HashMap<>();
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
        m = Integer.parseInt(s1[1]);
        for(int i=1; i<=n; i++) {
            String s2 = br.readLine();
            map1.put(s2, i);
            map2.put(i, s2);
        }
        for(int i=1; i<=m; i++) {
            String s3 = br.readLine();
            list2.add(s3);
        }
    }

    public static void when() {
        for(int i=0; i<m; i++) {
            // 숫자형식이면
            if(list2.get(i).chars().allMatch(Character::isDigit)) {
                sb.append(map2.get(Integer.parseInt(list2.get(i)))).append("\n");
            } else {
                sb.append(map1.get(list2.get(i))).append("\n");
            }
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}