package baekjoon.단계별.실버;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 국영수_10825 {
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, S, ans;
    static int kk;
    static Student[] stu;
    static String[] numsnums;
    static Stack<String> stack;


	public static void main(String[] args) {
		input();
		
		Arrays.sort(stu);
		
		for(int i=0; i<stu.length; i++) {
			sb.append(stu[i].name).append("\n");
		}
		System.out.println(sb.toString());
		
	}

    static void input() {
        N = sc.nextInt();
        stu = new Student[N];
        for (int i = 0; i < N; i++) stu[i] = new Student(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
    }

	static class Student implements Comparable<Student> {
		String name;
		int korea;
		int english;
		int math;
		
		public Student(String name, int korea, int english, int math) {
			this.name = name;
			this.korea = korea;
			this.english = english;
			this.math = math;
		}

		@Override
		public int compareTo(Student o) {
			int ret;
			if(o.korea == this.korea) {
				if(o.english == this.english) {
					if(o.math == this.math) {
						ret = this.name.compareTo(o.name);
					} else {
						ret = o.math - this.math;
					}
				} else {
					ret = this.english - o.english;
				}
			} else {
				ret = o.korea - this.korea;
			}
			
			return ret;
		}
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public FastReader(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(new File(s)));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
