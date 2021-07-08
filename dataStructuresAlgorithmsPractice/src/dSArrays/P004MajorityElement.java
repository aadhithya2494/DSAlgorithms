package dSArrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class P004MajorityElement {
	/**
	 * Problem Description: 
	 * Given an array nums of size n, return the majority element. 
	 * You may assume that the majority element always exists in the array.
	 * The majority element is the element that appears more than ⌊n / 2⌋ times
	 * 
	 * Reference: 
	 */
	
	/**
	 * Solution 1: Sort and return mid element
	 * Solution 2: Map
	 */
	
	@Test
	public void test1(){
		int[] input = {1,1,1,2,2};
		System.out.println("Map Method:"+ mapMethod(input));
		System.out.println("Sort Method:"+ sortMethod(input));
	}
	
	@Test
	public void test2(){
		int[] input = {1,1,1,1,2,2};
		System.out.println("Map Method:"+ mapMethod(input));
		System.out.println("Sort Method:"+ sortMethod(input));
	}
	@Test
	public void test3(){
		int[] input = {2};
		System.out.println("Map Method:"+ mapMethod(input));
		System.out.println("Sort Method:"+ sortMethod(input));
	}

	private int sortMethod(int[] input) {
		Arrays.sort(input);
		return input[((input.length%2) == 0)?(input.length)/2:((input.length)-1)/2];
		/**
		 * Time Complexity: O[n log n]
		 * Space Complexity: O[1]
		 */
	}

	private int mapMethod(int[] input) {
		//if(input.length == 1) return input[0];
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i < input.length; i++) {
			map.put(input[i], map.getOrDefault(input[i], 0)+1);
			if(map.get(input[i]) > (input.length)/2) return input[i];
		}
		return 0;
		/**
		 * Time Complexity: O[n]
		 * Space Complexity: O[n]
		 */
	}
	
	
}
