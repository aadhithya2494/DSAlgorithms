package dSArrays;

import org.junit.Test;
import java.util.*;

public class P011happyNumber {

	/**
	 * Question: 
	 * Write an algorithm to determine if a number n is happy. A happy number is a number defined by the following process:
		Starting with any positive integer, replace the number by the sum of the squares of its digits.
		Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
		Those numbers for which this process ends in 1 are happy.
		Return true if n is a happy number, and false if not.
		
		Example 1:
		Input: n = 19
		Output: true
	 */
	
	/**
	 * Pseudocode
	 * Get number
	 *   while num is greater than 1
	 *   Create a set
	 * Split individually and square and add result to set.
	 * if set contains num return false
	 * else return true
	 */

	@Test
	public void test1() {
		int num = 91;
		System.out.println(isMagicNum(num));
	}

	@Test
	public void test2() {
		int num = 40;
		System.out.println(isMagicNum(num));
	}

	@Test
	public void test3() {
		int num = 28;
		System.out.println(isMagicNum(num));
	}

	@Test
	public void test4() {
		int num = 410;
		System.out.println(isMagicNum(num));
	}
	
	@Test
	public void test5() {
		int num = 1;
		System.out.println(isMagicNum(num));
	}
		/**
		 * Time complexity O[n*m]
		 * Space complexity O[n]
		 * @param num
		 * @return
		 */
	private boolean isMagicNum(int num) {
		Set<Integer> set = new HashSet<>();
		while(num > 1) {
			num = findSq(num);
			if(set.contains(num)) return false;
			set.add(num);
		}
		return true;
	}

	private static int  findSq(int num) {
		int sqr = 0, rem = 0;
		while(num > 0) {
			rem = num%10;
			sqr+= (rem*rem);
			num = num/10;
		}
		return sqr;
	}

}
