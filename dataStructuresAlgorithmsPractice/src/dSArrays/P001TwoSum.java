package dSArrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class P001TwoSum {

	/**
	 * Problem Description: 
	 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
	 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
	 * You can return the answer in any order.
	 * 
	 * Reference: https://leetcode.com/problems/two-sum/
	 */
	
	/**
	 * Solution 1: Bruteforce using nested for loops
	 * Solution 2: Use hashmap, Store the value and index as key value pair and iterate over map to check if difference is present in map
	 * Solution 3: Use hashmap, Check if difference is present if so return and if not Store the value and index as key value pair
	 */

	@Test
	public void test1() {
		int[] input = {1,2,3,4,5,6};
		int target = 7;
		System.out.println("BruteForce: "+Arrays.toString(bruteForce(input,target)));
		System.out.println("2Pass: "+Arrays.toString(hashMapTwoPass(input,target)));
		System.out.println("1Pass: "+Arrays.toString(hashMapOnePass(input,target)));
	}
	
	@Test
	public void test2() {
		int[] input = {1,2,3,4,5,6};
		int target = 10;
		System.out.println("BruteForce: "+Arrays.toString(bruteForce(input,target)));
		System.out.println("2Pass: "+Arrays.toString(hashMapTwoPass(input,target)));
		System.out.println("1Pass: "+Arrays.toString(hashMapOnePass(input,target)));
	}
	
	@Test
	public void test3() {
		int[] input = {1,2,3,4,5,6};
		int target = 101;
		System.out.println("BruteForce: "+Arrays.toString(bruteForce(input,target)));
		System.out.println("2Pass: "+Arrays.toString(hashMapTwoPass(input,target)));
		System.out.println("1Pass: "+Arrays.toString(hashMapOnePass(input,target)));
	}

	private int[] bruteForce(int[] input, int target) {
		for(int i = 0; i< input.length; i++) {
			for(int j = i+1; j<input.length; j++) {
				if(input[i] + input[j] == target) {
					return new int[] {i,j};
				}
			}
		}
		return new int[] {-1,-1};
		/**
		 * Time Complexity: O[n^2]
		 * Space Complexity: O[n]
		 */
	}

	private int[] hashMapTwoPass(int[] input, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < input.length; i++) {
			map.put(input[i], i);
		}
		for (int i = 0; i < input.length; i++) {
			int difference = target - input[i];
			if (map.containsKey(difference) && map.get(difference) != i) {
				return new int[] { i, map.get(difference) };
			}
		}
		return new int[] {-1,-1};
		/**
		 * Time Complexity: O[2n]
		 * Space Complexity: O[n]
		 */
	}

	private int[] hashMapOnePass(int[] input, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < input.length; i++) {
			int difference = target - input[i];
			if (map.containsKey(difference)) {
				return new int[] { map.get(difference), i };
			}
			map.put(input[i], i);
		}
		return new int[] {-1,-1};
		/**
		 * Time Complexity: O[n]
		 * Space Complexity: O[n]
		 */
	}





}
