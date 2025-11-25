package baekjoon.알고리즘_수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class 문제_24090 {
    // [2024-02-24 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, k, lastCnt;
    static int[] array = new int[10001];
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
        for(int i=1; i<=n; i++) {
            array[i] = Integer.parseInt(s2[i-1]);
        }
    }

    public static void when() {
        quick_sort(1, n);

//        System.out.println("array : " + array);

        if(sb.isEmpty()) {
            sb.append(-1);
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }

    public static void quick_sort(int left, int right) {
        // 인덱스는 right가 더 커야됨.
        if(left < right) {
            int mid = partition(left, right);   // 피벗을 기준으로 파티션을 나누기 위한 약한 정렬 메소드
            quick_sort(left, mid-1);
            quick_sort(mid+1, right);
        }
    }

    public static int partition(int left, int right) {
        int x = array[right];   // 기준원소
        int i = left -1;
        for(int j=left; j<right; j++) {
            // 앞에 원소가 없다면 array[j]는 서로 교환을 하게된다.
            // pivot보다 큰값에 대해 멈춰있던 포인터 <-> 이후에 나온 작은값에 대한 포인터
            if(array[j] <= x) {
                int tmp = array[++i];
                array[i] = array[j];
                array[j] = tmp;
                if(--k == 0) {
                    sb.append(array[i]).append(" ").append(array[j]);
                }
            }
        }

        // pivot보다 큰 값의 포인터 <-> pivot의 포인터
        if(i+1 != right) {
            int tmp = array[i+1];
            array[i+1] = array[right];
            array[right] = tmp;
            if(--k == 0) {
                sb.append(array[right]).append(" ").append(array[i+1]);
            }
        }
        return i+1;
    }
}
