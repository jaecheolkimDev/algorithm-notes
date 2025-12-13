package baekjoon.단계별._17단계_조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class 문제_1010 {
    // [2025-12-03 JC]
    static StringBuffer sb = new StringBuffer();
    static int t, n, m;
    static int[][] arr;
    static BigInteger[] saveFactorial = new BigInteger[31];
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
        t = Integer.parseInt(s1);
        arr = new int[t][2];
        for(int i=0; i<t; i++) {
            String[] s2 = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s2[0]);
            arr[i][1] = Integer.parseInt(s2[1]);
        }
    }
    public static void when() {
        for(int i=0; i<31; i++) {
            saveFactorial[i] = factorial(i);
        }
        for(int i=0; i<t; i++) {
            sb.append(buildBridge(arr[i][1], arr[i][0])).append("\n");
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }

    public static BigInteger buildBridge(int n, int m) {
        if(n == m) return BigInteger.ONE;
        return factorial(n).divide((factorial(m).multiply(factorial(n-m))));
    }
    public static BigInteger factorial(int n) {
        if(n == 0 || n == 1) return BigInteger.ONE;
        return saveFactorial[n-1].multiply(BigInteger.valueOf(n));
    }
}