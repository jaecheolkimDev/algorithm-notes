package baekjoon.알고리즘.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 먹을것인가먹힐것인가_7795 {
	// [2023-03-02 JC]
	/**
	 * 20,000 * 20,000 = 400,000,000 (4억)
	 * 1초당 1억번의 연산을 한다고 생각하면 4초나 걸리기 때문에, 다른 방법을 생각해야 함.
	 * Math.pow(2, 14) : 16384
	 * Math.pow(2, 15) : 32768
	 */
	/**
	 * 문제 푸는 방법
	 * 1. B배열 정렬 한번 => O(MlogM)
	 * 2. 모든 A의 원소마다, B배열에 대해 이분탐색 필요 => O(NlogM)
	 * 3. 총 시간 복잡도 => O((N+M)logM)
	 */
/**
2
5 3
8 1 7 3 1
3 6 1
3 4
2 13 7
103 11 290 215

1
5 5
1 2 3 4 5
1 2 3 4 5

1
10 1
2 3 4 5 6 7 8 9 10 11
1
 */

	public static int t; // 테스트케이스
	public static int[][][] n; // 자연수
	public static StringBuffer sb = new StringBuffer();
	public static int[][] result;	// 결과
	public static int cnt;

	public static void main(String[] args) throws IOException {
		input();// 입력
		for (int i = 1; i <= t; i++) {
			cnt = 0;
			pro(i); // 처리
		}

//		System.out.println("result : " + Arrays.toString(result[1]));
//		System.out.println("result : " + Arrays.toString(result[2]));
		System.out.println(sb.toString());
	}

	public static void input() throws IOException {
		InputStream is = System.in; // 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr); // 스트링
		t = Integer.parseInt(br.readLine()); // 테스트케이스
		n = new int[t+1][3][]; // 자연수
		for (int i = 1; i <= t; i++) {
			String[] sArr1 = br.readLine().split(" ");
			int n1 = Integer.parseInt(sArr1[0]);
			int n2 = Integer.parseInt(sArr1[1]);
			n[i][1] = new int[n1];
			n[i][2] = new int[n2];

			String[] sArr2 = br.readLine().split(" ");
			for(int j=0; j<n1; j++) {
				n[i][1][j] = Integer.parseInt(sArr2[j]);
			}
			
			String[] sArr3 = br.readLine().split(" ");
			for(int j=0; j<n2; j++) {
				n[i][2][j] = Integer.parseInt(sArr3[j]);
			}
		}

		// 결과배열
		result = new int[t+1][];
		for(int i=1; i<=t; i++) {
			result[i] = new int[n[i][1].length];
		}
	}

	public static void pro(int i) {
		Arrays.sort(n[i][1]);
		Arrays.sort(n[i][2]);
//		System.out.println("n[i][1] : " + Arrays.toString(n[i][1]));
//		System.out.println("n[i][2] : " + Arrays.toString(n[i][2]));
		
		for(int j=0; j<n[i][1].length; j++) {
			int standard = n[i][1][j];
			int l = 0 , r = n[i][2].length-1;
			while(l <= r) {
				int m = (l + r) / 2;
				int compareTarget = n[i][2][m]; 
				if(compareTarget < standard) {
					result[i][j] = (m+1);
					l = m+1;
				} else {
					r = m-1;
				}
			}
			cnt += result[i][j];
		}
		sb.append(cnt).append("\n");
	}
	
	public static int lower_bound(int[] A, int L, int R, int X) {
        // A[L...R] 에서 X 미만의 수 중 제일 오른쪽 인덱스를 return 하는 함수
        // 그런 게 없다면 L - 1 을 return 한다

        int res = L - 1;  // 만약 A[L...R] 중 X 이하의 수가 없다면 L - 1 을 return 한다.
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] < X) {
                res = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return res;
	}
}
