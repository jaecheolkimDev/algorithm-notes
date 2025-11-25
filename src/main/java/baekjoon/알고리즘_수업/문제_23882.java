package baekjoon.알고리즘_수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 문제_23882 {
    // [2024-02-24 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, k;
    static int[] array = new int[10001];
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
            array[i] = Integer.parseInt(s2[i-1]);
        }
    }

    public static void when() {
        /**
         * 1. 최대값을 찾고
         * 2. 최대값의 위치가 마지막이 아니면 마지막과 교환한다.
         * 3. 맨 마지막을 빼고,,,,, 1~2 반복
         * 4. 전부 교환하고 맨 앞에 1이 남으면 끝.
         */
        int lastCnt = 0;
        int size = n;
        for(int i=size; i>0; i--) {
            int max = array[i];
            int maxIndex = i;
            for(int j=size-1; j>0; j--) {
                if(max < array[j]) {
                    max = array[j];
                    maxIndex = j;
                }
            }

            if(maxIndex != i) {
                lastCnt++;
                int temp = array[i];
                array[maxIndex] = temp;
                array[i] = max;
                if(k == lastCnt) {
                    for(int j=1; j<=n; j++) {
                        sb.append(array[j]).append(" ");
                    }
                    break;
                }
            }
            size--;
        }

        if(sb.isEmpty()) {
            sb.append(-1);
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}
