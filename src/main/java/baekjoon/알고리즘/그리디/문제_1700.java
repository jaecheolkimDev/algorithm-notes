package baekjoon.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class 문제_1700 {
    // [2024-03-06 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, m, k, lastCnt;
    static List<Integer> list1 = new ArrayList<>();
    static int[] array1;
    static List<String> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
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
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);    // 5~500,000
        k = Integer.parseInt(s1[1]);    // 1~1억
        String[] s2 = br.readLine().split(" "); // 1~10억
        for(int i=1; i<=k; i++) {
            list1.add(Integer.parseInt(s2[i-1]));
        }
    }

    public static void when() {
        int cnt = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<k; i++) {
            int plug = list1.get(i);
            if(set.contains(plug)) continue;    // 이미 꽂힌 플러그는 꽂지 않는다.
            if(set.size() < n && set.add(plug)) continue;   // 플러그가 전부 꽂혀있지 않다면 플러그를 꽂는다.

            /**
             * 새로운 플러그를 꽂을때 무엇을빼고 꽂을지를 판단해야함.
             * 새로운 플러그라면 기존에 꽂혀져있지않은 플러그임.
             * 이후의 값들을 검사한다.
             * 이후의 값들에서 기존의 값을 포함하고 있나?
             * 이후의 값들에서 기존의 값을 포함하고 있지않나?
             */
            int max = -1, removePlug = -1;
            for(int s : set) {
                int tmp = 0;
                List<Integer> sub = list1.subList(i+1, k);
//                System.out.println("sub : " + sub);
                if(sub.contains(s)) {
                    tmp = sub.indexOf(s);   // 포함된 남아있는 값들중에 우선순위를 정할 수 있음.
                } else {
                    tmp = Integer.MAX_VALUE;    // 이후의 값에서 현재 넣으려는 값을 포함하고 있지 않으면, 무조건 해당하는걸 빼면됨.
                }
                if(tmp > max) {
                    max = tmp;
                    removePlug = s;
                }
            }
            cnt++;
            set.remove(removePlug);
            set.add(plug);
        }
        sb.append(cnt);
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}