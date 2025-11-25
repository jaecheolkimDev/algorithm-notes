package baekjoon.알고리즘.그래프이론.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 문제_7576 {
    // [2024-03-28 JC]
    static StringBuffer sb = new StringBuffer();
    static int N, M, cnt=1, cnt2;
    static List<String> list1 = new ArrayList<>();
    static List<String> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
    static List<Integer> sorted = new LinkedList<>();
    static int[][] arr1;
    static boolean[][] visited = new boolean[1001][1001];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static Queue<int[]> q = new LinkedList<>();
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
        arr1 = new int[N][M];
        for(int i=0; i<N; i++) {
            String[] s2 = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                arr1[i][j] = Integer.parseInt(s2[j]);
            }
        }
    }

    public static void when() {

        // 시작지점을 전부 q에 넣고 시작한다.
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (visited[i][j]) continue;
                if(arr1[i][j] == 1) {
                    int[] qContents = new int[2];
                    qContents[0] = i;
                    qContents[1] = j;
                    q.offer(qContents);
                }
            }
        }
        bfs();


        outter1:    // 모두 익지는 못하는 상황
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr1[i][j] == 0) {
                    sb.append(-1);
                    break outter1;
                }
            }
        }

        // 저장될 때부터 모든 토마토가 익어있는 상태
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                max = Math.max(max, arr1[i][j]);
            }
        }
        if(max == 1) sb.append(0);

        // 위의 예외대상이 아니라면 정답 출력.
        if(sb.isEmpty()) {
            sb.append(cnt-2);
        }
//        System.out.println(Arrays.deepToString(arr1));
    }

    public static void then() {
        System.out.println(sb.toString());
    }

    public static void bfs() {
        while(!q.isEmpty()) {
            cnt++;
            int size = q.size();
            for(int j=0; j<size; j++) {
                int[] qContents = q.poll();
                int x = qContents[0];
                int y = qContents[1];
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if (visited[nx][ny]) continue;
                    if (arr1[nx][ny] == -1) continue;
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