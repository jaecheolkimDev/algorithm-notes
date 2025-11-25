package baekjoon.단계별._11단계_시간_복잡도_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 문제_24313 {
    // [2024-03-11 JC]
    static StringBuffer sb = new StringBuffer();
    static int n,m, k, A1, A0, C, N0;
    static int s, result;
    static int[] x;
    static Boolean[] streetLamp;
    static List<Integer> list1 = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
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
        A1 = Integer.parseInt(s1[0]);
        A0 = Integer.parseInt(s1[1]);
        String s2 = br.readLine();
        C = Integer.parseInt(s2);
        String s3 = br.readLine();
        N0 = Integer.parseInt(s3);
    }
    public static void when() {
        if(A0 <= (C-A1) * N0 && C>=A1) {
            sb.append(1);
        } else {
            sb.append(0);
        }
    }
    public static void then() {
        System.out.print(sb.toString());
    }
}