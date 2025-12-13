package baekjoon.단계별._19단계_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 문제_9471 {
    // [2025-12-09 JC]
    static StringBuffer sb = new StringBuffer();
    static int[] N, M;
    static int P;
    static long[] fibonacci;
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
        P = Integer.parseInt(s1);
        N = new int[P];
        M = new int[P];
        for(int i=0; i<P; i++) {
            String[] s2 = br.readLine().split(" ");
            N[i] = Integer.parseInt(s2[0]);
            M[i] = Integer.parseInt(s2[1]);
        }
    }
    public static void when() {
        for(int i=2; i<=1_000_000; i++) {
            if(baseLog(i, 2) % 2 == 0) {
                pisanoPeriod[i] = 3 * (int)Math.pow(2, i-1);
            }
            if(baseLog(i, 5) % 5 == 0) {
                pisanoPeriod[i] = 4 * (int)Math.pow(5, i);
            }
            if()
        }
        // 테스트 케이스 갯수
        for(int i=0; i<P; i++) {
            if(M[i])
        }


        fibonacci[0] = 0;
        fibonacci[1] = 1;
//        fibonacci = new long[1_500_000];
//        for(int i=2; i<fibonacci.length; i++) {
//            fibonacci[i] = 0;
//        }

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

    public static double baseLog(double x, double base) {
        return Math.log(x) / Math.log(base);
    }
}