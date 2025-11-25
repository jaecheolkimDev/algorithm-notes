package baekjoon.알고리즘.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 정수제곱근_2417 {
	// [2023-03-08 JC]
	public static StringBuffer sb = new StringBuffer();
	public static long n;

	public static void main(String[] args) throws IOException {
		input();// 입력
		pro(); // 처리
		System.out.print(sb.toString());
	}

	public static void input() throws IOException {
		InputStream is = System.in; // 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr); // 스트링
		
		n = Long.parseLong(br.readLine());
	}

	public static void pro() {
		long ans = (long)Math.sqrt(n);
		if(ans*ans < n) {
			ans++;
		}
		sb.append(ans);
	}
}
