package baekjoon.단계별._9단계_약수_배수와_소수_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 문제_5086 {
    // [2024-03-10 JC]
    static StringBuffer sb = new StringBuffer();
    static String result;
    static int tot = 0;
    static int m, cnt=1;
    static int[][] arrTwoDimensions = new int[2][10001];
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

        while(true) {
            String s1 = br.readLine();
            if (s1.equals("0 0")) break;
            String[] s2 = s1.split(" ");
            arrTwoDimensions[0][cnt] = Integer.parseInt(s2[0]);
            arrTwoDimensions[1][cnt] = Integer.parseInt(s2[1]);
            cnt++;
        }
    }
    public static void when() {
//        System.out.println(cnt-1);

        for(int i=1; i<cnt; i++) {
            if(arrTwoDimensions[1][i] % arrTwoDimensions[0][i] == 0) {
                sb.append("factor").append("\n");
            } else if(arrTwoDimensions[0][i] % arrTwoDimensions[1][i] == 0) {
                sb.append("multiple").append("\n");
            } else {
                sb.append("neither").append("\n");
            }
        }
    }
    public static void then() {
        System.out.println(sb.toString());
    }
}
