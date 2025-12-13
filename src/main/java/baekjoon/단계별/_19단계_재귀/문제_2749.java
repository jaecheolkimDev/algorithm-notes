package baekjoon.단계별._19단계_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 문제_2749 {
    // [2025-12-09 JC]
    static StringBuffer sb = new StringBuffer();
    static long N, M;
    static long[] fibonacci = new long[1_500_000];
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
        N = Long.parseLong(s1);
    }
    public static void when() {
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for(int i=2; i<fibonacci.length; i++) {
            fibonacci[i] = 0;
        }

        sb.append(fibonacci(N%period));

        // 같음
        // = N번째 피보나치 수를 M으로 나눈 나머지
        // = N%P번째 피보나치 수를 M으로 나눈 나머지
    }

    public static void then() {
        System.out.println(sb.toString());
    }

    public static long fibonacci(long n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        long num1 = 0, num2 = 0;

        if(fibonacci[(int)n-1] == 0) {
            fibonacci[(int)n-1] = fibonacci(n-1);
        }
        num1 = fibonacci[(int)n-1];

        if(fibonacci[(int)n-2] == 0) {
            fibonacci[(int)n-2] = fibonacci((int)n-2);
        }
        num2 = fibonacci[(int)n-2];

        return (num1 + num2)%1_000_000;
    }

//    public static int pisanoPeriod() {
//        // 피사노 주기의 마지막은 0
//        // 다시 시작하는 값은 1
//    }
}