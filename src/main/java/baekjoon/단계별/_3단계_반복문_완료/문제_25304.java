package baekjoon.단계별._3단계_반복문_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 문제_25304 {
    // [2023-12-09 JC]
    static String result = "";
    static int tot = 0;
    static int x,n;
    static int[] a = new int[101], b = new int[101];
    public static void main(String[] args) throws IOException {
        given();// 테스트 실행을 준비하는 단계
        when(); // 테스트를 진행하는 단계
        then(); // 테스트 결과를 검증하는 단계
    }

    public static void given() throws IOException {
        InputStream is = System.in;						// 바이트
        InputStreamReader isr = new InputStreamReader(is);// 캐릭터
        BufferedReader br = new BufferedReader(isr);    // 스트링
        x = Integer.parseInt(br.readLine());    // 총 금액
        n = Integer.parseInt(br.readLine());    // 영수증에 적힌 구매한 물건의 종류와 수
        for(int i=0; i<n; i++) {
            String[] s = br.readLine().split(" ");
            a[i+1] = Integer.parseInt(s[0]);    // 각 물건의 가격
            b[i+1] = Integer.parseInt(s[1]);    // 각 물건의 개수
        }
    }
    public static void when() {
        for(int i=0; i<n; i++) {
            tot += a[i+1] * b[i+1];    // 각 물건의 개수
        }
        if(x == tot) {
            result = "Yes";
        } else {
            result = "No";
        }
    }
    public static void then() {
        System.out.println(result);
    }
}
