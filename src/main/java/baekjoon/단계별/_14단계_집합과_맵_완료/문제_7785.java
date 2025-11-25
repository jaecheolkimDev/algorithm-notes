package baekjoon.단계별._14단계_집합과_맵_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class 문제_7785 {
    // [2024-03-13 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, m;
    static Map<String, String> map1 = new HashMap<>();
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
        n = Integer.parseInt(s1);
        for(int i=0; i<n; i++) {
            String[] s2 = br.readLine().split(" ");
            map1.put(s2[0], s2[1]);
        }
    }
    public static void when() {
        // 내림차순 필요.
        List<String> keySet = new ArrayList<>(map1.keySet());
        Collections.sort(keySet, Collections.reverseOrder());

        for(String key : keySet) {
            if("enter".equals(map1.get(key))) {
                sb.append(key).append("\n");
            }
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}
