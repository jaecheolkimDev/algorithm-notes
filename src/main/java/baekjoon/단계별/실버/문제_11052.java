package baekjoon.단계별.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 문제_11052 {
    // [2024-03-24 JC]
    static StringBuffer sb = new StringBuffer();
    static int T, N, M, k, cnt;
    static List<int[][]> list1 = new ArrayList<>();
    static List<String> list2 = new ArrayList<>();
    static List<Integer> list3 = new ArrayList<>();
    static List<Integer> sorted = new LinkedList<>();
    static int[] arr1;
    static boolean[] isPrime;
    static List<Integer> primeList = new ArrayList<>();
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
        T = Integer.parseInt(s1);
        arr1 = new int[T];
        for(int i=0; i<T; i++) {
            String s2 = br.readLine();
            arr1[i] = Integer.parseInt(s2);
        }
    }

    public static void when() {
        sieveOfEratosthenes();	// 소수 판별(에라토스테네스의 체)
//		System.out.println(Arrays.toString(isPrime));

        for(int i=2; i<isPrime.length; i++) {
            if(isPrime[i]) primeList.add(i);
        }
//		System.out.println(primeList);
//		System.out.println(primeList.size());
        int size = primeList.size();	// 168^3 = 4,741,632
        for(int i=0; i<T; i++) {
            StringBuffer sb2 = new StringBuffer();

            outerloop:	// 라벨
            for(int j=0; j<size; j++) {
                for(int k=0; k<size; k++) {
                    for(int l=0; l<size; l++) {
                        if(arr1[i] == primeList.get(j) + primeList.get(k) + primeList.get(l)) {
                            if(sb2.isEmpty()) {
                                sb2.append(primeList.get(j)).append(" ").append(primeList.get(k)).append(" ").append(primeList.get(l)).append(" ");
                                break outerloop;
                            }
                        }
//						if(!sb2.isEmpty()) break;
                    }
//					if(!sb2.isEmpty()) break;
                }
//				if(!sb2.isEmpty()) break;
            }
            sb.append(sb2.toString()).append("\n");
        }
    }

    public static void then() {
        System.out.println(sb.toString());
    }

    public static void sieveOfEratosthenes() {
        int sqrt = (int)Math.sqrt(1000);	// 최대 1,000(1,000,000이니깐)

        isPrime = new boolean[1001];	// n+1만큼 할당

        // 0번째와 1번째를 소수 아님으로 처리
        // 초기화 : 2~ n 까지 소수로 설정
        Arrays.fill(isPrime, 2, isPrime.length, true);

        // 에라토스테네스의 체
        for(int i=2; i<=sqrt; i++){
            if(isPrime[i]){
                //i*i 미만은 이미 처리되었으므로 j의 시작값은 i*i로 최적화할 수 있다.
                for(int j = i*i; j<=1000; j+=i) {
                    isPrime[j] = false;// 소수가 아님.
                }
            }
        }
    }
}