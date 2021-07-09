package dSArrays;

import java.util.Arrays;

import org.junit.Test;

public class P008numbersSmallerthanArrayElement {
	/**
	 * Problem Reference: https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
	 */

	/**
	 * Solution 1: Bruteforce 2 for loops
	 * Solution 2: Array sort and determine
	 * Solution 3: Count Array method
	 */
	@Test
	public void test1() {
		int[] nums = {8,1,2,2,3};
		System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
	}
	
	 public int[] smallerNumbersThanCurrent(int[] nums) {
	        int[] count = new int[101];
	        int[] output = new int[nums.length];
	        for(int i = 0; i< nums.length; i++){
	            count[nums[i]]++;
	        }
	        for(int i = 1; i< count.length; i++){
	            count[i]+= count[i-1];
	        }
	        for(int i = 0; i< nums.length; i++){
	            if(nums[i] == 0) output[i] = 0;
	            else output[i] = count[nums[i] - 1];
	        }  
	     return output;   
	    }
}
