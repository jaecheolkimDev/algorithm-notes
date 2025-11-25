package baekjoon.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문제_1541 {
    // [2024-02-27 JC]
    static StringBuffer sb = new StringBuffer();
    static int i;
    static String s, result;
    static int n,m;
    static String[] sArr = new String[200];
    public static void main(String[] args) throws IOException {
        given();// 테스트 실행을 준비하는 단계
        when(); // 테스트를 진행하는 단계
        then(); // 테스트 결과를 검증하는 단계
    }

    public static void given() throws IOException {
        InputStream is = System.in;						// 바이트
        InputStreamReader isr = new InputStreamReader(is);// 캐릭터
        BufferedReader br = new BufferedReader(isr);    // 스트링
        s = br.readLine();
    }
    public static void when() {
        int sum = 0;
        int subSum = 0;
        boolean first = true;
        StringTokenizer st = new StringTokenizer(s, "-");
        // 양수만 있을때
        if(st.countTokens() == 1) {
            StringTokenizer st1 = new StringTokenizer(st.nextToken(), "+");
            while (st1.hasMoreTokens()) {
                subSum += Integer.parseInt(st1.nextToken());
            }
            sum += subSum;
        }
        // 음수도 포함되어 있을때
        else {
            while (st.hasMoreTokens()) {
                // 첫번째 수는 무조건 합.
                if (first) {
                    sum += Integer.parseInt(st.nextToken());
                    first = false;
                }
                StringTokenizer st1 = new StringTokenizer(st.nextToken(), "+");
                while (st1.hasMoreTokens()) {
                    subSum += Integer.parseInt(st1.nextToken());
                }
                sum -= subSum;
                subSum = 0;
            }
        }

        sb.append(sum);
    }
    public static void then() {
        System.out.print(sb.toString());
    }
}