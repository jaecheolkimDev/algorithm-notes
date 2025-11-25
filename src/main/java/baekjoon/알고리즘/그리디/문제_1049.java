package baekjoon.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 문제_1049 {
    // [2024-03-01 JC]
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
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        m = Integer.parseInt(s1[1]);
        for(int i=1; i<=m; i++) {
            String[] s2 = br.readLine().split(" ");
            list1.add(Integer.parseInt(s2[0]));
            list2.add(Integer.parseInt(s2[1]));
        }
    }
    public static void when() {
        Collections.sort(list1);
        Collections.sort(list2);
//        System.out.println(list1);
//        System.out.println(list2);

        int min6 = list1.get(0);
        int min1 = list2.get(0);

        int sum = 0;
        // 1개짜리 6개 사는게 더 비쌀때.
        if(min1*6 > min6) {
            // 6으로 나눈 나머지가 더 쌀때.
            if ((n % 6) * min1 < min6) {
                sum += ((n/6 * min6) + (n%6 * min1));
            }
            // 6으로 나눈 나머지가 더 비쌀때.
            else {
                // 6으로 나눈 몫이 존재할때.
                if(n/6 > 0) {
                    sum += ((n / 6 + 1) * min6);
                }
                // 6으로 나눈 몫이 존재하지 않을때.
                else {
                    sum += min6;
                }
            }
        }
        // 1개짜리 6개 사는게 더 쌀때.
        else {
            sum += (n * min1);
        }

        sb.append(sum);
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}
