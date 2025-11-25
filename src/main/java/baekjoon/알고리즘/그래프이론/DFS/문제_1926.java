package baekjoon.알고리즘.그래프이론.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 문제_1926 {
    // [2024-03-21 JC]
    static StringBuffer sb = new StringBuffer();
    static int N, M, cnt1, cnt2;
    static List<String> list1 = new ArrayList<>();
    static List<String> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
    static List<Integer> sorted = new LinkedList<>();
    static boolean[][] arr1;
    static boolean[][] visited = new boolean[501][501];
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
        arr1 = new boolean[N][M];
        for(int i=0; i<N; i++) {
            String[] s2 = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                if("1".equals(s2[j])) {
                    arr1[i][j] = true;
                }
            }
        }
    }

    public static void when() {
        int max = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                cnt2 = 1;
                if (visited[i][j]) continue;
                if (!arr1[i][j]) continue;
                dfs(i, j);
                cnt1++;
                max = Math.max(max, cnt2);
            }
        }
        sb.append(cnt1).append("\n");
        sb.append(max);
    }

    public static void then() {
        System.out.println(sb.toString());
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(visited[nx][ny]) continue;
            if(!arr1[nx][ny]) continue;
            dfs(nx, ny);
            cnt2++;
        }
    }

}