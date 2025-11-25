package baekjoon.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class 문제_2812 {
    // [2024-03-24 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, k;
    static String s;
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
        String s2 = br.readLine();
        s = s2;
    }

    public static void when() {
        int deleteCnt = k;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++) {
            int num = s.charAt(i) - '0';    // char를 int로 변환시키는 방법
            // 1. 최초 : 스택이 비었으면 스택에 push
            if(st.isEmpty()) {
                st.push(num);
                continue;
            }
            // 2-1. 그 다음값이 스택의 값보다 크면 반복하면서 확인한다.
            if(st.peek() < num) {
                while(!st.isEmpty() && st.peek() < num) {
                    st.pop();
                    deleteCnt--;
                    if(deleteCnt == 0) {
                        while(!st.isEmpty()) {
                            sb.insert(0, st.pop());
                        }
                        sb.append(s.substring(i));
                        break;
                    }
                }
                st.push(num);
            }
            // 2-2. 그 다음값이 스택의 값보다 작거나 같으면 push
            else {
                st.push(num);
            }
        }

        // 이미 정렬된 상태였다면, 위에서 해결되지 않기 때문에, 아래 로직을 통해 빼야될 카운트만큼 빼고 남은 숫자를 나열.
        if(deleteCnt > 0) {
            // [2024-03-24 JC : 반복횟수 조정]
            for(int i=0; i<deleteCnt; i++) {
                st.pop();
            }
            while (!st.isEmpty()) {
                sb.insert(0, st.pop());
            }
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}