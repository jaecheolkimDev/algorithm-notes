package baekjoon.알고리즘.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//[2023-02-06 JC]
public class 유레카이론_10448 {
	public static int t; // 테스트케이스
	public static int[] numbers; // 각 테스트케이스
	public static List<Integer> eurekaNumbers = new ArrayList<>(); // 유레카 수
	public static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws IOException {
		input();// 입력
		for (int i = 1; i <= t; i++) {
			pro(i); // 처리
		}
		System.out.println(sb.toString());
	}

	public static void input() throws IOException {
		InputStream is = System.in; // 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr); // 스트링
		t = Integer.parseInt(br.readLine()); // 테스트케이스
		numbers = new int[t + 1]; // 각 테스트케이스
		for (int i = 1; i <= t; i++) {
			numbers[i] = Integer.parseInt(br.readLine()); // 각 테스트케이스
		}

		// 유레카 수 리스트
		int cnt = 0;
		while (true) {
			eurekaNumbers.add((cnt+2) * (cnt + 1) / 2);
			if (eurekaNumbers.get(cnt) > 1000)
				break;
			cnt++;
		}
	}

	public static void pro(int n) {
		int size = eurekaNumbers.size();
		for (int j = 0; j < size; j++) {
			for (int k = 0; k < size; k++) {
				for (int l = 0; l < size; l++) {
					if (numbers[n] == eurekaNumbers.get(j) + eurekaNumbers.get(k) + eurekaNumbers.get(l)) {
						sb.append(1).append("\n");
						return;
					}
				}
			}
		}
		sb.append(0).append("\n");
	}
}
