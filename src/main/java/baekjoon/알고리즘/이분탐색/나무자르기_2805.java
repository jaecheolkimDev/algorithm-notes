package baekjoon.알고리즘.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 나무자르기_2805 {
	// [2023-03-05 JC]
	/**
	 * sum의 범위는 long으로 잡아야됨.
	 * 10억 * 100만. = 16자리
	 * int는 10자리까지만되니,,, 25자리까지되는 long으로 범위를 잡아야함.
	 */
/**
1 2000000000
1000000000
 */
	public static StringBuffer sb = new StringBuffer();
	public static int n, m;
	public static int[] hArr;

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
		String[] sArr2 = br.readLine().split(" ");
		n = Integer.parseInt(sArr1[0]);
		m = Integer.parseInt(sArr1[1]);
		hArr = new int[n+1];
		for(int i=1; i<=n; i++) {
			hArr[i] = Integer.parseInt(sArr2[i-1]);
		}
	}

	public static void pro() {
//		Arrays.sort(hArr, 1, hArr.length);
		long l = 0;
		long r = 2000000000;
		long result = 0;
		while(l <= r) {
			int mid = (int) ((l+r)/2);
			long sum = 0;
			for(int i=1; i<=n; i++) {
				long compare = hArr[i] - mid;
				if(compare > 0) {
					sum += compare;
				}
			}
			
			if(sum >= m) {
				result = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		sb.append(result);
	}
}
