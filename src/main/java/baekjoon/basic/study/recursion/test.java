package baekjoon.basic.study.recursion;

public class test {

	static int n = 0;
	static int m = 5;

	public static void main(String[] args) {
		rec_func();
	}

	static void rec_func() {
		n++;
		System.out.println("n : " + n);
		if (n < 5) {
			rec_func();
		}
		System.out.println("m : " + m);
		m--;
	}

}
