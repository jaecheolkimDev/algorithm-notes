package baekjoon.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class 문제_1946 {
    // [2024-02-26 JC]
    static StringBuffer sb = new StringBuffer();
    static int t, n, m, k, lastCnt;
    static List<Integer> list1 = new ArrayList<>();
    static int[] array1;
    static List<CustomArray5> list2;
    static List<Integer> list3 = new ArrayList<>();
    static Map<Integer, List<CustomArray5>> map1= new HashMap<>();
    static int[] array3;
    static List<Integer> sorted = new LinkedList<>();
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
        t = Integer.parseInt(s1);    // 5~500,000
        for(int i=0; i<t; i++) {
            String s2 = br.readLine();
            list1.add(Integer.parseInt(s2));
            list2 = new ArrayList<>();
            for(int j=0; j<list1.get(i); j++) {
                String[] s3 = br.readLine().split(" ");
                list2.add(new CustomArray5(Integer.parseInt(s3[0]), Integer.parseInt(s3[1])));
            }
            map1.put(i, list2);
        }
    }

    public static void when() {
        for(int z=0; z<t; z++) {
            List<CustomArray5> customArray = map1.get(z);
            int size = customArray.size();

            Collections.sort(customArray);

//            System.out.println("map1.get(z) : " + customArray);
            int pass = 1;
            int passTest2 = customArray.get(0).getTest2();
            for(int y=1; y<size; y++) {
                if(customArray.get(y).getTest2() < passTest2) {
                    pass++;
                    passTest2 = customArray.get(y).getTest2();
                }
            }
            sb.append(pass).append("\n");
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}
class CustomArray5 implements Comparable<CustomArray5> {
    private int test1;
    private int test2;

    public CustomArray5(int test1, int test2) {
        this.test1 = test1;
        this.test2 = test2;
    }

    @Override
    public int compareTo(CustomArray5 o) {
        if(this.test1 < o.test1) {
            return -1;
        } else {
            return 1;
        }
    }

    public int getTest1() {
        return test1;
    }

    public void setTest1(int test1) {
        this.test1 = test1;
    }

    public int getTest2() {
        return test2;
    }

    public void setTest2(int test2) {
        this.test2 = test2;
    }

    @Override
    public String toString() {
        return "CustomArray5{" +
                "test1=" + test1 +
                ", test2=" + test2 +
                '}';
    }
}