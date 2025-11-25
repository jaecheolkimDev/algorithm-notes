package baekjoon.단계별.브론즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
// [2023-02-03 JC]
public class 다면체_10569 {
	public static int t;	// 명령의 수
	public static int[] v;	// 꼭짓점의 개수
	public static int[] e;	// 모서리의 개수
	public static int[] ans;	// 답의 개수

	public static void main(String[] args) throws IOException {
		input();// 입력
		pro();	// 처리
	}
	
	public static void input() throws IOException {
		InputStream is = System.in;						// 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr);	// 스트링
		t = Integer.parseInt(br.readLine());	// 명령의 수
		v = new int[t];	// 배열 객체 생성
		e = new int[t];	// 배열 객체 생성
		for(int i=0; i<t; i++) {
			String[] sArr = br.readLine().split(" ");	// 라인은 한번씩만 읽어야되기 때문에 변수로 선언.
			v[i] = Integer.parseInt(sArr[0]);	// 꼭짓점의 개수
			e[i] = Integer.parseInt(sArr[1]);	// 모서리의 개수
		}
	}
	
	public static void pro() {
		StringBuffer sb = new StringBuffer();
		ans = new int[t];
		for(int i=0; i<t; i++) {
			ans[i] = 2 - v[i] + e[i];
			sb.append(ans[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
