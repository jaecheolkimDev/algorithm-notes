package baekjoon.단계별.브론즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//[2023-02-03 JC]
public class Balancing_Weights_11131 {
	public static int t;	// 명령의 수
	public static int[] n;	// N번째 가중치의 갯수
	public static int[][] w;// N번째 명령에 해당하는 각 가중치

	public static void main(String[] args) throws IOException {
		input();// 입력
		pro();	// 처리
	}
	
	public static void input() throws IOException {
		InputStream is = System.in;						// 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr);	// 스트링
		t = Integer.parseInt(br.readLine());	// 명령의 수
		n = new int[t+1];	// 배열 객체 생성
		w = new int[t+1][];	// 2차원 가변배열 생성
		for(int i=1; i<=t; i++) {
			n[i] = Integer.parseInt(br.readLine());
			String[] sArr = br.readLine().split(" ");	// 라인은 한번씩만 읽어야되기 때문에 변수로 선언.
			w[i] = new int[n[i]+1];	// 2차원 가변배열 마지막 생성
			for(int j=1; j<=n[i]; j++) {
				w[i][j] = Integer.parseInt(sArr[j-1]);	// N번째 명령에 해당하는 각 가중치
			}
		}
	}
	
	public static void pro() {
		
		StringBuffer sb = new StringBuffer();
		for(int i=1; i<=t; i++) {
			int tot = 0;
			for(int j=1; j<=n[i]; j++) {
				tot += w[i][j];
			}
			if(tot == 0) {
				sb.append("Equilibrium").append("\n");
			} else if(tot > 0) {
				sb.append("Right").append("\n");
			} else if(tot < 0) {
				sb.append("Left").append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
