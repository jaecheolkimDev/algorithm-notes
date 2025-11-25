package baekjoon.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 문제_11047 {
    // [2024-02-25 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, k, m;
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
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        k = Integer.parseInt(s1[1]);
        for(int i=1; i<=n; i++) {
            String s3 = br.readLine();
            list2.add(Integer.parseInt(s3));
        }
    }
    public static void when() {
        int sum = 0;
        int target = k;
        for(int i=n-1; i>=0; i--) {
            int divide = list2.get(i);
            sum += target/divide;
            target = target%divide;
        }

        sb.append(sum);
    }

    public static void then() {
        System.out.println(sb.toString());
    }

}