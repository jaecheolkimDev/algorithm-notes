package baekjoon.알고리즘.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 용돈관리_6236 {
	// [2023-03-08 JC]
	public static StringBuffer sb = new StringBuffer();
	public static int n, m, sum=0, max=0;
	public static int[] nArr;

	public static void main(String[] args) throws IOException {
		input();// 입력
		pro(); // 처리
		System.out.print(sb.toString());
	}

	public static void input() throws IOException {
		InputStream is = System.in; // 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr); // 스트링
		
		String[] sArr1 = br.readLine().split(" ");
		n = Integer.parseInt(sArr1[0]);
		m = Integer.parseInt(sArr1[1]);
		nArr = new int[n+1];
		for(int i=1; i<=n; i++) {
			nArr[i] = Integer.parseInt(br.readLine());
			sum += nArr[i];
			max = Math.max(max, nArr[i]);
		}
	}

	public static void pro() {
		int l = max;
		int r = sum;
		int mid = 0;
		int ans = 0;
		while(l <= r) {
			mid = (l+r)/2;
			int midTemp = mid;
			
			int cnt = 1;
			for(int i=1; i<=n; i++) {
				if(mid - nArr[i] >= 0) {
					mid -= nArr[i];
				} else {
					cnt++;
					mid = midTemp - nArr[i];
				}
			}
			mid = midTemp;
			
			if(cnt <= m) {
				ans = mid;
				r = mid-1;
			} else {
				l = mid+1;
			}
		}
		
		sb.append(ans);
	}
}
