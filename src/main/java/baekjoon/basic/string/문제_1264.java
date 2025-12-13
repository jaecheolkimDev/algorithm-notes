package baekjoon.basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class 문제_1264 {
    static StringBuffer sb = new StringBuffer();
    // [2025-12-03 JC]
    static int result = 0;
    static int tot = 0;
    static int t,m;
    static String line;
    static int[] i = new int[101] , j = new int[101] , nBasketTmp = new int[101] , nBasket = new int[101];
    static String[] tResult = new String[11];
    static List<String> testList = new ArrayList<>(), testResultList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        given();// 테스트 실행을 준비하는 단계
        when(); // 테스트를 진행하는 단계
        then(); // 테스트 결과를 검증하는 단계
    }

    public static void given() throws IOException {
        InputStream is = System.in;						// 바이트
        InputStreamReader isr = new InputStreamReader(is);// 캐릭터
        BufferedReader br = new BufferedReader(isr);    // 스트링
        while(true) {
            line = br.readLine();
            if ("#".equals(line)) break;
            testList.add(line);
        }
    }
    public static void when() {
        for(int i=0; i<testList.size(); i++) {
            sb.append(findVowels(testList.get(i))).append("\n");
        }
    }
    public static void then() {
        System.out.print(sb.toString());
    }

    /**
     * 모음 찾는 메소드
     * @author JC
     * @since 2025-12-03
     * @return
     */
    public static int findVowels(String s) {
        int cnt = 0;
        for(int i=0; i<s.length(); i++) {
            if("a".equalsIgnoreCase(String.valueOf(s.charAt(i)))
            || "e".equalsIgnoreCase(String.valueOf(s.charAt(i)))
            || "i".equalsIgnoreCase(String.valueOf(s.charAt(i)))
            || "o".equalsIgnoreCase(String.valueOf(s.charAt(i)))
            || "u".equalsIgnoreCase(String.valueOf(s.charAt(i)))) {
                cnt++;
            }
        }
        return cnt;
    }
}
