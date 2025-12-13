package baekjoon.단계별._19단계_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 문제_24060 {
    // [2024-01-26 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, k, lastCnt;
    static List<Integer> list2 = new ArrayList<>();
    static List<Integer> sorted = new ArrayList<>();
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
        merge_sort(0, n-1);

        if(sb.isEmpty()) {
            sb.append(-1);
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }

    public static void merge_sort(int left, int right) {
        /**
         * 요소가 하나도 없거나 하나만 있는 하위 배열은 이미 정렬되어 있는 것과 같습니다.
         * 아래 조건에 해당할 때만 분할정복 과정을 거칩니다.
         */
        if(left < right) {
            int mid = (left+right)/2;
            merge_sort(left, mid);
            merge_sort(mid+1, right);
            merge(left, mid, right);
        }
    }

    public static void merge(int left, int mid, int right) {
        sorted = new ArrayList<>();

        /**
         * 1.좌 우 비교. 비교대상을 좌우 1:1 비교. 좌우측 비교대상이 정렬될때까지만 수행. (작은값을 우선 정렬하는 프로세스)
         * 나머진 정렬된 상태니깐 다음 프로세스에서 남은값 추가하면 됨.
         */
        int i = left;
        int j = mid+1;
        int t = 0;
        while(i<=mid && j<=right) {
            if(list2.get(i) <= list2.get(j)) {
                sorted.add(t++, list2.get(i++));
            } else {
                sorted.add(t++, list2.get(j++));
            }
            if(++lastCnt == k) sb.append(sorted.get(t-1));
        }

        // 2.좌 우 비교 대상이 없을 경우. 남은값 추가.(좌우를 비교해서 이미 정렬이 되었으니 나머지 추가하면됨.)
        // 2-1.좌측에서 남은것 추가.
        while(i <= mid) {
            sorted.add(t++, list2.get(i++));
            if(++lastCnt == k) sb.append(sorted.get(t-1));
        }
        // 2-2.우측에서 남은것 추가.
        while(j <= right) {
            sorted.add(t++, list2.get(j++));
            if(++lastCnt == k) sb.append(sorted.get(t-1));
        }

        // 3.결과 저장
        i = left;
        t = 0;
        while(i <= right) {
            list2.set(i++, sorted.get(t++));
        }
    }
}
