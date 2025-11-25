package baekjoon.알고리즘_수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 문제_24092 {
    // [2024-01-30 JC]
    static StringBuffer sb = new StringBuffer();
    static String result = "";
    static int n, k, lastCnt;
    static List<Integer> list2 = new LinkedList<>();
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
        n = Integer.parseInt(s1[0]);    // 5~500,000
        String[] s2 = br.readLine().split(" "); // 1~10억
        for(int i=1; i<=n; i++) {
            list2.add(Integer.parseInt(s2[i-1]));
        }
        String[] s3 = br.readLine().split(" "); // 1~10억
        for(int i=1; i<=n; i++) {
            list3.add(Integer.parseInt(s3[i-1]));
        }
    }

    public static void when() {
        quick_sort(0, n-1);

        if("1".equals(result)) {
            sb.append(result);
        } else {
            sb.append("0");
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }

    public static void quick_sort(int left, int right) {
        if(left < right) {
            int mid = partition(left, right);
            quick_sort(left, mid-1);
            quick_sort(mid+1, right);
        }
    }

    public static int partition(int left, int right) {
        int x = list2.get(right);
        int i = left -1;
        for(int j=left; j<right; j++) {
            if(list2.get(j) <= x) {
                int tmp = list2.get(++i);
                list2.set(i, list2.get(j));
                list2.set(j, tmp);
                solve();
            }
        }
        if(i+1 != right) {
            int tmp = list2.get(i+1);
            list2.set(i+1, list2.get(right));
            list2.set(right, tmp);
            solve();
        }
        return i+1;
    }

    public static void solve() {
        boolean b = false;
        for(int i=0; i<list2.size(); i++) {
            if(list2.get(i) == list3.get(i)) {
                b = true;
            } else {
                b = false;
            }
        }
        if(b) result = "1";
    }
}
