package baekjoon.단계별._8단계_일반_수학_1_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class 문제_11005 {
    // [2024-01-08 JC]
    static String result;
    static int tot = 0;
    static int b , n;
    static int[] i = new int[101] , j = new int[101] , nBasketTmp = new int[101] , nBasket = new int[101];
    static Map<Integer, String> map = Map.ofEntries(
            Map.entry(0, "0"),
            Map.entry(1, "1"),
            Map.entry(2, "2"),
            Map.entry(3, "3"),
            Map.entry(4, "4"),
            Map.entry(5, "5"),
            Map.entry(6, "6"),
            Map.entry(7, "7"),
            Map.entry(8, "8"),
            Map.entry(9, "9"),
            Map.entry(10, "A"),
            Map.entry(11, "B"),
            Map.entry(12, "C"),
            Map.entry(13, "D"),
            Map.entry(14, "E"),
            Map.entry(15, "F"),
            Map.entry(16, "G"),
            Map.entry(17, "H"),
            Map.entry(18, "I"),
            Map.entry(19, "J"),
            Map.entry(20, "K"),
            Map.entry(21, "L"),
            Map.entry(22, "M"),
            Map.entry(23, "N"),
            Map.entry(24, "O"),
            Map.entry(25, "P"),
            Map.entry(26, "Q"),
            Map.entry(27, "R"),
            Map.entry(28, "S"),
            Map.entry(29, "T"),
            Map.entry(30, "U"),
            Map.entry(31, "V"),
            Map.entry(32, "W"),
            Map.entry(33, "X"),
            Map.entry(34, "Y"),
            Map.entry(35, "Z")
    );
    static List<Integer> list = new ArrayList<>();
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
        b = Integer.parseInt(s1[1]);
    }
    public static void when() {
        for(int i=0; true; i++) {
            double d = Math.pow(b, i);
            // 10억 이하가 아니면 break;
            if(d <= 1000000000) {
                list.add((int)d);
            } else {
                break;
            }
        }

        int quotient = n;   // 몫
        int remainder;  // 나머지

        StringBuffer sb = new StringBuffer();
        for(int i=0; true; i++) {
            if(quotient == 0) break;

            sb.append(map.get(quotient%b));
            quotient = quotient/b;


        }
        if(n != 0) {
            sb.reverse();
            result = sb.toString();
        } else {
            result = "0";
        }
    }
    public static void then() {
        System.out.println(result);
    }
}
