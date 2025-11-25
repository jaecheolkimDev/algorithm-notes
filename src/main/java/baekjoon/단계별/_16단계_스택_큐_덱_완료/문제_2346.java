package baekjoon.단계별._16단계_스택_큐_덱_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 문제_2346 {
    // [2024-03-16 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, k, lastCnt;
    static List<CustomArray11> list2 = new LinkedList<>();
    static int[] arr;
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
        n = Integer.parseInt(s1);    // 1~1억
        String[] s2 = br.readLine().split(" "); // 1~10억
        for(int i=1; i<=n; i++) {
            list2.add(new CustomArray11(i, Integer.parseInt(s2[i-1])));
        }
    }

    public static void when() {
        Deque<CustomArray11> deq = new ArrayDeque<>(list2);
//        for(int i=1; i<=n; i++) {
//            deq.add(list2.get(i-1));
//        }

        while(!deq.isEmpty() && deq.size() != 1) {
            CustomArray11 poll = deq.pollFirst();
            int pollVal = poll.getVal();
            int pollLoc = poll.getLoc();
            sb.append(pollLoc).append(" ");
            if(pollVal > 0) {
                for (int i = 1; i < pollVal; i++) {
                    deq.addLast(deq.pollFirst());
                }
            } else {
                for (int i = 1; i <= -pollVal; i++) {
                    deq.addFirst(deq.pollLast());
                }
            }
        }
        sb.append(deq.pollLast().getLoc());
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}

class CustomArray11 {
    private int loc;
    private int val;

    public CustomArray11(int loc, int val) {
        this.loc = loc;
        this.val = val;
    }

    @Override
    public String toString() {
        return "CustomArray11{" +
                "loc=" + loc +
                ", val=" + val +
                '}';
    }

    public int getLoc() {
        return loc;
    }

    public void setLoc(int loc) {
        this.loc = loc;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}