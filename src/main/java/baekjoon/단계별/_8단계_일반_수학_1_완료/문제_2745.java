package baekjoon.단계별._8단계_일반_수학_1_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

public class 문제_2745 {
    // [2024-01-08 JC]
    static int result = 0;
    static int tot = 0;
    static int b;
    static String n;
    static int[] i = new int[101] , j = new int[101] , nBasketTmp = new int[101] , nBasket = new int[101];
    static Map<String, Integer> map = Map.ofEntries(
            Map.entry("0", 0),
            Map.entry("1", 1),
            Map.entry("2", 2),
            Map.entry("3", 3),
            Map.entry("4", 4),
            Map.entry("5", 5),
            Map.entry("6", 6),
            Map.entry("7", 7),
            Map.entry("8", 8),
            Map.entry("9", 9),
            Map.entry("A", 10),
            Map.entry("B", 11),
            Map.entry("C", 12),
            Map.entry("D", 13),
            Map.entry("E", 14),
            Map.entry("F", 15),
            Map.entry("G", 16),
            Map.entry("H", 17),
            Map.entry("I", 18),
            Map.entry("J", 19),
            Map.entry("K", 20),
            Map.entry("L", 21),
            Map.entry("M", 22),
            Map.entry("N", 23),
            Map.entry("O", 24),
            Map.entry("P", 25),
            Map.entry("Q", 26),
            Map.entry("R", 27),
            Map.entry("S", 28),
            Map.entry("T", 29),
            Map.entry("U", 30),
            Map.entry("V", 31),
            Map.entry("W", 32),
            Map.entry("X", 33),
            Map.entry("Y", 34),
            Map.entry("Z", 35)
    );
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
        n = s1[0];
        b = Integer.parseInt(s1[1]);
    }
    public static void when() {
        for(int i=0; i<n.length(); i++) {
            result += (map.get(n.substring(i, i+1)) * Math.pow(b, n.length()-1-i));
        }
    }
    public static void then() {
        System.out.println(result);
    }
}
