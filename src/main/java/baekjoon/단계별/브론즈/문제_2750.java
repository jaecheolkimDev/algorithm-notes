package baekjoon.단계별.브론즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 문제_2750 {
    // [2024-01-22 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, m;
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
        String s1 = br.readLine();
        n = Integer.parseInt(s1);
        for(int i=1; i<=n; i++) {
            String s2 = br.readLine();
            list1.add(Integer.parseInt(s2));
        }
    }
    public static void when() {
        list1.sort(Comparator.naturalOrder());  // 오름차순
    }

    public static void then() {
        for(Integer l : list1) {
            System.out.println(l);
        }
    }
}
