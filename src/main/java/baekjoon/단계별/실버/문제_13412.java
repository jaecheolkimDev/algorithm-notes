package baekjoon.단계별.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 문제_13412 {
	// [2024-03-24 JC]
	static StringBuffer sb = new StringBuffer();
	static int T, N, M, k, cnt;
	static List<int[][]> list1 = new ArrayList<>();
	static List<String> list2 = new ArrayList<>();
	static List<Integer> list3 = new ArrayList<>();
	static List<Integer> sorted = new LinkedList<>();
	static int[] arr1;
	static boolean[] isPrime;
	static List<Integer> primeList = new ArrayList<>();
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
		T = Integer.parseInt(s1);
		arr1 = new int[T];
		for(int i=0; i<T; i++) {
			String s2 = br.readLine();
			arr1[i] = Integer.parseInt(s2);
		}
	}

	public static void when() {
		for(int i=0; i<T; i++) {
			cnt = 0;
			// 제곱근(루트)을 구한다.
			int limit = (int) (Math.sqrt(arr1[i]) + 1);
			for(int x=1; x<=limit; x++) {
				// 나머지가 0이면 서로소인 쌍이 존재하는 범위이다.
				if(arr1[i]%x == 0) {
					int y = arr1[i]/x;
					int gcd = getGreatestCommonDivisor(x,y);
					if(gcd != 1) continue;	// 최대공약수가 1이 아닌것은 제외한다.(문제의 조건)
					if(x > y) continue;	// (5,6 - 6,5) , (5,7 - 7,5) 같은 쌍일때의 조건때문에 제외.
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}
	}

	public static void then() {
		System.out.println(sb.toString());
	}

	/**
	 * 최대공약수 구하기
	 */
	public static int getGreatestCommonDivisor(int num1, int num2) {
		if (num1 % num2 == 0) {
			return num2;
		}
		return getGreatestCommonDivisor(num2, num1 % num2);
	}
}