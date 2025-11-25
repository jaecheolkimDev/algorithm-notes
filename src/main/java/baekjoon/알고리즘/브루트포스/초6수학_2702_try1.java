package baekjoon.알고리즘.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 초6수학_2702_try1 {
	//[2023-02-08 JC]
	/**
	 * 유클리드 알고리즘을 통한 최대공약수 최소공배수 구하기.
	 * https://devlog-wjdrbs96.tistory.com/110
	 */
	public static int t; // 테스트케이스
	public static int[][] numbers; // 각 테스트케이스
	public static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws IOException {
		input();// 입력
		for (int i = 1; i <= t; i++) {
			pro(i); // 처리
		}
		System.out.println(sb.toString());
	}

	public static void input() throws IOException {
		InputStream is = System.in; // 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr); // 스트링
		t = Integer.parseInt(br.readLine()); // 테스트케이스
		numbers = new int[t+1][3];
		for (int i = 1; i <= t; i++) {
			String[] sArr = br.readLine().split(" ");
			numbers[i][1] = Integer.parseInt(sArr[0]); // 각 테스트케이스
			numbers[i][2] = Integer.parseInt(sArr[1]); // 각 테스트케이스
		}
	}

	public static void pro(int n) {
		int max = Math.max(numbers[n][1] , numbers[n][2]);
		int min = Math.min(numbers[n][1] , numbers[n][2]);
		int gcd = gcd(max , min);	// 최대공약수
		int lcm = max*min/gcd;	// 최소공배수
		sb.append(lcm).append(" ");
		sb.append(gcd).append("\n");
	}
	
	/**
	 * 두 수의 최소공배수 구하기
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static int lcm(int n1, int n2) {
		int res = 0;
		for(int i=1; i<=1000000; i++) {
			if(i%n1==0 && i%n2==0) {
				res = i;
				break;
			}
		}
		return res;
	}

	/**
	 * 두 수의 최대공약수 구하기
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static int gcd(int n1, int n2) {
        if (n1 % n2 == 0) {
            return n2;
        }
        return gcd(n2, n1 % n2);
	}
}
