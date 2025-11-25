package baekjoon.단계별._9단계_약수_배수와_소수_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 문제_9506 {
    // [2024-03-10 JC]
    static StringBuffer sb = new StringBuffer();
    static int result = 0;
    static int m;
    static List<Integer> list1 = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        given();// 테스트 실행을 준비하는 단계
        when(); // 테스트를 진행하는 단계
        then(); // 테스트 결과를 검증하는 단계
    }

    public static void given() throws IOException {
        InputStream is = System.in;						// 바이트
        InputStreamReader isr = new InputStreamReader(is);// 캐릭터
        BufferedReader br = new BufferedReader(isr);    // 스트링

        while(true) {
            String s1 = br.readLine();
            if (s1.equals("-1")) break;
            list1.add(Integer.parseInt(s1));
        }
    }
    public static void when() {
        int size = list1.size();
        for(int i=0; i<size; i++) {
            int num = list1.get(i);
            int sum = 0;
            StringBuffer sb1 = new StringBuffer();
            for(int j=1; j<=num/2; j++) {   // 약수구하기
                if(num % j == 0) {
                    sum += j;
                    if(sum == num) {    // 완전수
                        sb1.append(j);
                    } else {
                        sb1.append(j).append(" + ");
                    }
                }
            }
            if("+ ".equals(sb1.substring(sb1.length()-2))) {
                sb.append(num).append(" is NOT perfect.").append("\n");
            } else {
                sb.append(num).append(" = ").append(sb1.toString()).append("\n");
            }
        }
    }
    public static void then() {
        System.out.println(sb.toString());
    }
}
