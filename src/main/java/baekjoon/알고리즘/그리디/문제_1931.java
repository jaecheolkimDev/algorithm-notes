package baekjoon.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 문제_1931 {
    // [2024-02-25 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, m;
    static List<CustomArray> list1 = new ArrayList<>();
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
        n = Integer.parseInt(s1);    // 칭호
        for(int i=1; i<=n; i++) {
            String[] s2 = br.readLine().split(" ");
            CustomArray ca = new CustomArray(Integer.parseInt(s2[0]), Integer.parseInt(s2[1]));
            list1.add(ca);
        }
    }
    public static void when() {
        Collections.sort(list1);
//        System.out.println(list1);

        int cnt = 0;
        int prev = 0;
        for(int i=0; i<n; i++) {
            CustomArray ca = list1.get(i);
            if(prev <= ca.getA()) {
                prev = ca.getB();
                cnt++;
            }
        }
        sb.append(cnt);
    }

    public static void then() {
        System.out.println(sb.toString());
    }

}

class CustomArray implements Comparable<CustomArray> {
    private int a;
    private int b;

    public CustomArray(int a, int b) {
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
    public int compareTo(CustomArray o) {
        if(this.b < o.b) {
            return -1;
        } else if(this.b > o.b) {
            return 1;
        } else {
            if (this.a <= o.a) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    @Override
    public String toString() {
        return "CustomArray{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}