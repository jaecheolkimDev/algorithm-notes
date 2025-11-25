package baekjoon.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class 문제_1213 {
    // [2024-03-03 JC]
    static StringBuffer sb = new StringBuffer();
    static int i;
    static String s, result;
    static int n,m;
    static int[] alphabet = new int[26];
    public static void main(String[] args) throws IOException {
        given();// 테스트 실행을 준비하는 단계
        when(); // 테스트를 진행하는 단계
        then(); // 테스트 결과를 검증하는 단계
    }

    public static void given() throws IOException {
        InputStream is = System.in;						// 바이트
        InputStreamReader isr = new InputStreamReader(is);// 캐릭터
        BufferedReader br = new BufferedReader(isr);    // 스트링
        s = br.readLine();
    }
    public static void when() {
        s = s.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        for(int i=0; i<s.length(); i++) {
            alphabet[s.charAt(i)-65]++;
        }
//        System.out.println(Arrays.toString(alphabet));

        int cnt = 0;
        String ans = "";
        Stack<Character> stack = new Stack<>();
        char middle = ' ';
        for(int i=0; i<alphabet.length; i++) {
            if(alphabet[i] % 2 == 1) {
                cnt++;
            }
            if(cnt == 2) {
                ans = "I'm Sorry Hansoo";
                break;
            }

            for(int j=0; j<alphabet[i]/2; j++) {
                sb.append((char)(65+i));
                stack.add((char)(65+i));
            }
            if(alphabet[i] % 2 == 1) {
                middle = (char) (65+i);
            }
        }
        if(middle != ' ') {
            sb.append(middle);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        if(!"".equals(ans)) {
            sb = new StringBuffer();
            sb.append(ans);
        }
    }
    public static void then() {
        System.out.print(sb.toString());
    }
}