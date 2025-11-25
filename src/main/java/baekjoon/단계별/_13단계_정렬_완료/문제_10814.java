package baekjoon.단계별._13단계_정렬_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class 문제_10814 {
    // [2024-03-13 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, m;
    static List<CustomArray10> list2 = new ArrayList<>();
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
            list2.add(new CustomArray10(Integer.parseInt(s2[0]) , s2[1]));
        }
    }
    public static void when() {
        Collections.sort(list2);
//        System.out.println(list2);
        for(int i=0; i<list2.size(); i++) {
            sb.append(list2.get(i).getAge()).append(" ").append(list2.get(i).getName()).append("\n");
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}
class CustomArray10 implements Comparable<CustomArray10> {
    private int age;
    private String name;

    public CustomArray10(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(CustomArray10 o) {
        // [2024-03-13 JC : 나이 오름차순, 같으면 먼저 가입한 사람이 우선
        if(this.age < o.age) {
            return -1;
        } else if(this.age > o.age) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "CustomArray10{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    // [2024-03-12 JC : 객체 비교시 equals() , hashCode()를 필히 생성해주어야 한다.
    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    // [2024-03-12 JC : 객체 비교시 equals() , hashCode()를 필히 생성해주어야 한다.
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof CustomArray10))
            return false;
        CustomArray10 menu = (CustomArray10)o;
        return age == menu.age && Objects.equals(name, menu.name);
    }
}