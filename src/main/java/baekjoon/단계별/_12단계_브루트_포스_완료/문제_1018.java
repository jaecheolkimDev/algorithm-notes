package baekjoon.단계별._12단계_브루트_포스_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 문제_1018 {
    // [2024-03-12 JC]
    static StringBuffer sb = new StringBuffer();
    static int n,m, k;
    static int s, result;
    static int[] x;
    static Boolean[] streetLamp;
    static List<Integer> list1 = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
    static boolean[][] arrTwoDimensions;
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
        arrTwoDimensions = new boolean[n+1][m+1];
        for(int i=1; i<=n; i++) {
            String s2 = br.readLine();
            for(int j=1; j<=m; j++) {
                arrTwoDimensions[i][j] = s2.charAt(j-1) == 'B';   // B == true , W == false
            }
        }
    }
    public static void when() {
        int min = Integer.MAX_VALUE;
        // 경우의 수 : (가로칸갯수-7) * (세로칸갯수-7) => ★★★★★if문을 for문에서부터 걸러버림.
        for (int k = 1; k <= n - 7; k++) {
            for (int l = 1; l <= m - 7; l++) {
                int cnt = 0;
                boolean pivot = arrTwoDimensions[k][l];
                for(int i=k; i<=k+7; i++) {
                    for(int j=l; j<=l+7; j++) {
                        if(arrTwoDimensions[i][j] != pivot) {
                            cnt++;  // 이전과 다른색이라면 카운트
                        }
                        pivot = !pivot;   // 다음칸은 색이 바뀌므로 기준을 변경한다.
                    }
                    pivot = !pivot; // 다음라인은 색이 바뀌므로 기준을 변경한다.
                }
                min = Math.min(min, cnt > 32 ? 64-cnt : cnt);
            }
        }
        sb.append(min);
    }
    public static void then() {
        System.out.print(sb.toString());
    }
}