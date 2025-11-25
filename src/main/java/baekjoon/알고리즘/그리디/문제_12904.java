package baekjoon.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 문제_12904 {
    // [2024-03-06 JC]
    static StringBuffer sb = new StringBuffer();
    static int n,m;
    static String s, t, result;
    static int[] x;
    static Boolean[] streetLamp;
    static List<Integer> gapList = new ArrayList<>();
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
        t = br.readLine();
    }
    public static void when() {
//        System.out.println("t.length() : " + t.length());
//        System.out.println("t.length() : " + t.substring(t.length()-1));
        String str = t;
        while(str.length() > s.length()) {
            if("A".equals(str.substring(str.length()-1))){
                str = str.substring(0, str.length()-1);
            } else {
                str = str.substring(0, str.length()-1);
                StringBuffer sb1 = new StringBuffer(str);
                str = sb1.reverse().toString();
            }
        }
        if(str.equals(s)) {
            sb.append(1);
        } else {
            sb.append(0);
        }
    }
    public static void then() {
        System.out.print(sb.toString());
    }
}