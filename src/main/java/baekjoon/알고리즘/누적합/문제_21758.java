package baekjoon.알고리즘.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class 문제_21758 {
    // [2024-03-10 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, k, lastCnt;
    static List<Integer> list2 = new LinkedList<>();
    static List<Integer> list3 = new LinkedList<>();
    static List<Integer> sorted = new LinkedList<>();
    static int[] frontPrefixSum;
    static int[] backPrefixSum;
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
        n = Integer.parseInt(s1);    // 1~1억
        frontPrefixSum = new int[n+1];
        backPrefixSum = new int[n+1];
        String[] s2 = br.readLine().split(" "); // 1~10억
        list2.add(0);
        for(int i=0; i<n; i++) {
            list2.add(Integer.parseInt(s2[i]));
        }
    }

    public static void when() {
        for(int i=1; i<=n; i++) {
            frontPrefixSum[i] = frontPrefixSum[i-1] + list2.get(i);
        }
        backPrefixSum[n] = list2.get(n);
        for(int i=n-1; i>=1; i--) {
            backPrefixSum[i] = backPrefixSum[i+1] + list2.get(i);
        }

        int sum = 0;

        // 꿀통이 맨 오른쪽에 있을때(첫번째벌은 맨 왼쪽에 있어야함.)
        int firstSum = frontPrefixSum[n] - frontPrefixSum[1];
        int secondSum = frontPrefixSum[n];
        for(int i=2; i<n; i++) {   // 1번째에는 첫번째 벌이 위치했으므로 빼고, 두번째 위치부터 벌의 위치를 찾으면된다.
            int f = firstSum - list2.get(i);   // 두번째 벌의 위치라고 가정하고 뺀다.
            int s = secondSum - frontPrefixSum[i];  // 앞에서부터 두번째 위치까지의 누적합을 뺀다.
            sum = Math.max(sum , f + s);
        }

        // 꿀통이 맨 왼쪽에 있을때(첫번째벌은 맨 오른쪽에 있어야함.)
        firstSum = frontPrefixSum[n] - list2.get(n);
        secondSum = frontPrefixSum[n];
        for(int i=2; i<n; i++) {   //
            int f = firstSum - list2.get(i);   // 두번째 벌의 위치라고 가정하고 뺀다.
            int s = secondSum - backPrefixSum[i];  // 뒤에서부터 두번째 위치까지의 누적합을 뺀다.
            sum = Math.max(sum , f + s);
        }

        // 꿀통이 가운데에 있을때(벌이 양끝에 고정되어 있어야함.)
        for(int i=2; i<n; i++) {
            int f = frontPrefixSum[i] - list2.get(1);
            int s = backPrefixSum[i] - list2.get(n);
            sum = Math.max(sum , f + s);
        }
        sb.append(sum);
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}
