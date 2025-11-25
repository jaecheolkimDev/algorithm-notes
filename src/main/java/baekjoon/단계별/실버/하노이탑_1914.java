package baekjoon.단계별.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class 하노이탑_1914 {
	//[2023-02-14 JC]
	public static int n; // 자연수
	public static StringBuffer sb = new StringBuffer();
	public static BigDecimal two = new BigDecimal(2);

	public static void main(String[] args) throws IOException {
		input();// 입력
		pro(); // 처리
	}

	public static void input() throws IOException {
		InputStream is = System.in; // 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr); // 스트링
		n = Integer.parseInt(br.readLine()); // 자연수
	}

	public static void pro() {
		System.out.println(two.pow(n).subtract(new BigDecimal(1)));
		if(n <= 20) {
			recFunc(n,1,2,3);
			System.out.println(sb.toString());
		}
	}
	
	public static void recFunc(int n, int n1, int n2, int n3) {
		if(n == 1) {
			move(n1, n3);
		} else {
			recFunc(n-1, n1, n3, n2);
			move(n1, n3);
			recFunc(n-1, n2, n1, n3);
		}
	}
	
	public static void move(int from, int to) {
		sb.append(from).append(" ").append(to).append("\n");
	}
}
