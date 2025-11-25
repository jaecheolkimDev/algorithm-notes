package baekjoon.알고리즘.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 분해합_2231 {
	//[2023-02-05 JC]
	public static int n; // 자연수

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
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			List<Integer> l = new ArrayList<>();
			int num = i;
			while (num > 0) {
				l.add(num % 10);
				num /= 10;
			}
			for(int j=0; j<l.size(); j++) {
				ans += l.get(j);
			}
			
			if(i + ans == n) {
				ans = i;
				break;
			}
			ans = 0;
		}
		System.out.println(ans);
	}
}
