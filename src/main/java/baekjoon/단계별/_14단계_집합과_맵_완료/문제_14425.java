package baekjoon.단계별._14단계_집합과_맵_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class 문제_14425 {
    // [2024-03-13 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, m, k, lastCnt;
    static List<String> list1 = new ArrayList<>();
    static List<String> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
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
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        m = Integer.parseInt(s1[1]);
        for(int i=1; i<=n; i++) {
            String s2 = br.readLine();
            list1.add(s2);
        }
        for(int i=1; i<=m; i++) {
            String s3 = br.readLine();
            list2.add(s3);
        }
    }

    public static void when() {
        Map<String, Integer> wordMap = new HashMap<>();
        for(int i=0; i<n; i++) {
            wordMap.put(list1.get(i), 1);
        }
        int sum = 0;
        for(int i=0; i<m; i++) {
            sum += wordMap.getOrDefault(list2.get(i), 0);
        }
        sb.append(sum);
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}