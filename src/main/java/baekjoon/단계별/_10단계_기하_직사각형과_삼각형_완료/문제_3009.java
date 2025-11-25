package baekjoon.단계별._10단계_기하_직사각형과_삼각형_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 문제_3009 {
    // [2024-03-10 JC]
    static StringBuffer sb = new StringBuffer();
    static String result;
    static int tot = 0;
    static int m, cnt=1;
    static int[][] arrTwoDimensions = new int[2][3];
    static int max = 0;
    static String location = "1 1";
    public static void main(String[] args) throws IOException {
        given();// 테스트 실행을 준비하는 단계
        when(); // 테스트를 진행하는 단계
        then(); // 테스트 결과를 검증하는 단계
    }

    public static void given() throws IOException {
        InputStream is = System.in;						// 바이트
        InputStreamReader isr = new InputStreamReader(is);// 캐릭터
        BufferedReader br = new BufferedReader(isr);    // 스트링

        for(int i=0; i<3; i++) {
            String[] s1 = br.readLine().split(" ");
            arrTwoDimensions[0][i] = Integer.parseInt(s1[0]);
            arrTwoDimensions[1][i] = Integer.parseInt(s1[1]);
        }
    }
    public static void when() {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int i=0; i<arrTwoDimensions[0].length; i++) {
            map1.put(arrTwoDimensions[0][i], map1.getOrDefault(arrTwoDimensions[0][i], 0) + 1);
            map2.put(arrTwoDimensions[1][i], map2.getOrDefault(arrTwoDimensions[1][i], 0) + 1);
        }
        for(Integer num1 : map1.keySet()) {
            if(map1.get(num1) == 1) {
                sb.append(num1).append(" ");
            }
        }
        for(Integer num2 : map2.keySet()) {
            if(map2.get(num2) == 1) {
                sb.append(num2);
            }
        }
    }
    public static void then() {
        System.out.println(sb.toString());
    }
}
