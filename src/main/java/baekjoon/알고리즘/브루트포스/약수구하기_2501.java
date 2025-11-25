package baekjoon.알고리즘.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//[2023-02-05 JC]
public class 약수구하기_2501 {
	public static int n;	// 1번째 수
	public static int k;	// 2번째 수

	public static void main(String[] args) throws IOException {
		input();// 입력
		pro();	// 처리
	}
	
	public static void input() throws IOException {
		InputStream is = System.in;						// 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr);	// 스트링
		String[] sArr1 = br.readLine().split(" ");	// 라인은 한번씩만 읽어야되기 때문에 변수로 선언.
		n = Integer.parseInt(sArr1[0]);	// 1번째 수
		k = Integer.parseInt(sArr1[1]);	// 2번째 수
	}
	
	public static void pro() {
		int cnt = 0;
		for(int i=1; i<=n/2; i++) {
			if(n%i == 0) {
				cnt++;
				if(cnt == k) {
					System.out.println(i);
					return;
				}
			}
			if(cnt == k-1 && i==n/2) {
				System.out.println(n);
				return;					
			}
		}
		System.out.println(0);
	}
}

