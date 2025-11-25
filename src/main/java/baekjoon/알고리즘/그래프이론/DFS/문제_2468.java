package baekjoon.알고리즘.그래프이론.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 문제_2468 {
    // [2024-03-18 JC]
    static StringBuffer sb = new StringBuffer();
    static int N, M, k;
    static List<String> list1 = new ArrayList<>();
    static List<String> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
    static List<Integer> sorted = new LinkedList<>();
    static int[][] arr1;
    static boolean[][] arr2;
    static boolean[][] visited;
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
        String s1 = br.readLine();
        N = Integer.parseInt(s1);
        arr1 = new int[N + 1][N + 1];
        arr2 = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        for(int i=1; i<=N; i++) {
            String[] s2 = br.readLine().split(" ");
            for(int j=1; j<=N; j++) {
                arr1[i][j] = Integer.parseInt(s2[j-1]);
            }
        }
    }

    public static void when() {
        // 높이를 반복하면서 MAX값을 구한다.
        int max = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                max = Math.max(arr1[i][j], max);
            }
        }

        // max 는 전체가 잠기는 높이기 때문에 max-1까지 반복하면서 안전한 영역의 최대 개수를 찾아본다.
        int max2 = 1;	//  [2024-03-18 JC : 아무지역도 물에 잠기지 않는것이 최솟값이다.]
        for(int k=1; k<max; k++) {
            int cnt = 0;
            arr2 = new boolean[N + 1][N + 1];   // 물에 잠기는 영역 초기화.
            visited = new boolean[N + 1][N + 1];

            for(int i=1; i<=N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(arr1[i][j] <= k) arr2[i][j] = true;  // 물에 잠긴 영역이다.
                }
            }
//            System.out.println("arr2 : " + Arrays.deepToString(arr2));

            for(int i=1; i<=N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(arr2[i][j]) continue;
                    if(visited[i][j]) continue;
                    cnt++;
                    dfs(i, j);
                }
            }
//            System.out.println("cnt : " + cnt);
            max2 = Math.max(cnt, max2);
        }
        sb.append(max2);
    }

    public static void then() {
        System.out.println(sb.toString());
    }

    public static void dfs(int x, int y) {
//        System.out.println("x : " + x + " , y : " + y);
        visited[x][y] = true;
        for(int i=0; i<4; i++) {
            int a = x + dx[i];
            int b = y + dy[i];
            if(a < 1 || b < 1 || a > N || b > N) continue;
            if(arr2[a][b]) continue;
            if(visited[a][b]) continue;
            dfs(a, b);
        }
    }

}