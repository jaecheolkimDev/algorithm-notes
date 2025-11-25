package baekjoon.알고리즘.그래프이론.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 문제_4963 {
    // [2024-03-20 JC]
    static StringBuffer sb = new StringBuffer();
    static int N, M, k;
    static List<int[][]> list1 = new ArrayList<>();
    static List<String> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
    static List<Integer> sorted = new LinkedList<>();
    static boolean[][] visited;
    static int[][] arr2;
    static List<List<Integer>> linkedList = new LinkedList<>();
    static int[] dx = {1,1,1,0,-1,-1,-1,0};
    static int[] dy = {1,0,-1,-1,-1,0,1,1};
    public static void main(String[] args) throws IOException {
        given();// 테스트 실행을 준비하는 단계
        when(); // 테스트를 진행하는 단계
        then(); // 테스트 결과를 검증하는 단계
    }

    public static void given() throws IOException {
        InputStream is = System.in;						// 바이트
        InputStreamReader isr = new InputStreamReader(is);// 캐릭터
        BufferedReader br = new BufferedReader(isr);    // 스트링

        while(true) {
            String s1 = br.readLine();
            if (s1.equals("0 0")) break;
            String[] s2 = s1.split(" ");
//            System.out.println(Arrays.toString(s2));
            int a = Integer.parseInt(s2[0]);
            int b = Integer.parseInt(s2[1]);
            int[][] arr = new int[b][a];
            for(int i=0; i<b; i++) {
                String[] s3 = br.readLine().split(" ");
//                System.out.println(Arrays.toString(s3));
                for(int j=0; j<a; j++) {
                    arr[i][j] = Integer.parseInt(s3[j]);
                }
            }
            list1.add(arr);
        }
    }

    public static void when() {
        for(int i=0; i<list1.size(); i++) {
//            System.out.println(Arrays.deepToString(list1.get(i)));
            arr2 = list1.get(i);

            int a = arr2[0].length; // 3
            int b = arr2.length;    // 2
            visited = new boolean[b][a];
            int cnt = 0;
            for(int j=0; j<b; j++) {
                for(int k=0; k<a; k++) {
                    if (visited[j][k]) continue;
                    if (arr2[j][k] == 0) continue;
                    cnt++;
                    dfs(j,k, b , a);
                }
            }
            sb.append(cnt).append("\n");
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }

    public static void dfs(int x, int y, int maxX, int maxY) {
        visited[x][y] = true;

        for(int i=0; i<8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= maxX || ny >= maxY) continue;
            if(visited[nx][ny]) continue;
            if (arr2[nx][ny] == 0) continue;
            dfs(nx, ny, maxX, maxY);
        }
    }

}