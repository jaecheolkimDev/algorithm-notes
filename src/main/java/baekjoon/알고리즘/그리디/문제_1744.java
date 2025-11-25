package baekjoon.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class 문제_1744 {
    // [2024-03-06 JC]
    static StringBuffer sb = new StringBuffer();
    static int t, n, m, k, lastCnt;
    static List<Integer> list1 = new ArrayList<>();
    static int[] array1;
    static List<Integer> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
    static List<Integer> list4 = new ArrayList<>();
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
        PriorityQueue<Integer> pqUnder = new PriorityQueue<>();
        PriorityQueue<Integer> pqOver = new PriorityQueue<>(Collections.reverseOrder());
        int size = list1.size();
        for(int i=0; i<size; i++) {
            int num = list1.get(i);
            if(num <= 0) {
                pqUnder.offer(num);
            } else {
                pqOver.offer(num);
            }
        }
        int sum = getSum(pqUnder) + getSum(pqOver);

        sb.append(sum);
    }

    public static void then() {
        System.out.println(sb.toString());
    }

    public static int getSum(PriorityQueue<Integer> pq) {
        Queue<Integer> q = new LinkedList<>();
        while(!pq.isEmpty()) {
            int curr = pq.poll();
            if(pq.isEmpty()) q.add(curr);
            else {
                int next = pq.poll();
                if(curr == 1 || next == 1) {
                    q.add(curr);
                    q.add(next);
                } else q.add(curr*next);
            }
        }
        int res = 0;
        while (!q.isEmpty()) {
            res += q.poll();
        }
        return res;
    }
}