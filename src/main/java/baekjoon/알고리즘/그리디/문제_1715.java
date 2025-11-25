package baekjoon.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class 문제_1715 {
    // [2024-02-29 JC]
    static StringBuffer sb = new StringBuffer();
    static int t, n, m, k, lastCnt;
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
        n = Integer.parseInt(s1);    // 5~500,000
        for(int i=1; i<=n; i++) {
            String s2 = br.readLine();
            list1.add(Integer.parseInt(s2));
        }
    }

    public static void when() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++) {
            pq.offer(list1.get(i));
        }

        int sum = 0;
        if(n == 1) {
            sum = 0;
        } else if(n == 2) {
            sum = list1.get(0) + list1.get(1);
        } else {
            while (!pq.isEmpty()) {
                int subSum = pq.poll() + pq.poll();
                sum += subSum;
                pq.offer(subSum);
                if (pq.size() == 2) {
                    sum += (pq.poll() + pq.poll());
                }
            }
        }
        sb.append(sum);
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}