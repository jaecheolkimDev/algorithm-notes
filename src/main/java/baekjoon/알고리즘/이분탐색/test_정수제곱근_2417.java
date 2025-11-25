package baekjoon.알고리즘.이분탐색;

import java.io.IOException;

public class test_정수제곱근_2417 {
	// [2023-03-08 JC]
	public static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws IOException {
		for(long i=0; i<=2100000000; i++) {
			pro(i); // 처리
		}

		for(long i=9223372036854775807l; i>9223372035854775807l; i--) {
			pro(i); // 처리
		}
		
		System.out.print(sb.toString());
	}

	public static void pro(long n) {
		long ans = (long)Math.sqrt(n);
		long ans1 = ans;
		long ans2 = ans;
		if(ans*ans < n) {
			ans1++;
		}
		if(ans*ans != n) {
			ans2++;
		}
		if(ans1 != ans2) {
			sb.append(ans).append(" ");
		}
	}
}
