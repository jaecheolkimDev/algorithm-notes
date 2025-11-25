package baekjoon.단계별._13단계_정렬_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 문제_11651 {
    // [2024-03-12 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, m;
    static List<CustomArray8> list2 = new ArrayList<>();
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
        for(int i=0; i<n; i++) {
            String[] s2 = br.readLine().split(" ");
            list2.add(new CustomArray8(Integer.parseInt(s2[0]) , Integer.parseInt(s2[1])));
        }
    }
    public static void when() {
        Collections.sort(list2);
//        System.out.println(list2);

        for(int i=0; i<list2.size(); i++) {
            sb.append(list2.get(i).getA()).append(" ").append(list2.get(i).getB()).append("\n");
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}
class CustomArray8 implements Comparable<CustomArray8> {
    private int a;
    private int b;

    public CustomArray8(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public int compareTo(CustomArray8 o) {
        // [2024-03-12 JC : B 오름차순 같으면 A 오름차순.
        if(this.b < o.b) {
            return -1;
        } else if(this.b > o.b) {
            return 1;
        } else {
            if (this.a < o.a) {
                return -1;
            } else if(this.a == o.a) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    @Override
    public String toString() {
        return "CustomArray8{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}