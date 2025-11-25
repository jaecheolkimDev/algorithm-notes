package baekjoon.알고리즘.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 기상청인턴신현수_2435 {
	// [2023-02-08 JC]
	public static int n;	// 온도를 측정한 전체 날짜의 수
	public static int k;	//  합을 구하기 위한 연속적인 날짜의 수
	public static int[] numbers;	// 매일 측정한 온도 배열

	public static void main(String[] args) throws IOException {
		input();// 입력
		pro();	// 처리
	}
	
	public static void input() throws IOException {
		InputStream is = System.in;						// 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr);	// 스트링
		String[] sArr1 = br.readLine().split(" ");	// 라인은 한번씩만 읽어야되기 때문에 변수로 선언.
		n = Integer.parseInt(sArr1[0]);	// 온도를 측정한 전체 날짜의 수
		k = Integer.parseInt(sArr1[1]);	//  합을 구하기 위한 연속적인 날짜의 수
		numbers = new int[n+1];	// 배열 객체 생성
		String[] sArr = br.readLine().split(" ");	// 라인은 한번씩만 읽어야되기 때문에 변수로 선언.
		for(int i=1; i<=n; i++) {
			numbers[i] = Integer.parseInt(sArr[i-1]);	// 매일 측정한 온도 배열
		}
	}
	
	public static void pro() {
		int ans = Integer.MIN_VALUE;
		for(int i=1; i<=n-k+1; i++) {
			int sum = 0;
			for(int j=i; j<=i+k-1; j++) {
				sum += numbers[j];
			}
			if(sum > ans) ans = sum;
		}
		System.out.println(ans);
	}
}
