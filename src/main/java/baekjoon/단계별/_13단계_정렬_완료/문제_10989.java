package baekjoon.단계별._13단계_정렬_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 문제_10989 {
    // [2024-03-12 JC : 1000만개는 LIST에 담지 못한다. 메모리초과 오류발생.]
    static StringBuffer sb = new StringBuffer();
    static int n, m;
    static int[] array;
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
        array = new int[n];
        for(int i=0; i<n; i++) {
            String s2 = br.readLine();
            array[i] = Integer.parseInt(s2);
        }
    }
    public static void when() {
        Arrays.sort(array);
        for(int i=0; i<n; i++) {
            sb.append(array[i]).append("\n");
        }

    }

    public static void then() {
        System.out.println(sb.toString());
    }

}