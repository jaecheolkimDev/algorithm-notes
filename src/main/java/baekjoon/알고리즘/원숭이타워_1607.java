package baekjoon.알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class 원숭이타워_1607 {
	// [2023-02-22 JC]
	// 실패!! 맞는거 같은데,,, 왜 틀린지 모르겠음... 추후 구글에서 검색되면 확인필요!!
	// long으로도 충분히 가능한 범위 3410억~
	/*
	 * 1000000
		341036586325
		7665
	 */
	public static int n;	// 자연수
	public static BigDecimal[] ansArr = new BigDecimal[1000001];

	public static void main(String[] args) throws IOException {
		input();// 입력
		pro(); // 처리
	}

	public static void input() throws IOException {
		InputStream is = System.in; // 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr); // 스트링
		n = Integer.parseInt(br.readLine()); // 자연수
	}

	public static void pro() {
		hanoi(n);
		System.out.println(ansArr[n]);
		System.out.println(ansArr[n].divideAndRemainder(new BigDecimal(9901))[1]);
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
				ansArr[1] = new BigDecimal(1);
			} else if (i == 2) {
				ansArr[2] = new BigDecimal(3);
			} else {
				// 홀수일때
				if (i % 2 == 1) {
					ansArr[i] = ansArr[(i - 1)/2].multiply(new BigDecimal(4)).add(new BigDecimal(1));
				}
				// 짝수일때
				else {
					ansArr[i] = ansArr[(i - 1)/2].multiply(new BigDecimal(2)).add(ansArr[(i - 1)/2 + 1].multiply(new BigDecimal(2))).add(new BigDecimal(1));
				}
			}
		}
	}
}