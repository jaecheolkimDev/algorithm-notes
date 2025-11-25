package baekjoon.단계별._16단계_스택_큐_덱_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class 문제_28279 {
    // [2024-03-15 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, m;
    static Map<String, String> map1 = new HashMap<>();
    static List<Integer> list1 = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();
    static Set<Integer> set1 = new HashSet<>();
    static String[] arr1;
    static int[] arr2;
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
        arr1 = new String[n];
        for(int i=0; i<n; i++) {
            String s2 = br.readLine();
            arr1[i] = s2;
        }
    }
    public static void when() {
        Deque<String > deq = new LinkedList<>();
        for(int i=0; i<n; i++) {
            String[] str = arr1[i].split(" ");
            if(str.length == 2) {
                String gubun = str[0];
                if("1".equals(gubun)) {
                    deq.addFirst(str[1]);
                } else if("2".equals(gubun)) {
                    deq.addLast(str[1]);
                }
            } else {
                String val = str[0];
                if("3".equals(val)) {
                    if(deq.size() != 0) {
                        sb.append(deq.pollFirst()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                } else if("4".equals(val)) {
                    if(deq.size() != 0) {
                        sb.append(deq.pollLast()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                } else if("5".equals(val)) {
                    sb.append(deq.size()).append("\n");
                } else if("6".equals(val)) {
                    if(deq.size() != 0) {
                        sb.append(0).append("\n");
                    } else {
                        sb.append(1).append("\n");
                    }
                } else if("7".equals(val)) {
                    if(deq.size() != 0) {
                        sb.append(deq.peekFirst()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                } else if("8".equals(val)) {
                    if(deq.size() != 0) {
                        sb.append(deq.peekLast()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                }
            }
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}