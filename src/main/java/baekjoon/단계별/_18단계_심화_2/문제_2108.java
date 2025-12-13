package baekjoon.단계별._18단계_심화_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class 문제_2108 {
    // [2025-12-08 JC]
    static StringBuffer sb = new StringBuffer();
    static int T, N, M, k, cnt;
    static List<int[][]> list1 = new ArrayList<>();
    static List<String> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
    static List<Integer> sorted = new LinkedList<>();
    static int[] arr1;
    static boolean[] isPrime;
    static List<Integer> primeList = new ArrayList<>();
    static int[][] num = new int[8001][2];

    public static void main(String[] args) throws IOException {
        given();// 테스트 실행을 준비하는 단계
        when(); // 테스트를 진행하는 단계
        then(); // 테스트 결과를 검증하는 단계
    }

    public static void given() throws IOException {
        InputStream is = System.in;                        // 바이트
        InputStreamReader isr = new InputStreamReader(is);// 캐릭터
        BufferedReader br = new BufferedReader(isr);    // 스트링
        String s1 = br.readLine();
        N = Integer.parseInt(s1);
        arr1 = new int[N];
        for (int i = 0; i < N; i++) {
            String s2 = br.readLine();
            arr1[i] = Integer.parseInt(s2);
        }
    }

    public static void when() {
        sb.append(average(arr1)).append("\n");
        sb.append(midNum(arr1)).append("\n");
        sb.append(recentNum(arr1)).append("\n");
        sb.append(maxMinusMin(arr1)).append("\n");
    }

    public static void then() {
        System.out.println(sb.toString());
    }

    public static long average(int[] arr) {
        double sum = 0;
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
        }
        return Math.round(sum/arr.length);
    }

    public static int midNum(int[] arr) {
        Arrays.sort(arr);   // 오름차순

        return arr[arr.length/2];
    }

    public static int recentNum(int[] arr) {
        int result = 0;
        for(int i=-4000; i<=4000; i++) {
            num[i+4000][0] = i;
        }
        // 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
        for(int i=0; i<arr.length; i++) {
            num[arr[i]+4000][1] += 1;
        }

        // 람다 표현식을 사용하여 첫 번째 열 기준으로 내림차순 정렬
        Arrays.sort(num, (a, b) -> b[1] - a[1]);

        // 최빈값이 유일한 경우
        if(num[0][1] > num[1][1]) {
            result = num[0][0];
        } else {
            // 두번째값의 건수가 0건이면 1번째값을 출력
            if(num[1][1] == 0) {
                result = num[0][0];
            } else {
                result = num[1][0];
            }
        }

        return result;
    }

    public static int maxMinusMin(int[] arr) {
        // 1개면 자기자신에서 자기자신을 뺌

        Arrays.sort(arr);   // 오름차순

        return arr[arr.length-1] - arr[0];
    }
}