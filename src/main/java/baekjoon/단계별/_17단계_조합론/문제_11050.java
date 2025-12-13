package baekjoon.단계별._17단계_조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 문제_11050 {
	// [2025-12-03 JC]
	static StringBuffer sb = new StringBuffer();
	static int N, K;
	static List<Integer> list1 = new ArrayList<>();
	static List<Integer> list2 = new ArrayList<>();
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
		N = Integer.parseInt(s1[0]);
		K = Integer.parseInt(s1[1]);
	}

	public static void when() {
		sb.append(getBinomialCoefficient(N, K));
	}

	public static void then() {
		System.out.println(sb.toString());
	}

	public static int getBinomialCoefficient(int n, int k) {
		if(k < 0 || k > n) return 0;
		return factorial(n) / (factorial(k) * factorial(n-k));
	}

	public static int factorial(int num) {
		if(num == 0 || num == 1) return 1;
		return num * factorial(num-1);
	}
}