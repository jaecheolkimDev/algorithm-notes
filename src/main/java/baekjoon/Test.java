package baekjoon;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[][] array = {
                {4, 2},
                {-1, 3},
                {3, 5}
        };

        // 첫 번째 요소를 기준으로 오름차순 정렬
        Arrays.sort(array, (a, b) -> Integer.compare(a[1], b[1]));

        // 결과 출력
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }
    }
}
