package baekjoon.단계별;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 하노이의네탑_9942 {
	// [2023-02-22 JC]
	// 실패!! 맞는거 같은데,,, 왜 틀린지 모르겠음... 추후 구글에서 검색되면 확인필요!!
	public static int[] nArr = new int[4];
	public static long[] ansArr = new long[1001];

	public static void main(String[] args) throws IOException {
		input();// 입력
		pro(); // 처리
	}

	public static void input() throws IOException {
		InputStream is = System.in; // 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr); // 스트링
		for (int i = 1; i <= 3; i++) {
			nArr[i] = Integer.parseInt(br.readLine()); // 자연수
		}
	}

	public static void pro() {
		hanoi(1000);
		for (int i = 1; i <= 3; i++) {
			System.out.println("Case " + i + ": " + ansArr[nArr[i]]);
		}
	}

	public static void hanoi(int n) {
		/**
		 * 내가 생각한 공식
		 * 서브2개에 1개뺴고 나머지를 반씩 옮긴다.
		 * + 맨 마지막 한개를 to로 옮긴다.
		 * + 서브2개에 옮긴 반씩을 to로 옮긴다.
		 * = 2*서브1 + 2*서브2 + 1
		 */
		for (int i = 1; i <= n; i++) {
			if (i == 1) {
				ansArr[1] = 1;
			} else if (i == 2) {
				ansArr[2] = 3;
			} else {
				// 홀수일때
				if (i % 2 == 1) {
					ansArr[i] = 4 * ansArr[(i - 1)/2] + 1;
				}
				// 짝수일때
				else {
					ansArr[i] = 2 * ansArr[(i - 1)/2] + 2 * ansArr[(i - 1)/2 + 1] + 1;
				}
			}
		}
	}
}