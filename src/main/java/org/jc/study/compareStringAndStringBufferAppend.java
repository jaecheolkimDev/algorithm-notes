package org.jc.study;

public class compareStringAndStringBufferAppend {

	public static void main(String[] args) {
		
		String str = "";
		long start = System.currentTimeMillis();
		for(int i = 1; i < 100_000; i++) {
			str = str + i;	
		}
		long end = System.currentTimeMillis();
		System.out.println("소요시간 : " + (end - start) / 1000.0 + "초");
		
		StringBuffer sb = new StringBuffer();
		start = System.currentTimeMillis();
		for(int i = 1; i < 100_000; i++) {
			sb.append(i);
		}
		end = System.currentTimeMillis();
		System.out.println("소요시간 : " + (end - start) / 1000.0 + "초");
	}
}
