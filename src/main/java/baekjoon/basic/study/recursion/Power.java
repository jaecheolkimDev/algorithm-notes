package baekjoon.basic.study.recursion;

public class Power {
    public static void main(String[] args) {
         displayPower(3, 0);
         displayPower(3, 1);
         displayPower(3, 2);
         displayPower(3, -1);
    }
    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static boolean isOdd(int n) {
        return !isEven(n);
    }

    public static double power(int x, int n) {
        // println("Computing " + x + " raised to power " + n + ".");
        if(n == 0) {
            return 1;
        }

        if(n > 0) {
            if(isEven(n)) {
                double p = power(x, n/2);
                return p*p;
            } else {
                double p = power(x, n-1);
                return x*p;
            }
        } else {
            return 1/power(x, -n);
        }
    }

    public static void displayPower(int x, int n) {
        System.out.println(x + " to the " + n + " is " + power(x, n));
    };
}
