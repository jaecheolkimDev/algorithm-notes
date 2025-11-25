package baekjoon.알고리즘.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 문제_17266 {
    // [2024-01-21 JC]
    static int n,m;
    static int s, result;
    static int[] x;
    static Boolean[] streetLamp;
    static List<Integer> gapList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        given();// 테스트 실행을 준비하는 단계
        when(); // 테스트를 진행하는 단계
        then(); // 테스트 결과를 검증하는 단계
    }

    public static void given() throws IOException {
        InputStream is = System.in;						// 바이트
        InputStreamReader isr = new InputStreamReader(is);// 캐릭터
        BufferedReader br = new BufferedReader(isr);    // 스트링
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        String[] s1 = br.readLine().split(" ");
        x = new int[m];
        for(int i=0; i<m; i++) {
            x[i] = Integer.parseInt(s1[i]);
        }
    }
    public static void when() {
        for(int i=0; i<m; i++) {
            /**
             * m == 1 , x[0] == 0 -> m번.
             * m == 1 , x[0] != 0 -> 2번.
             * m != 1 , x[0] == 0 -> m번.
             * m != 1 , x[0] != 0 -> m+1번.
             */
            if(m == 1) {
                if(x[i] == 0) {
                    gapList.add(n);
                } else {
                    gapList.add(x[i]);
                    gapList.add(n-x[i]);
                }
            } else {
                if(i == 0) {
                    if (x[i] == 0) {
                    } else {
                        gapList.add(x[i]);
                    }
                } else if(i < m-1) {
                    gapList.add(x[i] - x[i-1]);
                } else {
                    gapList.add((int) Math.round((x[i] - x[i-1])/2.0));
                    gapList.add(n - x[i]);
                }
            }
        }
        gapList.sort(Comparator.reverseOrder());
        result = gapList.get(0);
//        result = lowerBound(gapList.get(0));
    }
    public static void then() {
        System.out.print(result);
    }

    public static int lowerBound(int standard) {
        int left = 0;
        int right = n;
        int mid = 0;
        while(left < right) {
            mid = (left + right) / 2;
            if(streetLampOff(mid)) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    public static boolean streetLampOff(int standard) {
        streetLamp = new Boolean[n+1];
        Arrays.fill(streetLamp, false);
        for(int i=0; i<m; i++) {
            // [2024-01-22] 이곳을 잘 짜야하는거 같음.

//            for(int j=x[i]-standard; j<=x[i]+standard; j++) {
//                if(j < 0) continue;
//                if(j > n) break;
//                streetLamp[j] = true;
//            }
        }
        List<Boolean> ls = new ArrayList<>(Arrays.asList(streetLamp));
        return ls.contains(false);
    }
}