package baekjoon.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class 문제_2212 {
    // [2024-03-08 JC]
    static StringBuffer sb = new StringBuffer();
    static int n,m, k;
    static List<Integer> list1 = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
    static List<Integer> list4 = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        given();// 테스트 실행을 준비하는 단계
        when(); // 테스트를 진행하는 단계
        then(); // 테스트 결과를 검증하는 단계
    }

    public static void given() throws IOException {
        InputStream is = System.in;						// 바이트
        InputStreamReader isr = new InputStreamReader(is);// 캐릭터
        BufferedReader br = new BufferedReader(isr);    // 스트링
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        String[] s1 = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            list1.add(Integer.parseInt(s1[i]));
        }
    }
    public static void when() {
        list2 = list1.stream().distinct().collect(Collectors.toList());
        Collections.sort(list2);

//        System.out.println(list2);

        int size = list2.size();
        for(int i=1; i<size; i++) {
            list3.add(list2.get(i) - list2.get(i-1));
        }
        Collections.sort(list3);
//        System.out.println(list3);
//        System.out.println(list3.size()-(k-1));
        int sizeList3 = list3.size();
        for(int i=0; i<sizeList3-(k-1); i++) {
            list4.add(list3.get(i));
        }
//        list4 = list3.subList(0, list3.size()-(k-1));
//        System.out.println(list4);

        int sum = 0;
        int sizeList4 = list4.size();
        for(int i=0; i<sizeList4; i++) {
            sum += list4.get(i);
        }
        sb.append(sum);
    }
    public static void then() {
        System.out.print(sb.toString());
    }
}