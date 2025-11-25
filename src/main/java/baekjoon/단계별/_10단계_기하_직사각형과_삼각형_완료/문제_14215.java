package baekjoon.단계별._10단계_기하_직사각형과_삼각형_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 문제_14215 {
    // [2024-02-25 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, k, m, a, b, c, d;
    static List<Integer> list1 = new ArrayList<>();
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
        a = Integer.parseInt(s1[0]);
        b = Integer.parseInt(s1[1]);
        c = Integer.parseInt(s1[2]);
    }
    public static void when() {
        list1.add(a);
        list1.add(b);
        list1.add(c);
        while(true) {
            Collections.sort(list1);
            if (list1.get(0) + list1.get(1) <= list1.get(2)) {
                list1.set(2, list1.get(0) + list1.get(1) - 1);
            } else break;
        }
        sb.append(list1.get(0) + list1.get(1) + list1.get(2));
    }

    public static void then() {
        System.out.println(sb.toString());
    }

}