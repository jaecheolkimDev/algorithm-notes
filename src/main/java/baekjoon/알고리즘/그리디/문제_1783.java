package baekjoon.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 문제_1783 {
    // [2024-03-08 JC]
    static StringBuffer sb = new StringBuffer();
    static int n,m, k;
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
        n = Integer.parseInt(s1[0]);
        m = Integer.parseInt(s1[1]);
    }
    public static void when() {
        int sum = 1;
        if(n <= 2) {
            if(m <= 6) {
                sum += (m-1)/2;
            } else {
                sum += 3;
            }
        } else {
            if(m == 1) {
            }
            // 1개의 이동방법만 써도됨.
            else if(m <= 4){
                sum += (m-1);
            }
            // 모든 방법을 1번씩 써야함.
            else if(m <= 7){
                sum += (2 + (m-3)/2);
            }
            // 모든 방법을 1번이상쓰고 나머진 최대로.
            else {
                sum += (m-3);
            }
        }
        sb.append(sum);
    }
    public static void then() {
        System.out.print(sb.toString());
    }
}