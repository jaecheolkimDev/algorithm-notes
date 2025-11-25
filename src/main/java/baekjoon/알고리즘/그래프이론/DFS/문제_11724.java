package baekjoon.알고리즘.그래프이론.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 문제_11724 {
    // [2024-03-18 JC]
    static StringBuffer sb = new StringBuffer();
    static int N, M, k;
    static List<String> list1 = new ArrayList<>();
    static List<String> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
    static List<Integer> sorted = new LinkedList<>();
    static boolean[][] arr1 = new boolean[1001][1001];
    static boolean[] visited = new boolean[1001];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
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
        for(int i=1; i<=M; i++) {
            String[] s2 = br.readLine().split(" ");
            arr1[Integer.parseInt(s2[0])][Integer.parseInt(s2[1])] = true;
            arr1[Integer.parseInt(s2[1])][Integer.parseInt(s2[0])] = true;
        }
    }

    public static void when() {
        int cnt = 0;
        for(int i=1; i<=N; i++) {
             if (visited[i]) continue;
             dfs(i);
             cnt++;
        }
        sb.append(cnt);
    }

    public static void then() {
        System.out.println(sb.toString());
    }

    public static void dfs(int x) {
        visited[x] = true;

        for(int i=1; i<=N; i++) {
            if(visited[i]) continue;
            if(arr1[x][i]) dfs(i);
        }
    }

}