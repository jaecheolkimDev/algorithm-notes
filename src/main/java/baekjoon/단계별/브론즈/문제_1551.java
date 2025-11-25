package baekjoon.단계별.브론즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 문제_1551 {
	// [2024-03-24 JC]
	static StringBuffer sb = new StringBuffer();
	static int N, K;
	static List<Integer> list1 = new ArrayList<>();
	static List<Integer> list2 = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		given();// 테스트 실행을 준비하는 단계
		when(); // 테스트를 진행하는 단계
		then(); // 테스트 결과를 검증하는 단계
	}

	public static void given() throws IOException {
		InputStream is = System.in;						// 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr);    // 스트링
		String[] s1 = br.readLine().split(" ");
		N = Integer.parseInt(s1[0]);
		K = Integer.parseInt(s1[1]);
		String[] s2 = br.readLine().split(",");
		for(int i=0; i<N; i++) {
			list1.add(Integer.parseInt(s2[i]));
		}
	}

	public static void when() {
		for(int j=0; j<K; j++) {
			for (int i = 1; i < N-j; i++) {
				if (j % 2 == 0) {
					int num = list1.get(i) - list1.get(i - 1);
					list2.add(num);
				} else {
					int num = list2.get(i) - list2.get(i - 1);
					list1.add(num);
				}
			}
			if(K-1 != j) {
				if (j % 2 == 0) {
					list1 = new ArrayList<>();
				} else {
					list2 = new ArrayList<>();
				}
			}
		}
		int size = K%2 == 0 ? list1.size() : list2.size();
		for(int i=0; i<size; i++) {
			if(size-1 == i) {
				sb.append(K%2 == 0 ? list1.get(i) : list2.get(i));
			} else {
				sb.append(K%2 == 0 ? list1.get(i) : list2.get(i)).append(",");
			}
		}
	}

	public static void then() {
		System.out.println(sb.toString());
	}
}