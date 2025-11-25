package baekjoon.알고리즘.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
public class 슈퍼마리오_2851 {
	//[2023-02-06 JC]
	public static int[] numbers = new int[11]; // 10개의 버섯의 점수

	public static void main(String[] args) throws IOException {
		input();// 입력
		pro(); // 처리
	}

	public static void input() throws IOException {
		InputStream is = System.in; // 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr); // 스트링
		for (int i = 1; i <= 10; i++) {
			numbers[i] = Integer.parseInt(br.readLine()); // 10개의 버섯의 점수
		}
	}

	public static void pro() {
		int beforeSum = 0;
		int sum = 0;
		int ans = 0;
		for (int i = 1; i <= 10; i++) {
			sum += numbers[i];
			if(sum >= 100 || i == 10) {
				if(sum-100 > 100-beforeSum) {
					ans = beforeSum;
				} else {
					ans = sum;
				}
				System.out.println(ans);
				return;
			}
			beforeSum = sum;
		}
	}
}
