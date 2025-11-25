package baekjoon.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 문제_4796 {
    // [2024-03-01 JC]
    static StringBuffer sb = new StringBuffer();
    static int tot = 0;
    static List<CustomArray6> list1 = new ArrayList<>();
    static String[] tString = new String[100] , tResult = new String[100];
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
            String[] s2 = s1.split(" ");
            list1.add(new CustomArray6(Integer.parseInt(s2[0]) , Integer.parseInt(s2[1]) , Integer.parseInt(s2[2])));
        }
    }
    public static void when() {
//        System.out.println(list1);

        int size = list1.size();
        for(int i=0; i<size; i++) {
            CustomArray6 ca6 = list1.get(i);
            int l = ca6.getL();
            int p = ca6.getP();
            int v = ca6.getV();
            int ans = 0;
            if(v%p > l) {
                ans = ((v/p * l) + l);
            } else {
                ans = ((v/p * l) + (v%p));
            }
            sb.append("Case ").append(i+1).append(": ").append(ans).append("\n");
        }
    }
    public static void then() {
        System.out.println(sb.toString());
    }
}

class CustomArray6 {
    private int l;
    private int p;
    private int v;

    public CustomArray6(int l, int p, int v) {
        this.l = l;
        this.p = p;
        this.v = v;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "CustomArray6{" +
                "l=" + l +
                ", p=" + p +
                ", v=" + v +
                '}';
    }
}