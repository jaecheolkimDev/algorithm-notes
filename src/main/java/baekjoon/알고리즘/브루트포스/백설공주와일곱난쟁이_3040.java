package baekjoon.알고리즘.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 백설공주와일곱난쟁이_3040 {
	//[2023-02-06 JC]
	public static int[] numbers = new int[10]; // 아홉 난쟁이의 모자에 쓰여 있는 숫자
	public static int sum = 0;	// 입력받은 수의 합.

	public static void main(String[] args) throws IOException {
		input();// 입력
		pro(); // 처리
	}

	public static void input() throws IOException {
		InputStream is = System.in; // 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr); // 스트링
		for (int i = 1; i < 10; i++) {
			numbers[i] = Integer.parseInt(br.readLine()); // 아홉 난쟁이의 모자에 쓰여 있는 숫자
			sum += numbers[i];
		}
	}

	public static void pro() {
		for (int i = 1; i <= 9; i++) {
			for (int j = i + 1; j <= 9; j++) {
				if(sum - numbers[i] - numbers[j] == 100) {
					for(int k=1; k<=9; k++) {
						if(k != i && k != j) System.out.println(numbers[k]);
					}
				}
			}
		}
	}
}
