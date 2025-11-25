package baekjoon.알고리즘.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
//[2023-02-05 JC]
public class 일곱난쟁이_2309 {
	public static int[] height = new int[10]; // 아홉 난쟁이의 키

	public static void main(String[] args) throws IOException {
		input();// 입력
		pro(); // 처리
	}

	public static void input() throws IOException {
		InputStream is = System.in; // 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr); // 스트링
		for (int i = 1; i < 10; i++) {
			height[i] = Integer.parseInt(br.readLine()); // 아홉 난쟁이의 키 배열
		}

		Arrays.sort(height);
	}

	public static void pro() {
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= 9; i++) {
			for (int j = i + 1; j <= 9; j++) {
				for (int k = j + 1; k <= 9; k++) {
					for (int l = k + 1; l <= 9; l++) {
						for (int m = l + 1; m <= 9; m++) {
							for (int n = m + 1; n <= 9; n++) {
								for (int o = n + 1; o <= 9; o++) {
									int target = height[i]+height[j]+height[k]+height[l]+height[m]+height[n]+height[o];
									if(target == 100) {
										sb.append(height[i]).append("\n");
										sb.append(height[j]).append("\n");
										sb.append(height[k]).append("\n");
										sb.append(height[l]).append("\n");
										sb.append(height[m]).append("\n");
										sb.append(height[n]).append("\n");
										sb.append(height[o]).append("\n");
										System.out.println(sb.toString());
										return;
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
