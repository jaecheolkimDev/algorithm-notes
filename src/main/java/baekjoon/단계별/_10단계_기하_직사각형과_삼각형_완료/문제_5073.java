package baekjoon.단계별._10단계_기하_직사각형과_삼각형_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 문제_5073 {
    // [2024-03-01 JC]
    static StringBuffer sb = new StringBuffer();
    static int cnt = 1;
    static List<String> list1 = new ArrayList<>();
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

        while(true) {
            String s1 = br.readLine();
            if (s1.equals("0 0 0")) break;
            list1.add(s1);
        }
    }
    public static void when() {
        int size = list1.size();
        for(int i=0; i<size; i++) {
            String[] str = list1.get(i).split(" ");
            list2 = new ArrayList<>();
            for(int j=0; j<3; j++) {
                list2.add(Integer.parseInt(str[j]));
            }
            Collections.sort(list2);
            int a = list2.get(0);
            int b = list2.get(1);
            int c = list2.get(2);

            if(a + b <= c) {
                sb.append("Invalid").append("\n");
                continue;
            }
            if(a != b && b != c && c != a) {
                sb.append("Scalene").append("\n");
                continue;
            }
            if(a == b) {
                if(b == c) {
                    sb.append("Equilateral").append("\n");
                } else {
                    sb.append("Isosceles").append("\n");
                }
            } else if(b == c) {
                if(a == c) {
                    sb.append("Equilateral").append("\n");
                } else {
                    sb.append("Isosceles").append("\n");
                }
            } else if(c == a) {
                if(b == c) {
                    sb.append("Equilateral").append("\n");
                } else {
                    sb.append("Isosceles").append("\n");
                }
            }
        }
    }
    public static void then() {
        System.out.println(sb.toString());
    }
}

