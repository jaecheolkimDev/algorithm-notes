package baekjoon.단계별._19단계_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 문제_10870 {
    // [2025-12-09 JC]
    static StringBuffer sb = new StringBuffer();
    static int N, M;
    static long[] fibonacci = new long[20];
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
        N = Integer.parseInt(s1);
    }
    public static void when() {
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        sb.append(fibonacci(N));
    }

    public static void then() {
        System.out.println(sb.toString());
    }

    public static long fibonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        long num1 = 0, num2 = 0;

        if(fibonacci[n-1] == 0) {
            fibonacci[n-1] = fibonacci(n-1);
        }
        num1 = fibonacci[n-1];

        if(fibonacci[n-2] == 0) {
            fibonacci[n-2] = fibonacci(n-2);
        }
        num2 = fibonacci[n-2];

        return num1 + num2;
    }
}