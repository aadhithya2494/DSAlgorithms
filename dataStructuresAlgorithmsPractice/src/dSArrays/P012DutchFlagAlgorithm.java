package dSArrays;

import java.util.Arrays;

import org.junit.Test;

public class P012DutchFlagAlgorithm {

	/**
	 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
		We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

		Example 1:
		Input: nums = [2,0,2,1,1,0]
		Output: [0,0,1,1,2,2]
	 */

	@Test
	public void test1() {
		int[] input = {2,0,2,1,1,0};
		System.out.println(Arrays.toString(dutchFlag(input)));
	}

	private int[] dutchFlag(int[] input) {
		int low = 0, mid = 0, high = input.length-1;
		while(mid<=high) {
			switch(input[mid]) {
					case 0:{
						int temp = input[low];
						input[low++] = input[mid];
						input[mid++] = temp;
						break;
					}
					case 1:{
						mid++;
						break;
					}
					case 2:{
						int temp = input[mid];
						input[mid] = input[high];
						input[high--] = temp;
						break;
					}
			}
		}
		return input;
	}

}
