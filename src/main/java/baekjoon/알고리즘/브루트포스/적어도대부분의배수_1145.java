package baekjoon.알고리즘.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//[2023-02-06 JC]
public class 적어도대부분의배수_1145 {
	public static int[] numbers = new int[6]; // 자연수 배열

	public static void main(String[] args) throws IOException {
		input();// 입력
		pro(); // 처리
	}

	public static void input() throws IOException {
		InputStream is = System.in; // 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr); // 스트링
		String[] sArr1 = br.readLine().split(" "); // 라인은 한번씩만 읽어야되기 때문에 변수로 선언.
		for (int i = 1; i <= 5; i++) {
			numbers[i] = Integer.parseInt(sArr1[i - 1]); // 자연수 배열
		}
	}

	public static void pro() {
		int cnt=0;
		while(true) {
			int ansCnt=0;
			cnt++;
			for(int i=1; i<=5; i++) {
				if(cnt%numbers[i] == 0) {
					ansCnt++;
					if(ansCnt==3) {
						System.out.println(cnt);
						return;
					}
				}
			}
		}
	}
}
