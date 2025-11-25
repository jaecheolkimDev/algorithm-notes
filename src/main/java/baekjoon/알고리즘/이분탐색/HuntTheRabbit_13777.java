package baekjoon.알고리즘.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HuntTheRabbit_13777 {
	// [2023-03-05 JC]
	public static StringBuffer sb = new StringBuffer();
	public static List<Integer> l = new ArrayList<>();
			

	public static void main(String[] args) throws IOException {
		input();// 입력
		
		int size = l.size();
		for (int i = 0; i < size; i++) {
			pro(l.get(i)); // 처리
		}
		System.out.println(sb.toString());
	}

	public static void input() throws IOException {
		InputStream is = System.in; // 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr); // 스트링

		String s;
		while(!"0".equals(s = br.readLine())) {
			int n = Integer.parseInt(s);
			l.add(n);
		}
	}

	public static void pro(int findNumber) {
		int l = 1;	// from
		int r = 50;	// to
		int mid = 0;	// 쓰레기값
		while(mid != findNumber) {
			mid = (l+r) / 2;
			
			sb.append(mid).append(" ");
			
			if(mid > findNumber) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		sb.append("\n");
	}
}
