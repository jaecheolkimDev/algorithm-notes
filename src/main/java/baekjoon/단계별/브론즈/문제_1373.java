package baekjoon.단계별.브론즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 문제_1373 {
	// [2024-03-25 JC]
	static StringBuffer sb = new StringBuffer();
	static String N;
	static int[] arr;
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
		N = s1;
	}

	public static void when() {
		// radix(기수) : 숫자 표현(진법체계)에 기준이 되는 수
		// 2진수 => 10진수
		BigInteger binaryToDecimal = new BigInteger(N, 2);
		// 10진수 => 8진수
		String octal = binaryToDecimal.toString(8);
		sb.append(octal);
	}

	public static void then() {
		System.out.println(sb.toString());
	}
}
