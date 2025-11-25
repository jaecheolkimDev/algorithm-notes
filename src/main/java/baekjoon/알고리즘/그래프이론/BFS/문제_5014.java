package baekjoon.알고리즘.그래프이론.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class 문제_5014 {
    // [2024-03-22 JC : 무식하게 풀면 쉽게 풀 수 있지만, BFS 연습중이기도하고, 그리디로 못푸는 케이스가 나올 수도 있으니, BFS방법을 써봄.]
    static StringBuffer sb = new StringBuffer();
    static int F, S, G, U, D, cnt;
    static List<String> list1 = new ArrayList<>();
    static List<String> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
    static List<Integer> sorted = new LinkedList<>();
    static Map<String, Integer> map1 = new HashMap<>();
    static Map<Integer, String> map2 = new HashMap<>();
    static Set<Integer> set1 = new HashSet<>();
    static Set<Integer> set2 = new HashSet<>();
    static boolean[] visited;
    static int[] direction;
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
        F = Integer.parseInt(s1[0]);
        S = Integer.parseInt(s1[1]);
        G = Integer.parseInt(s1[2]);
        U = Integer.parseInt(s1[3]);
        D = Integer.parseInt(s1[4]);

        visited = new boolean[F+1];
        direction = new int[]{U, -D};
    }

    public static void when() {
        bfs();
        if(sb.isEmpty()) {
            sb.append(cnt-1);
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);	// 현재의 층.
        visited[S] = true;	// [2024-03-24 JC : 메모리초과가 안나려면 BFS에서는 방문처리를 꼭 해야 한다.]
        while (!q.isEmpty()) {
            cnt++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int num = q.poll();
                if (num == G) return;
                if(num + U <= F && !visited[num + U]) {
                    visited[num + U] = true;
                    q.offer(num + U);
                }
                if(num - D >= 1 && !visited[num - D]) {
                    visited[num - D] = true;
                    q.offer(num - D);
                }
            }
        }
        sb.append("use the stairs");
    }
}