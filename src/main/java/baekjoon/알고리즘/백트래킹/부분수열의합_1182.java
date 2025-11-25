package baekjoon.알고리즘.백트래킹;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
/**
5 0
-7 -3 -2 5 8
 * @author jaecheol
 *
 */
public class 부분수열의합_1182 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        S = scan.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) nums[i] = scan.nextInt();
        
        numsnums = new String[N];
        Arrays.fill(numsnums, "X");
        
        stack = new Stack<>();
    }

    static int N, S, ans;
    static int kk;
    static int[] nums;
    static String[] numsnums;
    static Stack<String> stack;
    // k번째 원소를 포함시킬 지 정하는 함수
    // value:= k-1 번째 원소까지 골라진 원소들의 합
    static void rec_func(int k, int value) {
//    	System.out.println("k : " + k + " , numsnums : " + Arrays.toString(numsnums));
    	System.out.println(Arrays.toString(numsnums));
        if (k == N) {  // 부분 수열을 하나 완성 시킨 상태
            // value 가 S 랑 같은 지 확인하기
            if (value == S) ans++;
        } else {
            // k 번째 원소를 포함시킬 지 결정하고 재귀호출해주기
            // Include
        	numsnums[k] = "O";
//        	System.out.println("Include");
            stack.push("" + (k+1) + "");
            rec_func(k + 1, value + nums[k]);
            kk++;
            // Not Include
//        	System.out.println("Not Include");
        	numsnums[k] = "X";
            stack.push("" + (k+1) + "-짧");
            rec_func(k + 1, value);
            kk++;
        }
    }

    public static void main(String[] args) {
        input();
        // 1 번째 원소부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 탐색해줘
        stack.push("0");
        rec_func(0, 0);
        // ans 가 정말 "진 부분집합"만 다루는 지 확인하기
        if (S == 0){
            ans--;
        }
        System.out.println("stack : " + stack);
        System.out.println(ans);
        System.out.println("kk : " + kk);
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
