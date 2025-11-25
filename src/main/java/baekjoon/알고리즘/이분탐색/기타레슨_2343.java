package baekjoon.알고리즘.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 기타레슨_2343 {
	// [2023-03-07 JC]
	/**
	 * 접근법 참고 : https://chanhuiseok.github.io/posts/baek-22/
	 */
/**
5 4
1 2 3 4 5
 */
	public static StringBuffer sb = new StringBuffer();
	public static int n, m, sum, max=0, firstSize;
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
		String[] sArr2 = br.readLine().split(" ");
		n = Integer.parseInt(sArr1[0]);	// 강의의 수 N (1 ≤ N ≤ 100,000)
		m = Integer.parseInt(sArr1[1]);	// M (1 ≤ M ≤ N)
		nArr = new int[n+1];	// 강토의 기타 강의의 길이가 강의 순서대로 분 단위로(자연수)로 주어진다
		for(int i=1; i<=n; i++) {
			nArr[i] = Integer.parseInt(sArr2[i-1]);
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
			int sum1 = 0;
			int cnt = 1;
			for(int i=1; i<=n; i++) {
				sum1 += nArr[i];
				if(sum1 > mid) {
					cnt++;
					sum1 = nArr[i];
				}
			}
			
			// 갯수가 M 이하일 때는, RIGHT 값을 줄여본다.
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