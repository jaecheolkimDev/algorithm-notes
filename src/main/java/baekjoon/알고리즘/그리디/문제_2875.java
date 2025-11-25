package baekjoon.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 문제_2875 {
    // [2024-03-03 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, k, m, a, b, c, d;
    static List<Integer> list1 = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
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
        m = Integer.parseInt(s1[1]);
        k = Integer.parseInt(s1[2]);
    }
    public static void when() {
        int ans = 0;
        // [2024-03-03 JC : 이 방법을 생각못해서 if분기로 풀다가 소스가 100줄이 넘어가면서 이건 아니다 싶어서 구글링해서 풀이확인하고 이해하고 제출]
        while(n >= 2 && m >= 1 && n+m>=3+k) {
            n = n-2;
            m--;
            ans++;
        }
        sb.append(ans);
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}