package baekjoon.알고리즘.그래프이론.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 문제_7562 {
    // [2024-03-20 JC]
    static StringBuffer sb = new StringBuffer();
    static int T, N, M, k, cnt;
    static List<int[][]> list1 = new ArrayList<>();
    static List<String> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
    static List<Integer> sorted = new LinkedList<>();
    static int[][] visited;
    static boolean[][] arr2;
    static List<List<Integer>> linkedList = new LinkedList<>();
    static int[] dx = {2,2,1,-1,-2,-2,-1,1};
    static int[] dy = {1,-1,-2,-2,-1,1,2,2};
    static int[] line;
    static String[] start;
    static String[] end;
    static Queue<CustomArray12> q = new LinkedList<>();
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
        T = Integer.parseInt(s1);
        line = new int[T];
        start = new String[T];
        end = new String[T];
        for(int i=0; i<T; i++) {
            String s2 = br.readLine();
            line[i] = Integer.parseInt(s2);
            String s3 = br.readLine();
            start[i] = s3;
            String s4 = br.readLine();
            end[i] = s4;
        }
    }

    public static void when() {
        for(int i=0; i<T; i++) {
            int l = line[i];
            visited = new int[l][l];
            q = new LinkedList<>();
            String[] s = start[i].split(" ");
            String[] e = end[i].split(" ");
            int cnt = bfs(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(e[0]), Integer.parseInt(e[1]), l, l);
            sb.append(cnt).append("\n");
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }

    public static int bfs(int startX, int startY, int endX, int endY, int maxX, int maxY) {
        if(startX == endX && startY == endY) {
            return 0;
        }
        visited[startX][startY] = 0;
        q.offer(new CustomArray12(startX, startY));

        while(!q.isEmpty()) {
            CustomArray12 ca = q.peek();
            q.poll();
            for (int i = 0; i < 8; i++) {
                int x = ca.getX();
                int y = ca.getY();
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= maxX || ny >= maxY) continue;
                if (visited[nx][ny] > 0) continue;
                visited[nx][ny] = visited[x][y] + 1;
                if(nx == endX && ny == endY) return visited[nx][ny];
                q.offer(new CustomArray12(nx, ny));
            }
        }

        return -1;
    }

}

class CustomArray12 {
    private int x;
    private int y;

    @Override
    public String toString() {
        return "CustomArray12{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public CustomArray12(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}