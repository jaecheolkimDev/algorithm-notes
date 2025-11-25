package baekjoon.알고리즘.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 공유기설치_2110 {
	// [2023-03-19 JC]
	public static StringBuffer sb = new StringBuffer();
	public static int n, c;
	public static int[] nArr;
	public static int[] finalAns = new int[3];

	public static void main(String[] args) throws IOException {
		input();// 입력
		pro(); // 처리
		System.out.println(sb.toString());
	}

	public static void input() throws IOException {
		InputStream is = System.in; // 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr); // 스트링

		String[] sArr1 = br.readLine().split(" ");
		n = Integer.parseInt(sArr1[0]);	// 집의 개수 N (2 ≤ N ≤ 200,000)
		c = Integer.parseInt(sArr1[1]);	// 공유기의 개수 C (2 ≤ C ≤ N)
		nArr = new int[n+1];	// 집의 좌표를 나타내는 xi (0 ≤ xi ≤ 1,000,000,000)
		for(int i=1; i<=n; i++) {
			nArr[i] = Integer.parseInt(sArr1[i-1]);
		}
	}

	public static void pro() {
//		System.out.println("Arrays.toString(nArr) : " + Arrays.toString(nArr));
		Arrays.sort(nArr, 1, n+1);
		System.out.println("Arrays.toString(nArr) : " + Arrays.toString(nArr));
	}
	
	public static void binarySearch() {
		// 무엇을 이분탐색해야 하는가? 집의 위치로 이분탐색을 하면된다.
		/**
		 * 처음꺼를 설치하고, mid이상만큼 이동 후 설치를 하고, 입력된 공유기의 갯수와 비교 후 이분탐색 반복.
		 * 그 다음꺼를 설치하고, mid이상만큼 이동 후 설치를 하고, 입력된 공유기의 갯수와 비교 후 이분탐색 반복.
		 * 그 다음꺼를...
		 * 그 다음꺼를...
		 * 그 다음꺼를...
		 */
		/**
		 * 집의갯수 * 
		 * 20만 * 
		 * 20만 * 20만 = 400억
		 */
		int l = 0;
		int r = 1000000000;	// 10억
		int mid = 0;
		int cnt = 0;
		int internetModemLocation = 0;
		while(l <= r) {
			mid = (l+r)/2;
			
			cnt = 0;
			for(int i=1; i<=n; i++) {
//				if(nArr[i]) 
			}
		}
	}
}