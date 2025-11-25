package baekjoon.단계별._6단계_심화_1_완료;

import java.io.IOException;

public class 문제_25083 {
    // [2023-12-10 JC]
    static int i;
    static String s, result = "";
    static int n,m;
    static int[] j = new int[101] , nBasketTmp = new int[101] , nBasket = new int[101];
    public static void main(String[] args) throws IOException {
        given();// 테스트 실행을 준비하는 단계
        when(); // 테스트를 진행하는 단계
        then(); // 테스트 결과를 검증하는 단계
    }

    public static void given() throws IOException {
    }
    public static void when() {
        result = result.concat("         ,r'\"7").concat("\n");
        result = result.concat("r`-_   ,'  ,/").concat("\n");
        result = result.concat(" \\. \". L_r'").concat("\n");
        result = result.concat("   `~\\/").concat("\n");
        result = result.concat("      |").concat("\n");
        result = result.concat("      |").concat("\n");

    }
    public static void then() {
        System.out.print(result);
    }
}
