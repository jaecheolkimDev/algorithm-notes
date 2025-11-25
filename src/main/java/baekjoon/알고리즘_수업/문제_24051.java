package baekjoon.알고리즘_수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 문제_24051 {
    // [2024-01-25 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, k;
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
        k = Integer.parseInt(s1[1]);
        String[] s2 = br.readLine().split(" ");
        for(int i=1; i<=n; i++) {
            list2.add(Integer.parseInt(s2[i-1]));
        }
    }

    public static void when() {
        int lastCnt = 0;
        int size = list2.size();
        for(int i=1; i<size; i++) {
            int loc = i - 1;
            int newItem = list2.get(i);
            while(0 <= loc && newItem < list2.get(loc)) {
                list2.set(loc+1, list2.get(loc));
                lastCnt++;
                if(k == lastCnt) {
                    sb.append(list2.get(loc));
                    break;
                }
                loc--;
            }
            if(loc +1 != i) {
                list2.set(loc+1, newItem);

                lastCnt++;
                if(k == lastCnt) {
                    sb.append(list2.get(loc+1));
                    break;
                }
            }
        }

        if(sb.isEmpty()) {
            sb.append(-1);
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}
