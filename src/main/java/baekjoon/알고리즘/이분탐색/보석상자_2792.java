package baekjoon.알고리즘.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 보석상자_2792 {
	// [2023-03-10 JC]
	public static StringBuffer sb = new StringBuffer();
	public static int n, m;
	public static long sum;
	public static int[] mArr;

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
		n = Integer.parseInt(sArr1[0]);	// 1 ≤ N ≤ 109
		m = Integer.parseInt(sArr1[1]);	// 1 ≤ M ≤ 300,000, M ≤ N
		mArr = new int[m+1];	// 구간 [1, 109]에 포함되는 양의 정수가 하나씩 주어진다.
		for(int i=1; i<=m; i++) {
			mArr[i] = Integer.parseInt(br.readLine());
			sum += mArr[i];
		}
	}

	public static void pro() {
		long l = 1;
		long r = sum;
		long mid = 0;
		long ans = 0;
		long cnt = 0;
		while(l <= r) {
			mid = (l+r)/2;

			cnt = 0;
			for(int i=1; i<=m; i++) {
				if(mArr[i] - mid > 0) {
					cnt += mArr[i]/mid;
					if(mArr[i]%mid > 0) cnt++;
				} else {
					cnt++;
				}
			}
			
			if(cnt <= n) {
				ans = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		sb.append(ans);
	}
}