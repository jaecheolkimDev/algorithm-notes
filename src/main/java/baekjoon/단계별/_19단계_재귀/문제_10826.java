package baekjoon.단계별._19단계_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class 문제_10826 {
    // [2025-12-09 JC]
    static StringBuffer sb = new StringBuffer();
    static BigInteger N, M;
    static BigInteger[] fibonacci = new BigInteger[10_001];
    static int[] pisanoPeriod;
    static List<Integer> list2 = new ArrayList<>();
    static long period = 1_500_000;
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
        N = new BigInteger(s1);
    }
    public static void when() {
        fibonacci[0] = BigInteger.ZERO;
        fibonacci[1] = BigInteger.ONE;
        for(int i=2; i<fibonacci.length; i++) {
            fibonacci[i] = fibonacci[i-1].add(fibonacci[i-2]);
        }

        sb.append(fibonacci[N.intValue()]);
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}