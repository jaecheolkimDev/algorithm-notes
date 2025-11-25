package baekjoon.단계별.브론즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
// [2023-02-03 JC]
public class 영수증_5565 {
	public static int totPrice;	// 모든 책의 가격
	public static int[] subPrice;	// 각 책의 가격
	public static int ans;	// 나머지 책 1권의 가격

	public static void main(String[] args) throws IOException {
		input();// 입력
		pro();	// 처리
	}
	
	public static void input() throws IOException {
		InputStream is = System.in;						// 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr);	// 스트링
		totPrice = Integer.parseInt(br.readLine());	// 모든 책의 가격
		subPrice = new int[10];	// 배열 객체 생성
		for(int i=1; i<10; i++) {
			subPrice[i] = Integer.parseInt(br.readLine());	// 각 책의 가격
		}
	}
	
	public static void pro() {
		int subTot = 0;
		for(int i=1; i<10; i++) {
			subTot += subPrice[i];
		}
		int ans = totPrice - subTot;
		System.out.println(ans);
	}
}
