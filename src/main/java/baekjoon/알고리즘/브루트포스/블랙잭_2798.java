package baekjoon.알고리즘.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
//[2023-02-05 JC]
public class 블랙잭_2798 {
	public static int n;	// 카드의 개수
	public static int m;	// 카드의 총합의 제한
	public static int[] numbers;	// 카드에 적힌 수 배열

	public static void main(String[] args) throws IOException {
		input();// 입력
		pro();	// 처리
	}
	
	public static void input() throws IOException {
		InputStream is = System.in;						// 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr);	// 스트링
		String[] sArr1 = br.readLine().split(" ");	// 라인은 한번씩만 읽어야되기 때문에 변수로 선언.
		n = Integer.parseInt(sArr1[0]);	// 카드의 개수
		m = Integer.parseInt(sArr1[1]);	// 카드의 총합의 제한
		numbers = new int[n+1];	// 배열 객체 생성
		String[] sArr2 = br.readLine().split(" ");	// 라인은 한번씩만 읽어야되기 때문에 변수로 선언.
		for(int i=1; i<=n; i++) {
			numbers[i] = Integer.parseInt(sArr2[i-1]);	// 카드에 적힌 수 배열
		}
		
		Arrays.sort(numbers);
	}
	
	public static void pro() {
		int ans = 0;
		for(int i=1; i<=n; i++) {
			for(int j=i+1; j<=n; j++) {
				for(int k=j+1; k<=n; k++) {
					int target = numbers[i]+numbers[j]+numbers[k];
					if(target <= m && target > ans) {
						ans = target;
					}
				}
			}
		}
		System.out.println(ans);
	}
}
