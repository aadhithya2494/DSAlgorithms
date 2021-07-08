package dSArrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.management.RuntimeErrorException;

import org.junit.Test;

public class P006MissingNumberFromArray {
	
	/**
	 * Problem statement:
	 *  Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
	 *  Example 1
	 *  Input: nums = [3,0,1]
	 *  Output: 2	
	 */
	/**
	 * Solution 1: Sort Array and find missing element
	 * Solution 2: Add all elements to a set, find starting and ending index and get the missing element
	 */
	
	@Test
	public void test1() {
		Integer[] input = {3,0,1};
		System.out.println(sortMethod(input));
		System.out.println(setMethod(input));
	}


	private int sortMethod(Integer[] input) {
		Arrays.sort(input);
		for (int i = 1; i < input.length; i++) {
			if ((input[i] - input[i-1]) != 1) {
				return input[i]-1;
			}
		}
		return 0;
		/**
		 * Time Complexity: O[n logn]
		 * Space Complexity: O[1]
		 */
	}
	
	private int setMethod(Integer[] input) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i = 0; i < input.length; i++) {
			min = Math.min(min, input[i]);
			max = Math.max(max, input[i]);
		}
		Set<Integer> set = new HashSet<>(Arrays.asList(input));
		for(int i = min; i<= max; i++) {
			if(set.add(i)) return i;
		}
		return 0;	
		/**
		 * Time Complexity: O[n]
		 * Space Complexity: O[n]
		 */
	}
	
	private int mathMethod(Integer[] input) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, sum = 0;;
		for (int i = 0; i < input.length; i++) {
			min = Math.min(min, input[i]);
			max = Math.max(max, input[i]);
			sum += input[i];
		}
		int diff = ((max*(max+1))/2) - ((min*(min+1))/2);
		if (diff-sum == 0) throw new RuntimeException( "No missing element");
		return diff - sum;	
		/**
		 * Time Complexity: O[n]
		 * Space Complexity: O[n]
		 */
	}

}
