package baekjoon.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 문제_13305 {
    // [2024-02-25 JC]
    static StringBuffer sb = new StringBuffer();
    static int n, m, k, lastCnt;
    static List<Integer> list1 = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();
    static List<CustomArray4> list3 = new ArrayList<>();
    static List<Integer> sorted = new LinkedList<>();
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
        n = Integer.parseInt(s1);
        String[] s2 = br.readLine().split(" ");
        for(int i=1; i<n; i++) {
            list1.add(Integer.parseInt(s2[i-1]));
        }
        String[] s3 = br.readLine().split(" ");
        for(int i=1; i<n; i++) {
            list2.add(Integer.parseInt(s3[i-1]));
        }
    }

    public static void when() {
        // 주유해야 하는 위치에 대해 찾음.
        int bestPrice = list2.get(0);
        int distance = list1.get(0);
        list3.add(new CustomArray4(bestPrice, distance));
        for(int i=0; i<n-2; i++) {
            int nextPrice = list2.get(i+1);
            int nextDistance = list1.get(i+1);
            if(bestPrice > nextPrice) {
                bestPrice = nextPrice;
                list3.add(new CustomArray4(nextPrice, nextDistance));
            } else {
                list3.get(list3.size()-1).setDistance(list3.get(list3.size()-1).getDistance() + nextDistance);
            }
        }
//        System.out.println("list3 : " + list3);

        long tot = 0;
        for(CustomArray4 l : list3) {
            tot += l.getDistance() * l.getPrice();
        }

        sb.append(tot);
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}

class CustomArray4 {
    private int price;
    private long distance;

    public CustomArray4(int price, long distance) {
        this.price = price;
        this.distance = distance;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "CustomArray4{" +
                "price=" + price +
                ", distance=" + distance +
                '}';
    }
}