package dSArrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class P005IntersectionOfTwoArrays {

	/**
	 * Problem statement:
	 *  Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
	 *  Example 1
	 *  Input: nums1 = [1,2,2,1], nums2 = [2,2]
	 *  Output: [2]	
	 */
	/**
	 * Solution 1: Bruteforce using nested for loops with set
	 * Solution 2: Use couple of sets with 2 pass
	 */

	@Test
	public void test1() {
		Integer[] input1 = {1,2,2,1};
		Integer[] input2 = {2,2};
		System.out.println(Arrays.toString(bruteForce(input1, input2)));
		System.out.println(Arrays.toString(setMethod(input1, input2)));	
		System.out.println(Arrays.toString(twopointerMethod(input1, input2)));
	}

	private Object[] bruteForce(Integer[] input1, Integer[] input2) {
		Set<Integer> output = new HashSet<>();
		for (int i = 0; i < input2.length; i++) {
			for (int j = 0; j < input1.length; j++) {
				if(input2[i] == input1[j]) {
					output.add(input2[i]);
				}
			}	
		}
		return output.toArray();
		/**
		 * Time Complexity: O[n^2]
		 * Space Complexity: O[n]
		 */
	}

	private Object[] setMethod(Integer[] input1, Integer[] input2) {
		Set<Integer> in1 = new HashSet<Integer>(Arrays.asList(input1));
		Set<Integer> output = new HashSet<>();
		for (int i = 0; i < input2.length; i++) {
			if(!in1.add(input2[i])) output.add(input2[i]);
		}
		return output.toArray();
		/**
		 * Time Complexity: O[n]
		 * Space Complexity: O[n]
		 */
	}
	
	/**
	 * two pointer approach
	 * Time Complexity: O[n]
	 * Space Complexity: O[n]
	 */
	
	private Object[] twopointerMethod(Integer[] input1, Integer[] input2) {
		Set<Integer> output = new HashSet<>();
		Arrays.sort(input1);
		Arrays.sort(input2);
		int left = 0, right = 0;
		while(left<input1.length && right < input2.length) {
			if (input1[left] < input2[right])
                left++;
            else if (input2[right] < input1[left])
                right++;
            else {
               output.add(input2[right++]);
               left++;
            }
		}
		return output.toArray();
	}



}
