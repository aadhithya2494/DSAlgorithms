package dSArrays;

import org.junit.Test;

public class P003IntegerPalindromeorNot {
	/**
	 * Problem Description: 
	 * Given an integer x, return true if x is palindrome integer 
	 * 
	 * Reference: 
	 */
	
	/**
	 * Solution 1: Convert to StringBuffer, reverse and conclude
	 * Solution 2: Math operations
	 * Solution 3: Convert to Int array and 2 pointer swap
	 */
	
	@Test
	public void test1() {
		int input = 121;
		System.out.println("String Method: "+stringMethod(input));
		System.out.println("Math Operations: "+mathMethod(input));
		System.out.println("Two pointer: "+twoPointer(input));
	}
	
	@Test
	public void test2() {
		int input = 1231;
		System.out.println("String Method: "+stringMethod(input));
		System.out.println("Math Operations: "+mathMethod(input));
		System.out.println("Two pointer: "+twoPointer(input));
	}
	
	@Test
	public void test3() {
		int input = 123454321;
		System.out.println("String Method: "+stringMethod(input));
		System.out.println("Math Operations: "+mathMethod(input));
		System.out.println("Two pointer: "+twoPointer(input));
	}
	
	@Test
	public void test4() {
		int input = 123454321;
		System.out.println("String Method: "+stringMethod(input));
		System.out.println("Math Operations: "+mathMethod(input));
		System.out.println("Two pointer Operations: "+twoPointer(input));
	}
	
	@Test
	public void test5() {
		int input = 1;
		System.out.println("String Method: "+stringMethod(input));
		System.out.println("Math Operations: "+mathMethod(input));
		System.out.println("Two pointer Operations: "+twoPointer(input));
	}



	private boolean stringMethod(int input) {
		StringBuffer ip = new StringBuffer(input+"");
		StringBuffer rev = new StringBuffer(ip);
		rev.reverse();
		return ip.toString().equals(rev.toString());
		/**
		 * Time Complexity: O[n]
		 * Space Complexity: O[1]
		 */
	}
	
	private boolean mathMethod(int input) {
		int rev = 0;
		int temp = input;
		while(temp > 0) {
			rev = (rev*10) + (temp % 10);
			temp /= 10;
		}
		return input == rev;
		/**
		 * Time Complexity: O[n]
		 * Space Complexity: O[1]
		 */
	}
	
	private boolean twoPointer(int input) {
		int length = (input+"").length();
		int left = 0, right = length-1;
		int exp = (int) Math.pow(10, length-1);
		while(left<right) {
			if(input/exp != input%10) return false;
			input %= exp;
			input /= 10;
			exp /= 100;
			left++;
			right--;
		}
		return true;
		/**
		 * Time Complexity: O[n/2]
		 * Space Complexity: O[1]
		 */
	}
	
}
