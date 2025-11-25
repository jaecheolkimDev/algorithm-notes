package baekjoon.단계별._7단계_2차원_배열_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class 문제_2566 {
    // [2024-01-07 JC]
    static String result;
    static int tot = 0;
    static int m;
    static int[] n = new int[31] , nStudent = new int[31] , k = new int[101] , nBasket = new int[101];
    static List<Double> gradeList = new ArrayList<>();
    static List<Integer> weightList = new ArrayList<>();
    static Map<String, Double> map = Map.of(
            "A+", 4.5
            , "A0", 4d
            , "B+", 3.5
            , "B0", 3d
            , "C+", 2.5
            , "C0", 2d
            , "D+", 1.5
            , "D0", 1d
            , "F", 0d
    );
    static int[][] arrTwoDimensions = new int[10][10];
    static int max = 0;
    static String location = "1 1";
    public static void main(String[] args) throws IOException {
        given();// 테스트 실행을 준비하는 단계
        when(); // 테스트를 진행하는 단계
        then(); // 테스트 결과를 검증하는 단계
    }

    public static void given() throws IOException {
        InputStream is = System.in;						// 바이트
        InputStreamReader isr = new InputStreamReader(is);// 캐릭터
        BufferedReader br = new BufferedReader(isr);    // 스트링

        for(int i=1; i<=9; i++) {
            String[] sArr2 = br.readLine().split(" ");
            for(int j=1; j<=9; j++) {
                arrTwoDimensions[i][j] = Integer.parseInt(sArr2[j-1]);
            }
        }
    }
    public static void when() {
        for(int i=1; i<=9; i++) {
            for(int j=1; j<=9; j++) {
                if(max < arrTwoDimensions[i][j]) {
                    max = arrTwoDimensions[i][j];
                    location = i + " " + j;
                }
            }
        }
    }
    public static void then() {
        StringBuffer sb = new StringBuffer();
        sb.append(max).append("\n");
        sb.append(location);
        result = sb.toString();
        System.out.println(result);
    }
}
