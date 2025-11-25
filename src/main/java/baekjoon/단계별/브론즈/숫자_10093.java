package baekjoon.단계별.브론즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//[2023-02-03 JC]
public class 숫자_10093 {
	public static long a;	// 첫번째 수
	public static long b;	// 두번째 수

	public static void main(String[] args) throws IOException {
		input();// 입력
		pro();	// 처리
	}
	
	public static void input() throws IOException {
		InputStream is = System.in;						// 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr);	// 스트링
		String[] sArr = br.readLine().split(" ");	// 라인은 한번씩만 읽어야되기 때문에 변수로 선언.
		a = Long.parseLong(sArr[0]);	// 첫번째 수
		b = Long.parseLong(sArr[1]);	// 두번째 수
	}
	
	public static void pro() {
		long ans = 0;
		long increNum = 0;
		if(a < b) {
			ans = b-a-1;
			increNum = a;
		} else if(a > b) {
			ans = a-b-1;
			increNum = b;
		} else {
			ans = 0;
		}
		StringBuffer sb = new StringBuffer();
		sb.append(ans).append("\n");
		for(long i=0; i<ans; i++) {
			sb.append(++increNum).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}
