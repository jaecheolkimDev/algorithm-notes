package baekjoon.알고리즘.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 문제_10211 {
    // [2024-02-20 JC]
    static StringBuffer sb = new StringBuffer();
    static int t, n, m, k, lastCnt;
    static List<Integer> list1 = new ArrayList<>();
    static int[] array1;
    static List<String> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
    static int[] array3;
    static List<Integer> sorted = new LinkedList<>();
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
        t = Integer.parseInt(s1);    // 5~500,000
        for(int i=1; i<=t; i++) {
            String s2 = br.readLine();
            list1.add(Integer.parseInt(s2));
            String s3 = br.readLine();
            list2.add(s3);
        }
    }

    public static void when() {
        for(int z=1; z<=t; z++) {
            int sum = 0;
            list3 = new ArrayList<>();
            list3.add(0);
            String[] s = list2.get(z-1).split(" ");
            int size = list1.get(z-1);
            for (int i = 0; i < size; i++) {
                sum += Integer.parseInt(s[i]);
                list3.add(sum);
            }

            int subSum = 0;
            int bigNumber = Integer.MIN_VALUE;
            for (int i=1; i<=size; i++) {
                for(int j=i; j<=size; j++) {
                    subSum = list3.get(j) - list3.get(j-i);
                    if (subSum > bigNumber) {
                        bigNumber = subSum;
                    }
                }
            }
            sb.append(bigNumber).append("\n");
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}