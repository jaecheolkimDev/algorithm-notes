package baekjoon.단계별._6단계_심화_1_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 문제_10988 {
    // [2024-01-07 JC]
    static int i;
    static String s;
    static int result;
    static int[] j = new int[101] , nBasketTmp = new int[101] , nBasket = new int[101];
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
        result = isPalindrome(s);
    }

    public static void then() {
        System.out.print(result);
    }

    public static int isPalindrome(String str) {
        if(str.length() <= 1) {
            return 1;
        }

        if(firtsCharacter(str).equals(lastCharacter(str))) {
            return isPalindrome(middleCharacter(str));
        } else {
            return 0;
        }
    }

    public static String middleCharacter(String s) {
        return s.substring(1, s.length()-1);
    }
    public static String firtsCharacter(String s) {
        return s.substring(0, 1);
    }
    public static String lastCharacter(String s) {
        return s.substring(s.length()-1);
    }
}
