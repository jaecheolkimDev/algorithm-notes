package baekjoon.basic.study;

import java.io.IOException;
import java.util.Arrays;

public class CustomMath {
    // [2024-03-12 JC]
    public static void main(String[] args) throws IOException {
        getLeastCommonMultiple(100, 1000);  // 최소공배수 구하기
        getGreatestCommonDivisor(100, 1000);  // 최대공약수 구하기
        sieveOfEratosthenes(1000);  // 소수구하기(에라토스테네스의 체)
    }


    /**
     * 최소공배수 구하기
     * 1) 두 수의 공약수로 나눈 몫이 서로소가 될 때까지 나눈다.
     * 2) 왼쪽 공약수들과 아래 서로소까지 모두 곱한다.
     *
     * 공식 : (num1 * num2) / 최대공약수
     */
    public static int getLeastCommonMultiple(int num1, int num2) {
        return (num1 * num2) / getGreatestCommonDivisor(num1, num2);
    }

    /**
     * 최대공약수 구하기
     * 1) 두 수를 공약수로 계속 나눈다.
     * 2) 공약수로 나눈 몫이 서로소가 되면 stop
     * 3) 왼쪽 공약수를 모두 곱한다.
     *
     * 유클리드 호제법
     * 자연수 a,b에 대해서 a를 b로 나눈 나머지를 r이라 한다면 a,b의 최대공약수와 b,r의 최대공약수는 같다.
     * 이 성질에 따라 a를 b로 나눈 나머지 r을 구하고, b를 r로 나눈 나머지 r'을 구한다.
     * 나머지가 0이 될때 나눈 수가 a,b의 최대공약수가 된다.
     */
    public static int getGreatestCommonDivisor(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGreatestCommonDivisor(num2, num1 % num2);
    }


    /**
     * 소수 판별하기.
     * 에라토스테네스의 체.
     * 범위안의 수를 소수로 판단한다.
     * 소수란? 1과 자기자신만을 약수로 가지는 수를 뜻한다.
     */
    public static boolean[] sieveOfEratosthenes(int n) {
        int sqrt = (int)Math.sqrt(n);	// 최대 1,000(1,000,000이니깐)

        boolean[] isPrime = new boolean[n+1];	// n+1만큼 할당

        // 0번째와 1번째를 소수 아님으로 처리
        // 초기화 : 2~ n 까지 소수로 설정
        Arrays.fill(isPrime, 2, isPrime.length, true);

        // 에라토스테네스의 체
        for(int i=2; i<=sqrt; i++){
            if(isPrime[i]){
                //i*i 미만은 이미 처리되었으므로 j의 시작값은 i*i로 최적화할 수 있다.
                for(int j = i*i; j<=n; j+=i) {
                    isPrime[j] = false;// 소수가 아님.
                }
            }
        }
        return isPrime;
    }
}
