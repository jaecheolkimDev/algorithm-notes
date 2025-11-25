package baekjoon.단계별._13단계_정렬_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class 문제_1181 {
    // [2024-03-12 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, m;
    static List<CustomArray9> list2 = new ArrayList<>();
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
            String s2 = br.readLine();
            list2.add(new CustomArray9(s2));
        }
    }
    public static void when() {
        // [2024-03-12 JC : 이미 정렬을 하였으니, for문을 돌면서 중복을 걸러도 상관없다.]
        Collections.sort(list2);
        list2 = list2.stream().distinct().collect(Collectors.toList());
//        System.out.println(list2);
        for(int i=0; i<list2.size(); i++) {
            sb.append(list2.get(i).getA()).append("\n");
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}
class CustomArray9 implements Comparable<CustomArray9> {
    private String a;

    public CustomArray9(String a) {
        this.a = a;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    @Override
    public int compareTo(CustomArray9 o) {
        // [2024-03-12 JC : 길이가 짧은 것부터 , 길이가 같으면 사전 순으로
        if(this.a.length() < o.a.length()) {
            return -1;
        } else if(this.a.length() > o.a.length()) {
            return 1;
        } else {
            if (this.a.compareTo(o.a) < 0) {
                return -1;
            } else if(this.a.compareTo(o.a) == 0) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    @Override
    public String toString() {
        return "CustomArray9{" +
                "a=" + a +
                '}';
    }

    // [2024-03-12 JC : 객체 비교시 equals() , hashCode()를 필히 생성해주어야 한다.
    @Override
    public int hashCode() {
        return Objects.hash(a);
    }

    // [2024-03-12 JC : 객체 비교시 equals() , hashCode()를 필히 생성해주어야 한다.
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof CustomArray9))
            return false;
        CustomArray9 menu = (CustomArray9)o;
        return Objects.equals(a, menu.a);
    }
}