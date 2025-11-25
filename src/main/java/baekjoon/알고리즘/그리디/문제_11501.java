package baekjoon.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class 문제_11501 {
    // [2024-03-07 JC]
    static StringBuffer sb = new StringBuffer();
    static int t, n, m, k, lastCnt;
    static List<Integer> list1 = new ArrayList<>();
    static int[] array1;
    static List<Integer> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
    static Map<Integer, List<Integer>> map1= new HashMap<>();
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
        t = Integer.parseInt(s1);    // 5~500,000
        for(int i=0; i<t; i++) {
            String s2 = br.readLine();
            list1.add(Integer.parseInt(s2));
            list2 = new ArrayList<>();
            String[] s3 = br.readLine().split(" ");
            for(int j=0; j<list1.get(i); j++) {
                list2.add(Integer.parseInt(s3[j]));
            }
            map1.put(i, list2);
        }
    }

    public static void when() {
        for(int z=0; z<t; z++) {
            list3 = map1.get(z);
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            long sum = 0;
            pq.offer(list3.get(list1.get(z)-1));
            for(int i=list1.get(z)-2; i>=0; i--) {
                if(pq.peek() > list3.get(i)) {
                    sum += (pq.peek() - list3.get(i));
                } else if(pq.peek() < list3.get(i)) {
                    pq.poll();
                    pq.offer(list3.get(i));
                }
            }
            sb.append(sum).append("\n");
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}