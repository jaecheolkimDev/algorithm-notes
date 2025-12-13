package baekjoon.단계별._18단계_심화_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class 문제_26069 {
    // [2025-12-03 JC]
    static StringBuffer sb = new StringBuffer();
    static int N, M, K, X;
    static List<Integer> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
    static boolean[] visited;
    static int[] dist;
    static String[][] name;

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
        N = Integer.parseInt(s1);
        name = new String[N][2];
        for(int i=0; i<N; i++) {
            String[] s2 = br.readLine().split(" ");
            name[i][0] = s2[0];
            name[i][1] = s2[1];
        }
    }
    public static void when() {
        Set<String> set = new HashSet<>();
        set.add("ChongChong");
        for(int i=0; i<N; i++) {
            if(set.contains(name[i][0]) || set.contains(name[i][1])) {
                set.add(name[i][0]);
                set.add(name[i][1]);
            }
        }
        sb.append(set.size());
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}