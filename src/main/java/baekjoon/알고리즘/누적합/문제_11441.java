package baekjoon.알고리즘.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 문제_11441 {
    // [2024-02-20 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, m, k, lastCnt;
    static List<Integer> list1 = new ArrayList<>();
    static List<String> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
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
        n = Integer.parseInt(s1);    // 5~500,000
        String[] s2 = br.readLine().split(" "); // 1~10억
        for(int i=1; i<=n; i++) {
            list1.add(Integer.parseInt(s2[i-1]));
        }
        String s3 = br.readLine();
        m = Integer.parseInt(s3);    // 5~500,000
        for(int i=1; i<=m; i++) {
            String s4 = br.readLine(); // 1~10억
            list2.add(s4);
        }
    }

    public static void when() {
        int sum = 0;
        list3.add(0);
        for(int i=0; i<n; i++) {
            sum += list1.get(i);
            list3.add(sum);
        }

        for(int i=0; i<m; i++) {
            String list2GetString = list2.get(i);
            String[] list2Get = list2GetString.split(" ");
            int start = Integer.parseInt(list2Get[0]);
            int end = Integer.parseInt(list2Get[1]);
            sb.append(list3.get(end) - list3.get(start-1)).append("\n");
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}