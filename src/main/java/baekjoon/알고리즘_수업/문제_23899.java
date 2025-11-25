package baekjoon.알고리즘_수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 문제_23899 {
    // [2024-02-24 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, k;
    static int[] array1 = new int[10001];
    static int[] array2 = new int[10001];
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
        String[] s2 = br.readLine().split(" ");
        for(int i=1; i<=n; i++) {
            array1[i] = Integer.parseInt(s2[i-1]);
        }
        String[] s3 = br.readLine().split(" ");
        for(int i=1; i<=n; i++) {
            array2[i] = Integer.parseInt(s3[i-1]);
        }
    }

    public static void when() {
        /**
         * 1. 최대값을 찾고
         * 2. 최대값의 위치가 마지막이 아니면 마지막과 교환한다.
         * 3. 맨 마지막을 빼고,,,,, 1~2 반복
         * 4. 전부 교환하고 맨 앞에 1이 남으면 끝.
         */
        int size = n;
        for(int i=size; i>0; i--) {

            if(Arrays.equals(array1 , array2)) {
                sb.append(1);
                break;
            }

            int max = array1[i];
            int maxIndex = i;
            for(int j=size-1; j>0; j--) {
                if(max < array1[j]) {
                    max = array1[j];
                    maxIndex = j;
                }
            }

            if(maxIndex != i) {
                int temp = array1[i];
                array1[maxIndex] = temp;
                array1[i] = max;

                if(Arrays.equals(array1 , array2)) {
                    sb.append(1);
                    break;
                }
            }
            size--;
        }

        if(sb.isEmpty()) {
            sb.append(0);
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}
