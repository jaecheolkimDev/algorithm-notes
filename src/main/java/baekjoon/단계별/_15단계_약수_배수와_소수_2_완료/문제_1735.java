package baekjoon.단계별._15단계_약수_배수와_소수_2_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class 문제_1735 {
    // [2024-03-13 JC]
    static StringBuffer sb = new StringBuffer();
    static long n, m, k, lastCnt, a, b;
    static List<String> list1 = new ArrayList<>();
    static List<String> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
    static List<Integer> sorted = new LinkedList<>();
    static Map<String, Integer> map1 = new HashMap<>();
    static Map<Integer, String> map2 = new HashMap<>();
    static Set<Integer> set1 = new HashSet<>();
    static Set<Integer> set2 = new HashSet<>();
    static int[] arr1 = new int[2];
    static int[] arr2 = new int[2];
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
        arr1[0] = Integer.parseInt(s1[0]);
        arr1[1] = Integer.parseInt(s1[1]);
        String[] s2 = br.readLine().split(" ");
        arr2[0] = Integer.parseInt(s2[0]);
        arr2[1] = Integer.parseInt(s2[1]);
    }

    public static void when() {
        int num1 = getLeastCommonMultiple(arr1[1], arr2[1]);
        int num2 = (arr1[0] * (num1/arr1[1])) + (arr2[0] * (num1/arr2[1]));

        sb.append(num2).append(" ").append(num1);
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
    public static int getLeastCommonMultiple(int num1, int num2) {
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
     */
    public static int getGreatestCommonDivisor(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGreatestCommonDivisor(num2, num1 % num2);
    }
}