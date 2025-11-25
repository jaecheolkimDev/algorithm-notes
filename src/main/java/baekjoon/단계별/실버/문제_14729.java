package baekjoon.단계별.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class 문제_14729 {
    // [2024-02-24 JC]
    static StringBuffer sb = new StringBuffer();
    static int t, n, m, k, lastCnt;
    static List<String> list1 = new ArrayList<>();
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
            list1.add(s2);
        }
    }

    public static void when() {
        PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<n; i++) {
            pq.offer(list1.get(i));
            if(pq.size() > 7) {
                pq.remove();
            }
        }

        for(int i=0; i<7; i++) {
            sb.insert(0, "\n").insert(0, pq.poll());
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}