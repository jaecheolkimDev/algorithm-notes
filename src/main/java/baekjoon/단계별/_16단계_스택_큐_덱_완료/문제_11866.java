package baekjoon.단계별._16단계_스택_큐_덱_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 문제_11866 {
    // [2024-03-15 JC]
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
    }

    public static void when() {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            q.add(i);
        }
        int cnt = 0;
        sb.append("<");
        while(!q.isEmpty() && q.size() != 1) {
            if(++cnt % k == 0) {
                sb.append(q.poll()).append(", ");
            } else {
                q.add(q.poll());
            }
        }
        sb.append(q.poll()).append(">");
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}