package baekjoon.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class 문제_1202 {
    // [2024-03-03 JC]
    /**
     * 가장 작은 무게의 가방에
     * 그 무게보다 같거나 작은 보석들 중 가장 큰 가격의 보석을 담는다.
     */
    static StringBuffer sb = new StringBuffer();
    static int n, k, m;
    static List<CustomArray2> list1 = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();
    static List<CustomArray3> list3 = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        given();// 테스트 실행을 준비하는 단계
        when(); // 테스트를 진행하는 단계
        then(); // 테스트 결과를 검증하는 단계
    }

    public static void given() throws IOException {
        InputStream is = System.in;						// 바이트
        InputStreamReader isr = new InputStreamReader(is);// 캐릭터
        BufferedReader br = new BufferedReader(isr);    // 스트링
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        k = Integer.parseInt(s1[1]);
        for(int i=1; i<=n; i++) {
            String[] s2 = br.readLine().split(" ");
            CustomArray2 ca = new CustomArray2(Integer.parseInt(s2[0]), Integer.parseInt(s2[1]));
            list1.add(ca);
        }
        for(int i=1; i<=k; i++) {
            String s3 = br.readLine();
            list2.add(Integer.parseInt(s3));
        }
    }
    public static void when() {
        Collections.sort(list1);
        System.out.println(list1);

        Collections.sort(list2);
        System.out.println(list2);

        // 별도의 공간 : 비싸고 가벼운거를 맨앞으로 정렬.
        // 가장 앞부분 참조 : O(1) , 삽입/삭제(n번째 제외) : O(1)
        PriorityQueue<CustomArray3> pq = new PriorityQueue<>();

        long tot = 0;
        int j = 0;
        // 가방은 무게가 가벼운 순으로 정렬되어 있다. 가벼운 가방을 먼저 채운다.
        for(int i=0; i<k; i++) {
            // 가방의 무게보다 작은 보석을 pq에 담는다.
            while(j < n && list2.get(i) >= list1.get(j).getWeigh()) {
                pq.offer(new CustomArray3(list1.get(j).getWeigh(), list1.get(j).getPrice()));
                j++;
            }

            if(!pq.isEmpty()) {
                // 가방의 무게 이하인 가장 비싼가격의 보석을 담고 q에서 제거한다.
                tot += pq.poll().getPrice();
            }
        }

        sb.append(tot);
    }

    public static void then() {
        System.out.println(sb.toString());
    }

}

class CustomArray2 implements Comparable<CustomArray2> {
    private int weigh;
    private int price;

    @Override
    public int compareTo(CustomArray2 o) {
        // 가벼운거 우선정렬 + 비싼가격 으로 정렬.
        if(this.weigh < o.weigh) {
            return -1;
        } else if(this.weigh > o.weigh) {
            return 1;
        } else {
            if(this.price > o.price) return 1;
            else if(this.price < o.price) return -1;
            else return 0;
        }
    }

    public int getWeigh() {
        return weigh;
    }

    public void setWeigh(int weigh) {
        this.weigh = weigh;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public CustomArray2(int weigh, int price) {
        this.weigh = weigh;
        this.price = price;
    }

    @Override
    public String toString() {
        return "CustomArray2{" +
                "weigh=" + weigh +
                ", price=" + price +
                '}';
    }
}

class CustomArray3 implements Comparable<CustomArray3> {
    private int weigh;
    private int price;

    @Override
    public int compareTo(CustomArray3 o) {
        // 비싼가격 우선정렬 + 가벼운 순으로 정렬.
        if(this.price > o.price) {
            return -1;
        } else if(this.price < o.price) {
            return 1;
        } else {
            if(this.weigh < o.weigh) return 1;
            else if(this.weigh > o.weigh) return -1;
            else return 0;
        }
    }

    public int getWeigh() {
        return weigh;
    }

    public void setWeigh(int weigh) {
        this.weigh = weigh;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public CustomArray3(int weigh, int price) {
        this.weigh = weigh;
        this.price = price;
    }

    @Override
    public String toString() {
        return "CustomArray3{" +
                "weigh=" + weigh +
                ", price=" + price +
                '}';
    }
}