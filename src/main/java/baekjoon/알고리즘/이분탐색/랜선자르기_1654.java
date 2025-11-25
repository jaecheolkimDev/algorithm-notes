package baekjoon.알고리즘.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 랜선자르기_1654 {
	// [2023-03-05 JC]
	/**
	 * 문제에서 원하는 타입 설정을 잘 해줘야함.
	 */
/**
4 11
800
600
400
399

1 1000000
1000000000

1 1000000
99999999
 */
	public static StringBuffer sb = new StringBuffer();
	public static int k, n;
	public static int[] kArr;

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
		k = Integer.parseInt(sArr1[0]);	// K는 1이상 10,000이하의 정수
		n = Integer.parseInt(sArr1[1]);	// N은 1이상 1,000,000이하의 정수
		kArr = new int[k+1];	// 랜선의 길이는 231-1보다 작거나 같은 자연수
		for(int i=1; i<=k; i++) {
			kArr[i] = Integer.parseInt(br.readLine());
		}
	}

	public static void pro() {
		long l = 1;
		long r = Integer.MAX_VALUE;
		long mid = 0;
		long result = 0;
		while(l <= r) {
			mid = (l+r)/2;
			long quotientSum = 0;
			for(int i=1; i<=k; i++) {
				if(kArr[i] >= mid) {
					quotientSum += kArr[i]/mid;
				}
			}
			/**
			 * case1 : 몫의합 > n : 
			 * case2 : else : 
			 */
			if(quotientSum >= n) {
				l = mid + 1;
				result = mid;
			} else {
				r = mid - 1;
			}
		}
		
		sb.append(result);
	}
}

