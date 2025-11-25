package baekjoon.단계별.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class 문제_1015 {
	// [2024-03-25 JC : 문제의이해 - 주어진 값들을 오름차순으로 정렬할때 각각의 수가 몇번째에 위치하는지]
	static StringBuffer sb = new StringBuffer();
	static int N;
	static List<CustomArray14> list2 = new LinkedList<>();
	static int[] arr;
	public static void main(String[] args) throws IOException {
		given();// 테스트 실행을 준비하는 단계
		when(); // 테스트를 진행하는 단계
		then(); // 테스트 결과를 검증하는 단계
	}

	public static void given() throws IOException {
		InputStream is = System.in;						// 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr);    // 스트링
		String s1 = br.readLine();
		N = Integer.parseInt(s1);    // 1~1억
		String[] s2 = br.readLine().split(" "); // 1~10억
		for(int i=0; i<N; i++) {
			list2.add(new CustomArray14(i, Integer.parseInt(s2[i]), Integer.MIN_VALUE));
		}
	}

	public static void when() {
		Comparator<CustomArray14> sortValue = new Comparator<CustomArray14>() {
			@Override
			public int compare(CustomArray14 o1, CustomArray14 o2) {
				if(o1.getValue() < o2.getValue()) {
					return -1;
				} else if(o1.getValue() > o2.getValue()) {
					return 1;
				} else {
					return 0;
				}
			}
		};
		Collections.sort(list2, sortValue);
		for(int i=0; i<list2.size(); i++) {
			list2.get(i).setFinalIndex(i);
		}

		Comparator<CustomArray14> sortIndex = new Comparator<CustomArray14>() {
			@Override
			public int compare(CustomArray14 o1, CustomArray14 o2) {
				if(o1.getIndex() < o2.getIndex()) {
					return -1;
				} else if(o1.getIndex() > o2.getIndex()) {
					return 1;
				} else {
					return 0;
				}
			}
		};
		Collections.sort(list2, sortIndex);

		for(CustomArray14 c : list2) {
			sb.append(c.getFinalIndex()).append(" ");
		}
	}

	public static void then() {
		System.out.println(sb.toString());
	}
}

class CustomArray14 {
	private int index;
	private int value;

	public int getFinalIndex() {
		return finalIndex;
	}

	@Override
	public String toString() {
		return "CustomArray14{" +
				"index=" + index +
				", value=" + value +
				", finalIndex=" + finalIndex +
				'}';
	}

	public void setFinalIndex(int finalIndex) {
		this.finalIndex = finalIndex;
	}

	public CustomArray14(int index, int value, int finalIndex) {
		this.index = index;
		this.value = value;
		this.finalIndex = finalIndex;
	}

	private int finalIndex;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}