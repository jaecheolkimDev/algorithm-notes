package baekjoon.단계별.브론즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 재귀의귀재_25501 {
	// [2023-02-08 JC]
	public static int t; // 테스트케이스
	public static String[] s; // 각 테스트케이스
	public static StringBuffer sb = new StringBuffer();
	public static int cnt;	// recursion 함수의 호출 횟수

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
		s = new String[t + 1]; // 각 테스트케이스
		for (int i = 1; i <= t; i++) {
			s[i] = br.readLine(); // 각 테스트케이스
		}
	}

	public static void pro(int n) {
		sb.append(isPalindrome(s[n])).append(" ").append(cnt).append("\n");
	}
	
	public static int recursion(String s, int l, int r) {
		// 3-1. 홀수자리일때 가운데 문자는 비교대상이 아님.
		// 3-2. 시작지점의 포인터가 끝지점의 포인터를 넘기면 비교가 끝났다는 얘기임.
		if(l >= r) {
			return 1;
		}
		// 1. 처음과 끝을 비교중이므로 다른게 나오면 같지않음.
		else if(s.charAt(l) != s.charAt(r)) {
			return 0;
		}
		// 2. 같았으므로 다음항목 비교 재귀.
		else {
			cnt++;
			return recursion(s, l+1, r-1);
		}
	}
	
	public static int isPalindrome(String s) {
		cnt = 1;
		return recursion(s, 0, s.length()-1);
	}
}
