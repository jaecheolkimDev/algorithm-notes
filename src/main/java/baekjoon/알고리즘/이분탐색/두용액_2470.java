package baekjoon.알고리즘.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 두용액_2470 {
	// [2023-03-16 JC]
	/**
	 * 성공적으로 맞추긴했으나, 어떤 실수로 인해 계속 
	 */
/**
10
100 90 80 70 60 50 40 30 20 10

10
-100 -90 -80 -70 -60 -50 -40 -30 -20 -10

9
-100 -90 0 90 130 130 130 130 130

5
-5 -3 -1 3 10

5
-99 -98 1 0 96

5
-98 -97 1 2 92

4
999999995 999999996 999999997 1000000000

3
-10 1 2

5
100 -1 -2 -3 -4

5
-100 1 2 3 4
 */
	public static StringBuffer sb = new StringBuffer();
	public static int n;
	public static int[] nArr;
	public static int[] finalAns = new int[3];

	public static void main(String[] args) throws IOException {
		input();// 입력
		pro(); // 처리
//		sb.append(ans).append("\n");
//		Arrays.sort(finalAns, 1, 2);
		sb.append(finalAns[1]).append(" ").append(finalAns[2]);
		System.out.println(sb.toString());
	}

	public static void input() throws IOException {
		InputStream is = System.in; // 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr); // 스트링

		n = Integer.parseInt(br.readLine());	// N은 2 이상 100,000 이하
		String[] sArr1 = br.readLine().split(" ");
		nArr = new int[n+1];	// -1,000,000,000 이상 1,000,000,000 이하
		for(int i=1; i<=n; i++) {
			nArr[i] = Integer.parseInt(sArr1[i-1]);
		}
	}

	public static void pro() {
//		System.out.println("Arrays.toString(nArr) : " + Arrays.toString(nArr));
		Arrays.sort(nArr, 1, n+1);
		System.out.println("Arrays.toString(nArr) : " + Arrays.toString(nArr));
		
		int ans = Integer.MAX_VALUE;
		for(int i=1; i<=n; i++) {
			int l = i+1;
			int r = n;
			int mid = 0;
			while(l <= r) {
				mid = (l+r)/2;

				int n1 = nArr[i];
				int n2 = nArr[mid];

				int sum = n1 + n2;
				
				if(Math.abs(sum) <= Math.abs(ans)) {
					ans = sum;
					
					// 출력해야 하는 두 용액은 특성값의 오름차순으로 출력한다.
					if(n1 <= n2) {
						finalAns[1] = n1;
						finalAns[2] = n2;
					} else {
						finalAns[1] = n2;
						finalAns[2] = n1;
					}
					
					// 특성값이 0이면 끝낸다.
					if(ans == 0) return;
					
					// 정렬된 첫번째 수에 따라 이분탐색이 달라짐.
					if(n1 + n2 <= 0) {
						l = mid + 1;
					} else {
						r = mid - 1;
					}
				} else {
					// 정렬된 첫번째 수에 따라 이분탐색이 달라짐.
					if(n1 + n2 <= 0) {
						l = mid + 1;
					} else {
						r = mid - 1;
					}
				}
			}
		}
	}
}