package baekjoon.알고리즘.그래프이론.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 문제_14940 {
    // [2024-03-28 JC]
    static StringBuffer sb = new StringBuffer();
    static int N, M, cnt1, cnt2;
    static List<String> list1 = new ArrayList<>();
    static List<String> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
    static List<Integer> sorted = new LinkedList<>();
    static int[][] arr1 = new int[1001][1001];
    static boolean[][] visited = new boolean[1001][1001];
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
        for(int i=0; i<N; i++) {
            String[] s2 = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                arr1[i][j] = Integer.parseInt(s2[j]);
            }
        }
    }

    public static void when() {

        // 시작지점에서 시작한다.
        outerloop:	// 라벨
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (visited[i][j]) continue;
                if(arr1[i][j] == 2) {
                    bfs(i, j);
                    break outerloop;
                }
            }
        }

        // 방문하지 않은곳 -1
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (visited[i][j]) continue;
                if(arr1[i][j] == 1) {
                    arr1[i][j] = -1;
                }
            }
        }

        // 방문하지 않은곳 -1
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                sb.append(arr1[i][j]).append(" ");
            }
            sb.append("\n");
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        int[] qContents = new int[2];
        qContents[0] = x;
        qContents[1] = y;
        q.offer(qContents);
        visited[x][y] = true;

        int cnt = 0;
        arr1[x][y] = cnt;

        while(!q.isEmpty()) {
            cnt++;
            int size = q.size();
            for(int j=0; j<size; j++) {
                qContents = q.poll();
                x = qContents[0];
                y = qContents[1];
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if (visited[nx][ny]) continue;
                    if (arr1[nx][ny] == 0) continue;
                    visited[nx][ny] = true;
                    arr1[nx][ny] = cnt;
                    qContents = new int[2];
                    qContents[0] = nx;
                    qContents[1] = ny;
                    q.offer(qContents);
                }
            }
        }
    }
}