package org.jc.study;

import java.math.BigDecimal;

public class factorial {

	public static void main(String[] args) {
		
		BigDecimal n = new BigDecimal("5");
		BigDecimal result1 = recursiveFactorial(n);
		BigDecimal result2 = factorial(n);

		System.out.println(result1);
		System.out.println(result2);
	}
	
	public static BigDecimal recursiveFactorial(BigDecimal n) {
		BigDecimal result = null;
		
		// 양수
		if(n.compareTo(BigDecimal.ZERO) > 0) {
			if(n.compareTo(new BigDecimal("1")) == 0) {
				result = new BigDecimal("1");
			} else {
				BigDecimal nSubtract1 = n.subtract(new BigDecimal("1"));
				result = n.multiply(factorial(nSubtract1));
			}
		}
		
		return result;
	}
	
	public static BigDecimal factorial(BigDecimal n) {
		BigDecimal result = new BigDecimal(1);

		for(BigDecimal i = new BigDecimal(1); i.compareTo(n) <= 0; i=i.add(new BigDecimal(1))) {
			result = result.multiply(i);
		}
		
		return result;
	}

}
