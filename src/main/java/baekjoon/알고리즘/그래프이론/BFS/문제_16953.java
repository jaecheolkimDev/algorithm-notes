package baekjoon.알고리즘.그래프이론.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class 문제_16953 {
    // [2024-03-22 JC : 그리디로 풀면 쉽게 풀 수 있지만, BFS 연습중이기도하고, 그리디로 못푸는 케이스가 나올 수도 있으니, BFS방법을 써봄.]
    static StringBuffer sb = new StringBuffer();
    static long n, m, k, cnt, A, B;
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
        A = Long.parseLong(s1[0]);
        B = Long.parseLong(s1[1]);
    }

    public static void when() {
        bfs();
        if(sb.isEmpty()) {
            sb.append(cnt);
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }

    public static void bfs() {
        Queue<Long> q = new LinkedList<>();
        q.offer(A);
        while(!q.isEmpty()) {
            cnt++;
            int size = q.size();
            for(int i=0; i<size; i++) {
                long num = q.poll();
                if(num > B) continue;
                if (num == B) return;
                q.offer(num * 2);
                q.offer(num * 10 + 1);
            }
        }
        sb.append(-1);
    }
}