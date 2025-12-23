package baekjoon.basic.study.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 하노이 {
	//[2023-02-09 JC]
	public static StringBuffer sb = new StringBuffer();
	public static int[] num = new int[100001];
	public static int[] pos = new int[100001];
	public static int n,x,ans;
	public static int pole1, pole2, pole3;
	public static final int MOD = 1000000;
	public static String[] s1;
	public static String[] s2;
	public static String[] s3;

	public static void main(String[] args) throws IOException {
//		input1();// 입력
//		pro1(); // 처리

		input2();// 입력
		pro2(); // 처리
	}

	public static void input1() throws IOException {
		InputStream is = System.in; // 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr); // 스트링
		n = Integer.parseInt(br.readLine()); // 자연수
	}

	public static void pro1() {
		recFunc(n,1,2,3);
		System.out.println(sb.toString());
	}
	
	public static void recFunc(int n, int from, int by, int to) {
		if(n == 1) {
			move(from, to);
		} else {
			recFunc(n-1, from, to, by);
			move(from, to);
			recFunc(n-1, by, from, to);
		}
	}
	
	public static void move(int from, int to) {
		sb.append("from : ").append(from).append("   to : ").append(to).append("\n");
	}

	public static void input2() throws IOException {
		InputStream is = System.in; // 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr); // 스트링
		n = Integer.parseInt(br.readLine()); // 자연수
		String[] sArr = br.readLine().split(" ");
		pole1 = Integer.parseInt(sArr[0]);
		pole2 = Integer.parseInt(sArr[1]);
		pole3 = Integer.parseInt(sArr[2]);
		s1 = br.readLine().split(" ");
		s2 = br.readLine().split(" ");
		s3 = br.readLine().split(" ");
	}

	public static void pro2() {
		cal();

		for(int i=0; i<pole1; i++) {
			pos[Integer.parseInt(s1[i])] = 1;
		}
		for(int i=0; i<pole2; i++) {
			pos[Integer.parseInt(s2[i])] = 2;
		}
		for(int i=0; i<pole3; i++) {
			pos[Integer.parseInt(s3[i])] = 3;
		}
		
		hanoi(n, pos[n]);	// 제일 큰 원판, 원판의 위치

		System.out.println(pos[n]);
		System.out.println(ans);
	}
	
	/**
	 * 재귀함수
	 * 1. 최소의 이동으로 모든 원판을 한 막대기로 옮기려면 가장 큰 원판이 있는 막대기로 모든 원판을 옮겨야 합니다.
	 * 2. (i)크기의 원판을 (i+1)크기의 원판 위로 옮기기 위해서는 1~(i-1)크기의 원판들을 한 곳에 모두 옮겨놔야 합니다.
	 * 		(아래에 그림으로 자세하게 설명하겠습니다.)
	 * 3. 1~(i-1)크기의 원판들을 잠시 옮겨놓는 막대를 보조 막대(코드에선 변수명 sub)라고 지칭하겠습니다.
	 * https://cocoon1787.tistory.com/393
	 * @param disc
	 * @param to : 옮겨야 할 곳
	 */
	public static void hanoi(int disc, int to) {
		if(disc == 0) return;
		
		int now = pos[disc];	// 현재 원판의 위치
		int sub = 0;	// 보조 막대기 : 현재 원판을 to로 옮기기 위해 나머지 원판을 모아 놓을 막대기 번호입니다.
		
		for(int i=1; i<=3; i++) {
			if(now == to) break;	// 현재위치와 옮길위치가 동일하면 sub는 사용하지 않으므로 break;
			if(now != i && to != i)	//  (옮겨야 할 곳 & 현재 원판의 위치)를 제외한 곳을 찾아서 sub로 지정합니다.
				sub = i;
		}
		
		// 현재 원판 크기를 disc라 할 때 만약 현재 원판의 위치가 옮겨야 할 곳(to)에 있다면 다음 원판(disc-1)으로 넘어가고,
		if(now == to) hanoi(disc-1, to);
		// 현재 원판의 위치가 옮겨야 할 곳(to)에 있지 않다면 다음 원판(disc-1)을 보조(sub) 막대로 옮겨야 합니다.
		// (그래야 disc 원판을 disc+1 원판 위로 옮길 수 있기 때문!)
		else {
			ans = (ans + num[disc-1]) % MOD;
			hanoi(disc-1, sub);
		}
	}
	
	/**
	 * cal함수는 n이 최대 10만이기 때문에 2의 i승들을 기록하기 위한 함수입니다.
	 */
	public static void cal() {
		num[0] = 1;
		for(int i=1; i<=n; i++)
			num[i] = (num[i-1]*2) % MOD;
	}
}
