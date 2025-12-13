package baekjoon.basic.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 문제_1541 {
    // [2025-12-03 JC]
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
        boolean minusFlag = false;
        // -, + 를 구분자로 사용
        String[] s1 = s.split("[-+]");
        String[] s2 = new String[s1.length-1];
        Matcher matcher = Pattern.compile("[-+]").matcher(s);
        int index = 0;
        while(matcher.find()) {
            s2[index] = matcher.group();
            index++;
        }
//        System.out.println("숫자 배열 : " + Arrays.toString(s1));
//        System.out.println("부호 배열 : " + Arrays.toString(s2));
        sum += Integer.parseInt(s1[0]);
        for(int i=0; i<s2.length; i++) {
            if(minusFlag) {
                if ("+".equals(s2[i])) {
                    subSum += Integer.parseInt(s1[i+1]);
                } else {
                    sum -= subSum;
                    subSum = 0;
                    subSum += Integer.parseInt(s1[i+1]);
                    minusFlag = true;
                }
            } else {
                if ("+".equals(s2[i])) {
                    sum += Integer.parseInt(s1[i+1]);
                } else {
                    subSum += Integer.parseInt(s1[i+1]);
                    minusFlag = true;
                }
            }
        }
        if(minusFlag) {
            sum -= subSum;
        }
        sb.append(sum);
    }
    public static void then() {
        System.out.print(sb.toString());
    }
}