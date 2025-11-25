package org.jc.study.recursion;

import static java.lang.System.out;

public class Palindrome1 {
    public static void main(String[] args) {
        checkPalindrome("a");
        checkPalindrome("motor");
        checkPalindrome("rotor");

    }
    // Returns the first character of the string str
    public static String firstCharacter(String str) {
        return str.substring(0, 1);
    }

    // Returns the last character of a string str
    public static String lastCharacter(String str) {
        return str.substring(str.length()-1, str.length());
    }

    // Returns the string that results from removing the first
//  and last characters from str
    public static String middleCharacters(String str) {
        return str.substring(1, str.length()-1);
    }

    public static boolean isPalindrome(String str) {
        if(str.length() <= 1) {
            return true;
        }

        if(firstCharacter(str).equals(lastCharacter(str))) {
            return isPalindrome(middleCharacters(str));
        } else {
            return false;
        }
        // base case #1
        // base case #2
        // recursive case
    }

    public static void checkPalindrome(String str) {
        out.println("Is this word a palindrome? " + str);
        out.println(isPalindrome(str));
    }
}
