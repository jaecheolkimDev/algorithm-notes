package baekjoon.단계별._15단계_약수_배수와_소수_2_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class 문제_4134 {
    // [2024-03-13 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, m;
    static Map<String, String> map1 = new HashMap<>();
    static List<Integer> list1 = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();
    static Set<Integer> set1 = new HashSet<>();
    static int[] arr1;
    static int[] arr2;
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
        arr1 = new int[n];
        for(int i=0; i<n; i++) {
            String s2 = br.readLine();
            arr1[i] = Integer.parseInt(s2);
        }
    }
    public static void when() {
        for(int i=0; i<n; i++) {
            int k = 2;
            int target = arr1[i] + 1;
            for(int j=k; j<target/2 + 1; j++) {
                if(target%j == 0) {
                    target++;
                    k = 2;
                }
            }
            sb.append(target).append("\n");
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }

    /**
     * 최소공배수 구하기
     * 1) 두 수의 공약수로 나눈 몫이 서로소가 될 때까지 나눈다.
     * 2) 왼쪽 공약수들과 아래 서로소까지 모두 곱한다.
     *
     * 공식 : (num1 * num2) / 최대공약수
     */
    public static long getLeastCommonMultiple(long num1, long num2) {
        return (num1 * num2) / getGreatestCommonDivisor(num1, num2);
    }

    /**
     * 최대공약수 구하기
     * 1) 두 수를 공약수로 계속 나눈다.
     * 2) 공약수로 나눈 몫이 서로소가 되면 stop
     * 3) 왼쪽 공약수를 모두 곱한다.
     *
     * 유클리드 호제법
     * 자연수 a,b에 대해서 a를 b로 나눈 나머지를 r이라 한다면 a,b의 최대공약수와 b,r의 최대공약수는 같다.
     * 이 성질에 따라 a를 b로 나눈 나머지 r을 구하고, b를 r로 나눈 나머지 r'을 구한다.
     * 나머지가 0이 될때 나눈 수가 a,b의 최대공약수가 된다.
     *
     * [2024-03-13 JC : num1은 0이어도 되는데, num2는 0이면 안된다. 0을 먼저 연산하면 나누기/나머지연산에서 0이 나온다. num1이 0이면 num2가 리턴된다.]
     *  => num2가 0일때 => ArithmeticException: / by zero 발생.
     */
    public static long getGreatestCommonDivisor(long num1, long num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGreatestCommonDivisor(num2, num1 % num2);
    }
}