package baekjoon.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 문제_1080 {
    // [2024-03-04 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, m;
    static boolean[][] arr1;
    static boolean[][] arr2;
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
        arr1 = new boolean[n][m];
        arr2 = new boolean[n][m];
        for(int z=1; z<=2; z++) {
            for (int i = 0; i < n; i++) {
                String s2 = br.readLine();
                for(int j=0; j<m; j++) {
                    if(z==1) {
                        arr1[i][j] = '1' == s2.charAt(j);
                    } else {
                        arr2[i][j] = '1' == s2.charAt(j);
                    }
                }
            }
        }
    }
    public static void when() {
//        System.out.println(Arrays.deepToString(arr1));
//        System.out.println(Arrays.deepToString(arr2));

        int cnt = 0;
        if(n >= 3 && m >= 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr1[i][j] != arr2[i][j]) {
                        cnt++;
                        for (int k = i; k <= i + 2; k++) {
                            for (int l = j; l <= j + 2; l++) {
                                if (k < n && l < m) {
                                    arr1[k][l] = !arr1[k][l];
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr1[i][j] != arr2[i][j]) {
                    sb.append(-1);
                }
            }
        }

        if(sb.isEmpty()) {
            sb.append(cnt);
        } else {
            sb = new StringBuffer();
            sb.append(-1);
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}
