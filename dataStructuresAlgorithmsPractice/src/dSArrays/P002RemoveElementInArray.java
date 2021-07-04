package dSArrays;

import java.util.Arrays;

import org.junit.Test;

public class P002RemoveElementInArray {
	/**
	 * Problem Description: 
	 * Given an array of integers and a number, remove all the occurrence of element in that array 
	 * 
	 * Reference: 
	 */
	
	/**
	 * Solution 1: Initialize count to get the total occurrence of element, create output array and add all elements - 2 pass
	 * Solution 2: Use 2 pointers to solve in 1Pass
	 */
	
	@Test
	public void test1() {
		int input[] = {1,2,3,4,5,6};
		int remove = 3;
		System.out.println(Arrays.toString(removeTarget(input,remove)));
	}
	
	private int[] removeTarget(int[] input, int remove) {
		int count = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] == remove) count++;
		}
		if (count ==0) return input;
		int[] output = new int[input.length - count];
		count = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] != remove) output[count++] = input[i];
		}
		return output;
		/**
		 * Time Complexity: O[2n]
		 * Space Complexity: O[1]
		 */
	}
}
