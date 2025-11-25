package baekjoon.단계별._16단계_스택_큐_덱_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 문제_12789 {
    // [2024-03-14 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, k, lastCnt;
    static List<Integer> list2 = new LinkedList<>();
    static List<Integer> list3 = new LinkedList<>();
    static List<Integer> sorted = new LinkedList<>();
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
        arr = new int[n+1];
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(s2[i]);
        }
    }

    public static void when() {
        Stack<Integer> st = new Stack<>();
        int cnt = 1;
        for(int i=1; i<=n; i++) {
            st.push(arr[i]);
            if(cnt == arr[i]) {
                st.pop();
                cnt++;
            }
        }
        for(int i=cnt; i<=n; i++) {
            if(i != st.pop()) {
                sb.append("Sad");
                break;
            }
        }
        if(sb.isEmpty()) {
            sb.append("Nice");
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}
