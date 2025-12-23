package baekjoon.basic.study.recursion;

public class palindrome2 {

	public static void main(String[] args) {
		System.out.println("ABBA : " + isPalindrome("ABBA"));	// true
		System.out.println("ABC : " + isPalindrome("ABC"));		// false
		System.out.println("ABBBA : " + isPalindrome("ABBBA"));	// true
		System.out.println("a : " + isPalindrome("a"));			// true
		System.out.println("bbbaa : " + isPalindrome("bbbaa"));	// false
	}
	
	public static boolean recursion(String s, int l, int r) {
		// 3-1. 홀수자리일때 가운데 문자는 비교대상이 아님.
		// 3-2. 시작지점의 포인터가 끝지점의 포인터를 넘기면 비교가 끝났다는 얘기임.
		if(l >= r) {
			return true;
		}
		// 1. 처음과 끝을 비교중이므로 다른게 나오면 같지않음.
		else if(s.charAt(l) != s.charAt(r)) {
			return false;
		}
		// 2. 같았으므로 다음항목 비교 재귀.
		else {
			return recursion(s, l+1, r-1);
		}
	}
	
	public static boolean isPalindrome(String s) {
		return recursion(s, 0, s.length()-1);
	}

}
