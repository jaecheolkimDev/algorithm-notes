package baekjoon.알고리즘.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 게임_1072 {
	// [2023-03-05 JC]
	/**
	 * Z는 형택이의 승률이고, 소수점은 버린다. 예를 들어, X=53, Y=47이라면, Z=88이다.
	 */
/**
1000000000 999999999
 */
	public static StringBuffer sb = new StringBuffer();
	public static long x, y;

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
		x = Long.parseLong(sArr1[0]);	// 게임 횟수 : X , 1 ≤ X ≤ 1,000,000,000
		y = Long.parseLong(sArr1[1]);	// 이긴 게임 : Y (Z%) , 0 ≤ Y ≤ X
	}

	public static void pro() {
		long originalValue = y*100/x;
		long updateValue = 0;
		long l=0;
		long r=Integer.MAX_VALUE;
		long mid = 0;
		long ans = -1;
		while(l <= r) {
			mid = (l+r)/2;
			updateValue = (y+mid)*100/(x+mid);
			
			if(originalValue != updateValue) {
				r = mid - 1;
				ans = mid;
			} else {
				l = mid + 1;
			}
		}
		sb.append(ans);
	}
}