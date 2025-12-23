package baekjoon.basic.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class modularArithmetic {
    // [2025-12-17 JC : 문제의 예제로 인한 함정으로 헤메다가 해설보고 품 ]
    /**
     * 피보나치 수열
     * 첫 항 : 1
     * 두번째 항 : 1
     * 세번째 항 이후 : 이전 2개항의 합
     */
    static StringBuffer sb = new StringBuffer();
    static int[] N, M;
    static int P;
    static long[] fibonacci;
    static int[] pisanoPeriod = new int[1_000_001];
    static List<Integer> list2 = new ArrayList<>();
    static long period = 1_500_000;
    public static void main(String[] args) throws IOException {
        given();// 테스트 실행을 준비하는 단계
        when(); // 테스트를 진행하는 단계
        then(); // 테스트 결과를 검증하는 단계
    }

    public static void given() throws IOException {
        InputStream is = System.in;						// 바이트
        InputStreamReader isr = new InputStreamReader(is);// 캐릭터
        BufferedReader br = new BufferedReader(isr);    // 스트링
        String s1 = br.readLine();
        P = Integer.parseInt(s1);
        N = new int[P];
        M = new int[P];
        for(int i=0; i<P; i++) {
            String[] s2 = br.readLine().split(" ");
            N[i] = Integer.parseInt(s2[0]);
            M[i] = Integer.parseInt(s2[1]);
        }
    }
    public static void when() {

        // 테스트 케이스 갯수
        for(int i=0; i<P; i++) {
            int cnt = 0, previous, current;
            previous = current = 1;
            while(true) {
                /**
                 * 모듈러 연산 : (A + B) % M 는 ((A % M) + (B % M)) % M 와 같다.
                 * 피보나치 수를 직접적으로 사용하지 않고 연산.
                 * 피보나치 수열에서 다음 항을 계산할 때, 이전 두 항의 합을 구한 후 M으로 나누는 것은,
                 * 이전 두 항 각각을 M으로 나눈 나머지의 합을 M으로 나눈 것과 동일한다.
                 */
                int tmp = (previous+current) % M[i];
                previous = current;  // 첫번째
                current = tmp;// 두번째
                cnt++;  // 건ㅅ

                if(previous == 1 && current == 1) break;
            }
            sb.append(N[i]).append(" ").append(cnt).append("\n");
        }


        // 같음
        // = N번째 피보나치 수를 M으로 나눈 나머지
        // = N%P번째 피보나치 수를 M으로 나눈 나머지
    }

    public static void then() {
        System.out.println(sb.toString());
    }


}