package baekjoon.단계별.브론즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//[2023-02-04 JC]
public class 삼각형외우기_10101 {
	public static int[] n = new int[4]; // 삼격형의 세 각

	public static void main(String[] args) throws IOException {
		input();// 입력
		pro(); // 처리
	}

	public static void input() throws IOException {
		InputStream is = System.in; // 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr); // 스트링

		n[1] = Integer.parseInt(br.readLine()); // 삼격형의 세 각
		n[2] = Integer.parseInt(br.readLine()); // 삼격형의 세 각
		n[3] = Integer.parseInt(br.readLine()); // 삼격형의 세 각
	}

	public static void pro() {
		String ans = "";
		if (n[1] + n[2] + n[3] == 180) {
			if (n[1] == 60 && n[2] == 60 && n[3] == 60) {
				ans = "Equilateral";
			} else if (n[1] == n[2] || n[1] == n[3] || n[2] == n[3]) {
				ans = "Isosceles";
			} else if (n[1] != n[2] && n[1] != n[3] && n[2] != n[3]) {
				ans = "Scalene";
			}
		} else {
			ans = "Error";
		}
		System.out.println(ans);
	}
}
