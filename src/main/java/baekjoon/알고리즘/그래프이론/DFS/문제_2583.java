package baekjoon.알고리즘.그래프이론.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class 문제_2583 {
    // [2024-03-20 JC]
    static StringBuffer sb = new StringBuffer();
    static int N, M, K, cnt;
    static List<int[][]> list1 = new ArrayList<>();
    static List<String> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
    static List<Integer> sorted = new LinkedList<>();
    static boolean[][] visited;
    static boolean[][] arr2;
    static int[] x1, y1, x2, y2;
    static List<List<Integer>> linkedList = new LinkedList<>();
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
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
        M = Integer.parseInt(s1[0]);
        N = Integer.parseInt(s1[1]);
        K = Integer.parseInt(s1[2]);

        arr2 = new boolean[M][N];
        visited = new boolean[M][N];
        x1 = new int[K];
        y1 = new int[K];
        x2 = new int[K];
        y2 = new int[K];
        for(int i=0; i<K; i++) {
            String[] s2 = br.readLine().split(" ");
            x1[i] = Integer.parseInt(s2[0]);
            y1[i] = Integer.parseInt(s2[1]);
            x2[i] = Integer.parseInt(s2[2]);
            y2[i] = Integer.parseInt(s2[3]);
        }
    }

    public static void when() {
        for(int i=0; i<K; i++) {
            for(int j=x1[i]; j<x2[i]; j++) {
                for(int k=y1[i]; k<y2[i]; k++) {
                    arr2[k][j] = true;
                }
            }
        }

        for(int k=0; k<K; k++) {
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    cnt = 0;
                    if (visited[i][j]) continue;
                    if (arr2[i][j]) continue;
                    dfs(i, j);
                    list3.add(cnt);
                }
            }
        }
        Collections.sort(list3);
        sb.append(list3.size()).append("\n");
        for(int l : list3) {
            sb.append(l).append(" ");
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }

    public static void dfs(int x, int y) {
        cnt++;
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            if(visited[nx][ny]) continue;
            if (arr2[nx][ny]) continue;
            dfs(nx, ny);
        }
    }

}