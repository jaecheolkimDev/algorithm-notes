package baekjoon.알고리즘.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 예산_2512 {
	// [2023-03-05 JC]
/**
4
120 110 140 150
484
 */
	public static StringBuffer sb = new StringBuffer();
	public static int n, m;
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

		n = Integer.parseInt(br.readLine());	// 지방의 수를 의미하는 정수 N이 주어진다. N은 3 이상 10,000 이하
		String[] sArr1 = br.readLine().split(" ");	// 각 지방의 예산요청을 표현하는 N개의 정수. 이 값들은 모두 1 이상 100,000 이하
		m = Integer.parseInt(br.readLine());	// 총 예산을 나타내는 정수 M이 주어진다. M은 N 이상 1,000,000,000 이하
		nArr = new int[n+1];
		for(int i=1; i<=n; i++) {
			nArr[i] = Integer.parseInt(sArr1[i-1]);
		}
	}

	public static void pro() {
		Arrays.sort(nArr);
		
		int l=0;
		int r=nArr[n];
		int mid=0;
		int ans = 0;
		while(l <= r) {
			mid = (l+r)/2;
			int sum = 0;
			for(int i=1; i<=n; i++) {
				if(nArr[i] > mid) {
					sum += mid;
				} else {
					sum += nArr[i];
				}
			}
			
			if(sum <= m) {
				ans = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		sb.append(ans);
	}
}