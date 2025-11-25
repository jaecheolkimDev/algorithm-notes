package baekjoon.알고리즘.그래프이론.FloydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 문제_1389 {
    // [2024-03-22 JC]
    static StringBuffer sb = new StringBuffer();
    static int N, M, k;
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
        String[] s1 = br.readLine().split(" ");
        N = Integer.parseInt(s1[0]);
        M = Integer.parseInt(s1[1]);
        arr1 = new int[N][N];
        for(int i=0; i<M; i++) {
            String[] s2 = br.readLine().split(" ");
            int a = Integer.parseInt(s2[0]);
            int b = Integer.parseInt(s2[1]);
            arr1[a-1][b-1] = 1;
            arr1[b-1][a-1] = 1;
        }
    }

    public static void when() {
        floyd();

        int min = Integer.MAX_VALUE;
        int minNumber = 0;
        for(int i=0; i<N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                cnt += arr1[i][j];
            }
            if(cnt < min) {
                min = cnt;
                minNumber = i+1;
            }
        }
        sb.append(minNumber);
    }

    public static void then() {
        System.out.println(sb.toString());
    }

    // 플로이드와샬
    public static void floyd() {
        // 초기화
        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr1[i][j] == 0) {
                    if(i != j) arr1[i][j] = 1_000_000_000;  // 적당히 큰 수
                }
            }
        }

        // 풀이
        for(int k=0; k<N; k++) {    // 경유지
            for(int i=0; i<N; i++) {    // 출발 정점
                for(int j=0; j<N; j++) {    // 도착 정점
                    arr1[i][j] = Math.min(arr1[i][j], arr1[i][k] + arr1[k][j]);
                }
            }
        }
    }
}