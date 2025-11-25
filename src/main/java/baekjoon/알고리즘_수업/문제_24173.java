package baekjoon.알고리즘_수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class 문제_24173 {
    // [2024-02-15 JC]
    /**
     * 최소 힙 기반 힙 정렬
     *
     * 힙 : 최댓값 혹은 최솟값을 빠르게 찾기 위한 자료구조
     *
     * 최대 힙을 만들면(최상위 노드는 최댓값을 갖고 있음) -> 최상위 노드를 배열의 뒤로 보내고 다시 heapify() -> 가장 작은값으로 최상위노드부터 채워짐. -> 오름차순 정렬
     * 최소 힙을 만들면(최상위 노드는 최솟값을 갖고 있음) -> 최상위 노드를 배열의 뒤로 보내고 다시 heapify() -> 가장 큰 값으로 최상위노드부터 채워짐. -> 내림차순 정렬
     */
    static StringBuffer sb = new StringBuffer();
    static int n, k, lastCnt;
    static List<Integer> list2 = new LinkedList<>();
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
            list2.add(Integer.parseInt(s2[i-1]));
        }
    }

    public static void when() {
        heap_sort(1, n);


        if(sb.isEmpty()) {
            sb.append(-1);
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }

    public static void heap_sort(int left, int right) {
        build_min_heap(right);
        for(int i=right; i>0; i--) {
            int tmp = list2.get(i-1);
            list2.set(i-1, list2.get(left-1));
            list2.set(left-1, tmp);
            if(list2.get(i-1) != list2.get(left-1)) {
                lastCnt++;
                solve(list2.get(i - 1), list2.get(left - 1));
            }
            // 최상위 노드를 제외한 부분 트리에 대해 힙을 만족하도록 재구성한다.
            heapify(left, i-1);
        }
    }

    public static void build_min_heap(int right) {
        for(int i=right/2; i>0; i--) {
            heapify(i, right);
        }
    }

    /**
     * heapify()를 호출하는 배열을 루트로 하는 트리를 최소 힙 성질을 만족하도록 수정한다.
     * n은 배열 A의 전체 크기이며 최대 인덱스를 나타낸다.
     * 최소 힙 성질을 만족해야한다.(최소 힙 성질 = 부모의 값이 더 작아야 된다.)
     *
     * 힙 상태를 만드는 함수.
     *
     */
    public static void heapify(int k, int n) {
        int left = 2*k;
        int right = 2*k + 1;
        int smaller;
        if(right <= n) {
            if(list2.get(left-1) < list2.get(right-1)) {
                smaller = left;
            } else {
                smaller = right;
            }
        } else if(left <= n) {
            smaller = left;
        } else {
            return;
        }

        /**
         * 최소 힙 성질을 만족하지 못하는 경우 재귀적으로 수정한다.
         * 최소 힙 성질 = 부모의 값이 더 작아야 된다.
         * = 부모의 값이 더 작지 않다면 위치를 바꾸고, 재귀를 통해 다시 수행한다.
         */
        if(list2.get(smaller-1) < list2.get(k-1)) {
            int tmp = list2.get(k-1);
            list2.set(k-1, list2.get(smaller-1));
            list2.set(smaller-1, tmp);
            lastCnt++;
            solve(list2.get(smaller-1), list2.get(k-1));
            heapify(smaller, n);
        }
    }

    public static void solve(int a, int b) {
        if(lastCnt == k) {
            sb.append(a).append(" ").append(b);
        }
    }
}
