package baekjoon.단계별._10단계_기하_직사각형과_삼각형_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 문제_9063 {
    // [2024-03-10 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, m;
    static int[][] arrTwoDimensions = new int[2][100_001];
    static List<Integer> list2 = new ArrayList<>();
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
        n = Integer.parseInt(s1);
        for(int i=1; i<=n; i++) {
            String[] s2 = br.readLine().split(" ");
            arrTwoDimensions[0][i] = Integer.parseInt(s2[0]);
            arrTwoDimensions[1][i] = Integer.parseInt(s2[1]);
        }
    }
    public static void when() {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++) {
            max1 = Math.max(max1, arrTwoDimensions[0][i]);
            max2 = Math.max(max2, arrTwoDimensions[1][i]);
            min1 = Math.min(min1, arrTwoDimensions[0][i]);
            min2 = Math.min(min2, arrTwoDimensions[1][i]);
        }
        sb.append((max1-min1) * (max2-min2));
    }

    public static void then() {
        System.out.println(sb.toString());
    }

}