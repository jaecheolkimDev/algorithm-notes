package baekjoon.알고리즘.그래프이론.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 문제_1325 {
    // [2024-03-24 JC]
    static StringBuffer sb = new StringBuffer();
    static int N, M;
    static List<String> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
    static List<Integer> sorted = new LinkedList<>();
    static boolean[] visited;
    static int[] arrConnectedCnt;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static List<Integer>[] linkedList;
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
        visited = new boolean[N+1];
        arrConnectedCnt = new int[N+1];
        linkedList = new LinkedList[N+1];
        for(int i=1; i<=N; i++) {
            linkedList[i] = new LinkedList<>();
        }
        for(int i=0; i<M; i++) {
            String[] s2 = br.readLine().split(" ");
            int a = Integer.parseInt(s2[0]);
            int b = Integer.parseInt(s2[1]);
            linkedList[a].add(b);
        }
    }

    public static void when() {
        for(int i=1; i<=N; i++) {
            visited = new boolean[N+1];   // [2024-03-24 JC : 매번 방문을 초기화한다. => 매번 방문 초기화를 생각을 못했음.]
            dfs(i);
        }

        int max = Arrays.stream(arrConnectedCnt).max().getAsInt();

        for(int i=1; i<=N; i++) {
            if(max == arrConnectedCnt[i]) sb.append(i).append(" ");
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }

    public static void dfs(int x) {
        visited[x] = true;

        for(int num : linkedList[x]) {
            if(visited[num]) continue;
            arrConnectedCnt[num]++;
            dfs(num);
        }
    }
}