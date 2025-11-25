package baekjoon.단계별._13단계_정렬_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 문제_18870 {
    // [2024-03-13 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, k, lastCnt;
    static List<Integer> list2 = new LinkedList<>();
    static List<Integer> list3 = new LinkedList<>();
    static List<Integer> sorted = new LinkedList<>();
    static int[] arr;
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
        n = Integer.parseInt(s1);    // 1~1억
        String[] s2 = br.readLine().split(" "); // 1~10억
        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(s2[i]);
        }
    }

    public static void when() {
        // [2024-03-13 JC : LIST를 사용시 시간초과가 발생하므로 배열을 사용함.]
        int[] arr2 = Arrays.stream(arr).distinct().toArray();
        Arrays.sort(arr2);
        for(int i=0; i<arr.length; i++) {
            sb.append(Arrays.binarySearch(arr2, arr[i])).append(" ");
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}
