package baekjoon.알고리즘.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 숫자카드_10815 {
	// [2023-03-05 JC]
	public static StringBuffer sb = new StringBuffer();
	public static int n, m;
	public static int[] nArr, mArr;
	public static Map<Integer, Integer> nMap = new HashMap<>(), mMap = new HashMap<>();

	public static void main(String[] args) throws IOException {
		input();// 입력
		System.out.println(sb.toString());
	}

	public static void input() throws IOException {
		InputStream is = System.in; // 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr); // 스트링
		n = Integer.parseInt(br.readLine());
		String[] sArr1 = br.readLine().split(" ");
		m = Integer.parseInt(br.readLine());
		String[] sArr2 = br.readLine().split(" ");
		nArr = new int[n+1];
		mArr = new int[m+1];
		for(int i=1; i<=n; i++) {
			nArr[i] = Integer.parseInt(sArr1[i-1]);
			nMap.put(nArr[i], nMap.getOrDefault(nArr[i], 0) + 1);
		}
		for(int i=1; i<=m; i++) {
			mArr[i] = Integer.parseInt(sArr2[i-1]);
			sb.append(nMap.getOrDefault(mArr[i], 0)).append(" ");
		}
	}
}
