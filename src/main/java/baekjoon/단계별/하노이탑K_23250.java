package baekjoon.단계별;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 하노이탑K_23250 {
	//[2023-02-23 JC]
	// 실패!!! 시간초과...
	/**
	 * Math.pow(2, 60) = 1,152,921,504,606,846,976
	 * 19자리
	 * int 범위 : -2,147,483,648 ~ 2,147,483,647	=> 10자리
	 * long 범위 : -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807		=> 25자리 
	 */
	
	public static int n; // 자연수
	public static int k; // 자연수
	public static int cnt = 0;
	public static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws IOException {
		input();// 입력
		pro(); // 처리
	}

	public static void input() throws IOException {
		InputStream is = System.in; // 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr); // 스트링
		String[] s = br.readLine().split(" "); // 자연수
		n = Integer.parseInt(s[0]);
		k = Integer.parseInt(s[1]);
	}

	public static void pro() {
		recFunc(n,1,2,3);
		System.out.println(sb.toString());
	}
	
	public static void recFunc(int n, int from, int sub, int to) {
		if(n == 1) {
			move(from, to);
		} else {
			recFunc(n-1, from, to, sub);
			move(from, to);
			recFunc(n-1, sub, from, to);
		}
	}
	
	public static void move(int from, int to) {
		cnt++;
		if(cnt == k) {
			sb.append(from).append(" ").append(to).append("\n");
		}
	}
}
