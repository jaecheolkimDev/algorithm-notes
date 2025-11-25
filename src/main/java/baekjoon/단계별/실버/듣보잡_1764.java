package baekjoon.단계별.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class 듣보잡_1764 {
	// [2023-03-12 JC]
	public static StringBuffer sb = new StringBuffer();
	public static int n, m;
	public static Map<String, String> map = new HashMap<>();
	public static List<String> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		input();// 입력
		pro(); // 처리
		System.out.println(sb.toString());
	}

	public static void input() throws IOException {
		InputStream is = System.in; // 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr); // 스트링

		String[] sArr1 = br.readLine().split(" ");
		n = Integer.parseInt(sArr1[0]);	// N, M은 500,000 이하의 자연수이다.
		m = Integer.parseInt(sArr1[1]);	// N, M은 500,000 이하의 자연수이다.
		for(int i=1; i<=n; i++) {
			String s = br.readLine();
			map.put(s, s);
		}
		for(int i=1; i<=m; i++) {
			String s = br.readLine();
			String mapValue = map.getOrDefault(s, "");
			if(!"".equals(mapValue)) {
				list.add(mapValue);
			}
		}
	}

	public static void pro() {
		Collections.sort(list);
		
		sb.append(list.size()).append("\n");
		
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
	}
}