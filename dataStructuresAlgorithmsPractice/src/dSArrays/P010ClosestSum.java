package dSArrays;

import java.util.Arrays;

import org.junit.Test;

public class P010ClosestSum {

	@Test
	public void test1() {
		int[] input = {34,23,1,24,75,33,54,8};
		int target = 60;
		System.out.println(bruteForce(input,target));
		System.out.println(twoPointer(input,target));
	}

	//@Test
	public void test2() {
		int[] input = {10,20,30};
		int target = 5;
		System.out.println(bruteForce(input,target));
		System.out.println(twoPointer(input,target));
	}

	private int bruteForce(int[] input, int target) {
		int output = Integer.MIN_VALUE;
		for (int i = 0; i < input.length; i++) {
			for (int j = i+1; j < input.length; j++) {
				if(input[i] + input[j] < target) {
					output = Math.max(output, (input[i]+input[j]));
				}

			}
		}
		return output> Integer.MIN_VALUE ? output : -1;
	}

	private int twoPointer(int[] input, int target) {
		Arrays.sort(input);
		int output =  Integer.MIN_VALUE;
		int left=0, right = input.length-1;
		if(input[left] > target) return -1;
		//1,8,23,24,33,34,54,75

		while(left<right) {
			if(input[left]+input[right] < target) {
				output = Math.max(output, (input[left]+input[right]));
			}
			if(input[left] + input[right] > target) right--;
			else left++;

		}

		return output;
	}



}
