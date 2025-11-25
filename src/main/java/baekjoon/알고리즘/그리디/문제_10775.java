package baekjoon.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 문제_10775 {
    // [2024-03-09 JC : UNION-FIND 알고리즘(동일한 배열에 집어넣고 찾기 때문에 n의 시간으로 찾을 수 있다.)]
    static StringBuffer sb = new StringBuffer();
    static int n,m, k, g, p;
    static List<Integer> list1 = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
    static List<Integer> list4 = new ArrayList<>();
    static int[] parents = new int[100001];
    public static void main(String[] args) throws IOException {
        given();// 테스트 실행을 준비하는 단계
        when(); // 테스트를 진행하는 단계
        then(); // 테스트 결과를 검증하는 단계
    }

    public static void given() throws IOException {
        InputStream is = System.in;						// 바이트
        InputStreamReader isr = new InputStreamReader(is);// 캐릭터
        BufferedReader br = new BufferedReader(isr);    // 스트링
        g = Integer.parseInt(br.readLine());
        p = Integer.parseInt(br.readLine());
        for(int i=0; i<p; i++) {
            list1.add(Integer.parseInt(br.readLine()));
        }
    }
    public static void when() {
        for(int i=1; i<g+1; i++) {
            parents[i] = i;
        }
        int cnt = 0;
        for(int i=0; i<p; i++) {
            if(find(list1.get(i)) == 0) break;
            cnt++;
            union(find(list1.get(i)) , find(list1.get(i))-1);
        }

        sb.append(cnt);
    }
    public static void then() {
        System.out.print(sb.toString());
    }

    public static int find(int x) {
        if(x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parents[a] = b;
    }
}