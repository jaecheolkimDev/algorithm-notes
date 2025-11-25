package baekjoon.코테.네이버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class N개의_동전_역전_최솟값 {
	// [2024-03-25 JC]
	static StringBuffer sb = new StringBuffer();
	static int N;
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
		N = Integer.parseInt(s1);
		arr = new int[N];
		String[] s2 = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(s2[i]);
		}
	}

	public static void when() {
		int cnt = 0;
		for(int i=0; i<N; i++) {
			// 첫번째를 0이라 가정하고 카운트
			// 첫번째를 1이라 가정하고 카운트
			if(i%2 == 0) if(arr[i] == 0) cnt++;
			else if(arr[i] == 1) cnt++;
		}
		sb.append(N/2 > cnt ? cnt : N-cnt);
	}

	public static void then() {
		System.out.println(sb.toString());
	}
}
