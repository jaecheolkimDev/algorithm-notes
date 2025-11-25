package baekjoon.단계별;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class 하노이탑_2270 {
	//[2023-02-14 JC]
	// 실패! 추후 재도전...
	public static int n; // 자연수
	public static int a; // 자연수
	public static int b; // 자연수
	public static int c; // 자연수
	public static BigDecimal two = new BigDecimal(2);
	public static int max;

	public static void main(String[] args) throws IOException {
		input();// 입력
		pro(); // 처리
	}

	public static void input() throws IOException {
		InputStream is = System.in; // 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr); // 스트링
		n = Integer.parseInt(br.readLine()); // 자연수
		String[] sArr = br.readLine().split(" ");
		a = Integer.parseInt(sArr[0]);
		b = Integer.parseInt(sArr[1]);
		c = Integer.parseInt(sArr[2]);
		String s1 = br.readLine();
		String s2 = br.readLine();
		String s3 = br.readLine();
	}

	public static void pro() {
		int first=0, second=0, third=0;
		if(a >= b && a >= c) {
			max = 1;
			first = a;
			if(b>=c) {
				second = b;
				third = c;
			}else {
				second = c;
				third = b;
			}
		} else if(b >= a && b >= c) {
			max = 2;
			first = b;
			if(a >= c) {
				second = a;
				third = c;
			} else {
				second = c;
				third = a;
			}
		} else {
			max = 3;
			first = c;
			if(a >= b) {
				second = a;
				third = b;
			} else {
				second = b;
				third = a;
			}
		}
		BigDecimal second1 = two.pow(second).subtract(new BigDecimal(1));
		BigDecimal third1 = two.pow(third).subtract(new BigDecimal(1));
		System.out.println(max);	// 모아야 하는 막대기의 번호
		System.out.println(second1.add(third1));
	}
}
