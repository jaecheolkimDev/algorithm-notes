package baekjoon.알고리즘.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 과자나눠주기_16401 {
	// [2023-03-11 JC]
	/**
	 * if(cnt == m) 의 조건에 대해서 질문게시판에 올림...
	 */
	public static StringBuffer sb = new StringBuffer();
	public static int n, m, max = 0;
	public static int[] nArr;

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
		m = Integer.parseInt(sArr1[0]);	// 조카의 수 M (1 ≤ M ≤ 1,000,000)
		n = Integer.parseInt(sArr1[1]);	// 과자의 수 N (1 ≤ N ≤ 1,000,000)
		String[] sArr2 = br.readLine().split(" ");
		nArr = new int[n+1];	// 과자의 길이는 (1 ≤ L1, L2, ..., LN ≤ 1,000,000,000)
		for(int i=1; i<=n; i++) {
			nArr[i] = Integer.parseInt(sArr2[i-1]);
			max = Math.max(max, nArr[i]);
		}
	}

	public static void pro() {
		long l = 1;
		long r = max;
		long mid = 0;
		long ans = 0;
		long cnt = 0;
		while(l <= r) {
			mid = (l+r)/2;

			cnt = 0;
			for(int i=1; i<=n; i++) {
				if(nArr[i]/mid > 0) {
					cnt += nArr[i]/mid;
				}
			}

			if(cnt >= m) {
//				if(cnt == m) {
					ans = mid;
//				}
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		sb.append(ans);
	}
}