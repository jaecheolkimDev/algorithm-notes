package baekjoon.알고리즘.그래프이론.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 문제_11725 {
    // [2024-03-19 JC]
    static StringBuffer sb = new StringBuffer();
    static int N, M, k;
    static List<String> list1 = new ArrayList<>();
    static List<String> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
    static List<Integer> sorted = new LinkedList<>();
    static boolean[] visited = new boolean[100_001];
    static int[] arr2;
    static List<List<Integer>> linkedList = new LinkedList<>();
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
        arr2 = new int[N-1];
        for(int i=0; i<=N; i++) {
            linkedList.add(new ArrayList<>());
        }
        for(int i=1; i<N; i++) {
            String[] s2 = br.readLine().split(" ");
            int a = Integer.parseInt(s2[0]);
            int b = Integer.parseInt(s2[1]);
            linkedList.get(a).add(b);
            linkedList.get(b).add(a);
        }
    }

    public static void when() {
        for(int i=1; i<N; i++) {
            if (visited[i]) continue;
            dfs(i);
        }
        for(int i : arr2) {
            sb.append(i).append("\n");
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }

    public static void dfs(int x) {
        visited[x] = true;

        for(int i=0; i<linkedList.get(x).size(); i++) {
            int num = linkedList.get(x).get(i);
            if(visited[num]) continue;
            arr2[num - 2] = x;
            dfs(num);
        }
    }

}