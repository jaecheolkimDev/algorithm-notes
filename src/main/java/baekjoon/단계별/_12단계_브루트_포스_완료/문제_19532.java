package baekjoon.단계별._12단계_브루트_포스_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 문제_19532 {
    // [2024-03-12 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, k, m, a, b, c, d, w, h, A,B,C,D,E,F;
    static List<Integer> list2 = new ArrayList<>();
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
        A = Integer.parseInt(s1[0]);
        B = Integer.parseInt(s1[1]);
        C = Integer.parseInt(s1[2]);
        D = Integer.parseInt(s1[3]);
        E = Integer.parseInt(s1[4]);
        F = Integer.parseInt(s1[5]);
    }
    public static void when() {
        for(int i = -999; i <= 999; i++) {
            for(int j = -999; j <= 999; j++) {
                if(A*i + B*j  == C && D*i + E*j  == F){
                    sb.append(i).append(" ").append(j);
                    break;
                }
            }
        }

        // [2024-03-12 JC : 가우스소거법으로 아래와 같이 쉽게 해결 할 수 있다.]
//        sb.append( (C*E - B*F) / (A*E - B*D) ).append(" ").append( (C*D - A*F) / (B*D - A*E) );
    }

    public static void then() {
        System.out.println(sb.toString());
    }

}