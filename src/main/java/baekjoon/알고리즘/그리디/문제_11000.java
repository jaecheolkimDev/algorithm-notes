package baekjoon.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 문제_11000 {
    // [2024-03-03 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, m;
    static int[][] array;
    static List<Integer> list2 = new ArrayList<>();
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
        n = Integer.parseInt(s1);    // 칭호
        array = new int[n][2];
        for(int i=0; i<n; i++) {
            String[] s2 = br.readLine().split(" ");
            array[i][0] = Integer.parseInt(s2[0]);
            array[i][1] = Integer.parseInt(s2[1]);
        }
    }
    public static void when() {
        Arrays.sort(array, (o1, o2) -> {
//			return o1[0]!=o2[0] ? o1[0]-o2[0] : o1[1]-o2[1];  // 아래와 같은 오름차순,오름차순 연계 정렬 방법.
            if (o1[0] < o2[0]) {
                return -1;  // 시작시간 오름차순.
            } else if (o1[0] > o2[0]) {
                return 1;
            }
            // 시작시간이 같으면.
            else {
                if (o1[1] < o2[1]) {
                    return -1;  // 끝시간 오름차순.
                } else if (o1[1] > o2[1]) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
//        System.out.println(Arrays.deepToString(array));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++) {
            if(!pq.isEmpty()) {
                if(pq.peek() <= array[i][0]) {
                    pq.poll();
                }
            }

            pq.offer(array[i][1]);
        }

        sb.append(pq.size());
    }

    public static void then() {
        System.out.println(sb.toString());
    }

}