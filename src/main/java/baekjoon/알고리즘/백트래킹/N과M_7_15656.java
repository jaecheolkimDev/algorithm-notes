package baekjoon.알고리즘.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

//[2023-02-05 JC]
public class N과M_7_15656 {
	public static int n; // 첫번째 수
	public static int m; // 두번째 수
	public static int[] numbers; // 자연수들
	public static StringBuffer sb = new StringBuffer();
	public static int[] selected; // 조건에 맞게 선택된 수

	public static void main(String[] args) throws IOException {
		input();// 입력
		pro(); // 처리
	}

	public static void input() throws IOException {
		InputStream is = System.in; // 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr); // 스트링
		String[] sArr1 = br.readLine().split(" "); // 라인은 한번씩만 읽어야되기 때문에 변수로 선언.
		n = Integer.parseInt(sArr1[0]); // 첫번째 수
		m = Integer.parseInt(sArr1[1]); // 두번째 수
		String[] sArr2 = br.readLine().split(" "); // 라인은 한번씩만 읽어야되기 때문에 변수로 선언.
		numbers = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			numbers[i] = Integer.parseInt(sArr2[i - 1]); // 첫번째 수
		}
		Arrays.sort(numbers);
	}

	public static void pro() {
		selected = new int[m + 1]; // 조건에 맞게 선택된 수
		// 1 번째 원소부터 M 번째 원소를 조건에 맞는 모든 방법을 찾아줘
		recFunc(1); // 재귀함수 호출
		System.out.println(sb.toString());
	}

	// Recurrence Function (재귀 함수)
	// 만약 M 개를 전부 고름 => 조건에 맞는 탐색을 한 가지 성공한 것!
	// 아직 M 개를 고르지 않음 => k 번째부터 M번째 원소를 조건에 맞게 고르는 모든 방법을 시도한다.
	public static void recFunc(int k) {
		// 재귀함수가 끝나는 조건 설정.
		if (k == m + 1) {
			// selected[1...M] 배열이 새롭게 탐색된 결과
			for (int i = 1; i <= m; i++)
				sb.append(selected[i]).append(" ");
			sb.append("\n");
		} else {
			for (int i = 1; i <= n; i++) {
				// k 번째에 cand 가 올 수 있으면
				selected[k] = numbers[i];

				// k+1 번부터 M 번까지 잘 채워주는 함수를 호출해준다.
				recFunc(k + 1);
				selected[k] = 0; // 초기화
			}
		}
	}
}
