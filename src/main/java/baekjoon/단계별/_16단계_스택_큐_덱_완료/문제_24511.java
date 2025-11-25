package baekjoon.단계별._16단계_스택_큐_덱_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class 문제_24511 {
    // [2024-03-17 JC]
    static StringBuffer sb = new StringBuffer();
    static String result = "";
    static int N, M, k, lastCnt;
    static List<Integer> list2 = new LinkedList<>();
    static List<Deque<Integer>> list3 = new ArrayList<>();
    static List<Integer> list4 = new ArrayList<>();
    static int[][] arr1;
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
        String[] s2 = br.readLine().split(" "); // 1~10억
        arr1 = new int[2][N];
        for(int i=0; i<N; i++) {
            arr1[0][i] = Integer.parseInt(s2[i]);
        }
        String[] s3 = br.readLine().split(" "); // 1~10억
        for(int i=0; i<N; i++) {
            arr1[1][i] = Integer.parseInt(s3[i]);
        }
        String s4 = br.readLine();
        M = Integer.parseInt(s4);
        String[] s5 = br.readLine().split(" "); // 1~10억
        for(int i=1; i<=M; i++) {
            list4.add(Integer.parseInt(s5[i-1]));
        }
    }

    public static void when() {
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=arr1[0].length-1; i>=0; i-- ) {
            if(1 == arr1[0][i]) continue;
            q.offer(arr1[1][i]);
        }
        for(int i=0; i<M; i++) {
            q.offer(list4.get(i));
        }
        for(int i=1; i<=M; i++) {	// 10만
            sb.append(q.poll()).append(" ");
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }

}
