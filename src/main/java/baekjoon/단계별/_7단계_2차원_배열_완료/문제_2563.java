package baekjoon.단계별._7단계_2차원_배열_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 문제_2563 {
    // [2024-01-07 JC]
    static int result = 0;
    static int tot = 0;
    static int t,m;
    static String[] tString , tResult = new String[11];
    static boolean[][] drawingPaper = new boolean[101][101];
    public static void main(String[] args) throws IOException {
        given();// 테스트 실행을 준비하는 단계
        when(); // 테스트를 진행하는 단계
        then(); // 테스트 결과를 검증하는 단계
    }

    public static void given() throws IOException {
        InputStream is = System.in;						// 바이트
        InputStreamReader isr = new InputStreamReader(is);// 캐릭터
        BufferedReader br = new BufferedReader(isr);    // 스트링
        t = Integer.parseInt(br.readLine()); // 바구니의 총 갯수
        tString = new String[t+1];
        for(int i=1; i<=t; i++) {
            tString[i] = br.readLine();
        }
    }
    public static void when() {
        for(int i=1; i<=t; i++) {
            String[] arr = tString[i].split(" ");
            int x = Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[1]);
            for(int j=x; j<x+10; j++) {
                for(int k=y; k<y+10; k++) {
                    drawingPaper[j][k] = true;
                }
            }
        }
    }
    public static void then() {
        for(int i=1; i<=100; i++) {
            for(int j=1; j<=100; j++) {
                if(drawingPaper[i][j]) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
