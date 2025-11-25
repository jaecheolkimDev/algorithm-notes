package baekjoon.단계별._4단계_1차원_배열_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 문제_10811 {
    // [2023-12-10 JC]
    static int result = 0;
    static int tot = 0;
    static int n,m;
    static int[] i = new int[101] , j = new int[101] , nBasketTmp = new int[101] , nBasket = new int[101];
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
        n = Integer.parseInt(s1[0]); // 바구니의 총 갯수
        m = Integer.parseInt(s1[1]); // 바구니의 순서를 역순으로 바꾸는 횟수
        for(int ii=0; ii<m; ii++) {
            String[] s2 = br.readLine().split(" ");
            i[ii+1] = Integer.parseInt(s2[0]);  // i번바구니부터 j번바구니까지의 순서를 역순으로 바꾼다.
            j[ii+1] = Integer.parseInt(s2[1]);
        }
        for(int ii=0; ii<n; ii++) {
            nBasket[ii+1] = ii+1;
        }
    }
    public static void when() {
        for(int ii=0; ii<m; ii++) {
            nBasketTmp = nBasket.clone();
            int a = j[ii+1];
            for(int jj=i[ii+1]; jj<=j[ii+1]; jj++) {
                nBasket[jj] = nBasketTmp[a--];
            }
        }
    }
    public static void then() {
        for(int ii=0; ii<n; ii++) {
            System.out.print(nBasket[ii+1] + " ");
        }
    }
}
