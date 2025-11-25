package baekjoon.알고리즘.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//[2023-02-05 JC]
public class 완전제곱수_1977 {
	public static int m;	// 1번째 수
	public static int n;	// 2번째 수

	public static void main(String[] args) throws IOException {
		input();// 입력
		pro();	// 처리
	}
	
	public static void input() throws IOException {
		InputStream is = System.in;						// 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr);	// 스트링
		m = Integer.parseInt(br.readLine());	// 1번째 수
		n = Integer.parseInt(br.readLine());	// 2번째 수
	}
	
	public static void pro() {
		int sum = 0;
		int start = 0;
		if(Math.sqrt(m) == 1) {
			start = (int)Math.sqrt(m);
		} else {
			start = (int)Math.sqrt(m)+1;	
		}
		
		for(int i=start; i<=(int)Math.sqrt(n); i++) {
			sum += i*i;
		}

		if(sum > 0) {
			int min = (int)Math.pow(start, 2);
			System.out.println(sum);
			System.out.println(min);			
		} else {
			System.out.println(-1);
		}
	}
}
