package baekjoon.단계별._18단계_심화_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 문제_20920 {
    // [2025-12-08 JC]
    static StringBuffer sb = new StringBuffer();
    static int N, M;
    static List<String> list1 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
    static String[][] WORD;
    static String[] ARR;
    static Map<String, Integer> frequencyMap = new HashMap<>();
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
        N = Integer.parseInt(s1[0]);
        M = Integer.parseInt(s1[1]);
        for(int i=0; i<N; i++) {
            String s2 = br.readLine();
            if(s2.length() < M) continue;
            list1.add(s2);
        }
    }
    public static void when() {
        // 빈도수 저장
        for(String s : list1) {
            frequencyMap.put(s, frequencyMap.getOrDefault(s, 0) + 1);
        }

        // 중복제거
        List<String> list2 = list1.stream().distinct().collect(Collectors.toList());
        Collections.sort(list2, (a, b) -> {
            int freqCompare = frequencyMap.get(b).compareTo(frequencyMap.get(a));
            if(freqCompare != 0) {
                return freqCompare; // 빈도 기준 내림차순
            } else {
                if(a.length() != b.length()) {
                    return Integer.compare(b.length(), a.length());
                } else {
                    return a.compareTo(b);  // 빈도 같으면 값 기준 오름차순
                }
            }
        });

        for(String s : list2) {
            sb.append(s).append("\n");
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}
