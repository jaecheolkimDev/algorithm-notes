package baekjoon.알고리즘.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 암기왕_2776 {
	// [2023-03-07 JC]
	/**
	 * 여러번의 테스트케이스에서 사용하는 변수는 초기화를 시켜줘야 한다.
	 */
	public static StringBuffer sb = new StringBuffer();
	public static int t, n, m;
	public static int[] nArr, mArr;

	public static void main(String[] args) throws IOException {
		input();// 입력
		System.out.print(sb.toString());
	}

	public static void input() throws IOException {
		InputStream is = System.in; // 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr); // 스트링
		t = Integer.parseInt(br.readLine());
		for (int j = 1; j <= t; j++) {
			// 여러번의 테스트케이스가 있기때문에 Map을 초기화 시켜줘야 한다.
			Map<Integer, Integer> nMap = new HashMap<>();
			
			n = Integer.parseInt(br.readLine());
			String[] sArr1 = br.readLine().split(" ");
			m = Integer.parseInt(br.readLine());
			String[] sArr2 = br.readLine().split(" ");
			nArr = new int[n+1];
			mArr = new int[m+1];
			for(int i=1; i<=n; i++) {
				nArr[i] = Integer.parseInt(sArr1[i-1]);
				nMap.put(nArr[i], 1);
			}
			for(int i=1; i<=m; i++) {
				mArr[i] = Integer.parseInt(sArr2[i-1]);
				sb.append(nMap.getOrDefault(mArr[i], 0)).append("\n");
			}
		}
	}
}
