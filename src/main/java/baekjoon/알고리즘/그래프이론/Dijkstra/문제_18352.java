package baekjoon.알고리즘.그래프이론.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 문제_18352 {
    // [2024-03-23 JC]
    static StringBuffer sb = new StringBuffer();
    static int N, M, K, X;
    static List<CustomArray13>[] list1;
    static List<Integer> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
    static boolean[] visited;
    static int[] dist;

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
        N = Integer.parseInt(s1[0]);
        M = Integer.parseInt(s1[1]);
        K = Integer.parseInt(s1[2]);
        X = Integer.parseInt(s1[3]);
        visited = new boolean[N+1];
        dist = new int[N+1];
        list1 = new ArrayList[N+1];
        for(int i=0; i<=N; i++) list1[i] = new ArrayList<>();
        for(int i=0; i<M; i++) {
            String[] s2 = br.readLine().split(" ");
            int x = Integer.parseInt(s2[0]);
            int y = Integer.parseInt(s2[1]);
            list1[x].add(new CustomArray13(y, 1));
        }
    }
    public static void when() {
        dijkstra();

        for(int i=1; i<=N; i++) {
            if(K == dist[i]) {
                sb.append(i).append("\n");
            }
        }
        if(sb.isEmpty()) {
            sb.append(-1);
        }
//        System.out.println("dist : " + Arrays.toString(dist));

    }

    public static void then() {
        System.out.println(sb.toString());
    }

    public static void dijkstra() {
        // 전체값 초기화
        Arrays.fill(dist, 10_000_000);

        // 시작값 초기화
        dist[X] = 0;

        // 미사용값 초기화
        dist[0] = 0;

        PriorityQueue<CustomArray13> pq = new PriorityQueue<>();
        pq.offer(new CustomArray13(X, dist[X]));
        while(!pq.isEmpty()) {
            CustomArray13 now = pq.poll();
            int nowIndex = now.getIndex();

            if(visited[nowIndex]) continue; // 방문했던 노드는 재방문하지 않는다.
            visited[nowIndex] = true;

            for(CustomArray13 next : list1[nowIndex]) {
                int nextIndex = next.getIndex();
                int nextDistance = next.getDistance();

                if(visited[nextIndex]) continue;

                if(dist[nextIndex] > dist[nowIndex] + nextDistance) { // 도착점
                    dist[nextIndex] = dist[nowIndex] + nextDistance;
                    pq.offer(new CustomArray13(nextIndex, dist[nextIndex]));
                }
            }
        }
    }
}

class CustomArray13 implements Comparable<CustomArray13> {
    private int index;
    private int distance;

    @Override
    public int compareTo(CustomArray13 o) {
        // [2024-03-23 JC : 거리가 짧을수록 우선순위가 높다.]
        if(this.distance < o.distance) {
            return -1;
        } else if(this.distance > o.distance) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "CustomArray13{" +
                "index=" + index +
                ", distance=" + distance +
                '}';
    }

    public CustomArray13(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}