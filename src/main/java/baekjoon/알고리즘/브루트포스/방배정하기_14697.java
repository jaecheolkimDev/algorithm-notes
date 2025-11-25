package baekjoon.알고리즘.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 방배정하기_14697 {
	//[2023-02-07 JC]
	public static int a; // 1번째 수
	public static int b; // 2번째 수
	public static int c; // 3번째 수
	public static int n; // 전체 학생 수

	public static void main(String[] args) throws IOException {
		input();// 입력
		pro(); // 처리
	}

	public static void input() throws IOException {
		InputStream is = System.in; // 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr); // 스트링
		String[] sArr = br.readLine().split(" "); // 라인은 한번씩만 읽어야되기 때문에 변수로 선언.
		a = Integer.parseInt(sArr[0]); // 1번째 수
		b = Integer.parseInt(sArr[1]); // 2번째 수
		c = Integer.parseInt(sArr[2]); // 3번째 수
		n = Integer.parseInt(sArr[3]); // 전체 학생 수
	}

	public static void pro() {
		for(int i=0; i<300; i++) {
			for(int j=0; j<300; j++) {
				for(int k=0; k<300; k++) {
					if(a*i + b*j + c*k == n) {
						System.out.println(1);
						return;
					}
				}
			}
		}
		System.out.println(0);
	}
}
