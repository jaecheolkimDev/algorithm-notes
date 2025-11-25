package baekjoon.알고리즘.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 문제_19637 {
    // [2024-01-16 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, m;
    static List<String> list1 = new ArrayList<>();
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
        n = Integer.parseInt(s1[0]);    // 칭호
        m = Integer.parseInt(s1[1]);    // 칭호를 출력해야 하는 캐릭터들의 개수
        for(int i=1; i<=n; i++) {
            String[] s2 = br.readLine().split(" ");
            list1.add(s2[0]);    // 각 칭호의 이름을 나타내는 영어 대문자로만 구성된 문자열
            list2.add(Integer.parseInt(s2[1]));    // 해당 칭호의 전투력 상한값을 나타내는 10억 이하의 음이 아닌 정수
        }
        for(int i=1; i<=m; i++) {
            String s2 = br.readLine();
            list3.add(Integer.parseInt(s2));    // 캐릭터의 전투력을 나타내는 음이 아닌 정수.
        }
//        list3.sort(Comparator.naturalOrder());  // 오름차순
    }
    public static void when() {
        /**
         * 최대 list2 의 값들보다 이하에서 최대값인것을 찾아서 list1 칭호를 준다.
         * ...
         */
        int tot = 0;
        for(int i=0; i<n; i++) {
            int bsResult = upperbound(list2.get(i));
            for(int j=0; j<bsResult-tot; j++) {
                sb.append(list1.get(i)).append("\n");
            }
            tot = bsResult;
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }

    public static int upperbound(int standard) {
        int left = 1;
        int right = list3.size();
        int mid = 0;
        while(left < right) {
            mid = (left + right) / 2;
            if(list3.get(mid) > standard) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }


    // 배열 버전...
//    // [2024-01-16 JC]
//    static StringBuffer sb = new StringBuffer();
//    static int n, m;
//    static String[] list1;
//    static int[] list2, list3;
//    public static void main(String[] args) throws IOException {
//        given();// 테스트 실행을 준비하는 단계
//        when(); // 테스트를 진행하는 단계
//        then(); // 테스트 결과를 검증하는 단계
//    }
//
//    public static void given() throws IOException {
//        InputStream is = System.in;						// 바이트
//        InputStreamReader isr = new InputStreamReader(is);// 캐릭터
//        BufferedReader br = new BufferedReader(isr);    // 스트링
//        String[] s1 = br.readLine().split(" ");
//        n = Integer.parseInt(s1[0]);    // 칭호
//        m = Integer.parseInt(s1[1]);    // 칭호를 출력해야 하는 캐릭터들의 개수
//        list1 = new String[n];
//        list2 = new int[n];
//        list3 = new int[m];
//        for(int i=1; i<=n; i++) {
//            String[] s2 = br.readLine().split(" ");
//            list1[i-1] = s2[0];    // 각 칭호의 이름을 나타내는 영어 대문자로만 구성된 문자열
//            list2[i-1] = Integer.parseInt(s2[1]);    // 해당 칭호의 전투력 상한값을 나타내는 10억 이하의 음이 아닌 정수
//        }
//        for(int i=1; i<=m; i++) {
//            String s2 = br.readLine();
//            list3[i-1] = Integer.parseInt(s2);    // 캐릭터의 전투력을 나타내는 음이 아닌 정수.
//        }
////        list3.sort(Comparator.naturalOrder());  // 오름차순
//    }
//    public static void when() {
//        /**
//         * 최대 list2 의 값들보다 이하에서 최대값인것을 찾아서 list1 칭호를 준다.
//         * ...
//         */
//        int tot = 0;
//        for(int i=0; i<n; i++) {
//            int bsResult = upperbound(list2[i]);
//            for(int j=0; j<bsResult-tot; j++) {
//                sb.append(list1[i]).append("\n");
//            }
//            tot = bsResult;
//        }
//    }
//
//    public static void then() {
//        System.out.println(sb.toString());
//    }
//
//    public static int upperbound(int standard) {
//        int left = 1;
//        int right = list3.length;
//        int mid = 0;
//        while(left < right) {
//            mid = (left + right) / 2;
//            if(list3[mid] > standard) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return right;
//    }
}
