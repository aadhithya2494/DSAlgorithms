package dSArrays;

import org.junit.Test;
import java.util.*;

public class P009countAsperPattern {
	
	/**
	 * Given an integer array arr, count how many elements x there are, such that x + 1 is also in arr.
	 *  If there are duplicates in arr, count them separately.
	 *  
	 *  Example 1:
		Input: arr = [1,2,3]
		Output: 2
		Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
		Example 2:
		Input: arr = [1,1,3,3,5,5,7,7]
		Output: 0
		Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
		Example 3:
		Input: arr = [1,3,2,3,5,0]
		Output: 3
		Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
		Example 4:
		Input: arr = [1,1,2,2]
		Output: 2
		Explanation: Two 1s are counted cause 2 is in arr.
		Example 5:
		Input: arr = [1,1,2]
		Output: 2
		Explanation: Both 1s are counted because 2 is in the array.
	 */
	
	/**
	 * Solution : Add elements to Tree map and find the count
	 */
	
	@Test
	public void test1() {
		int[] input = {1,2,3};
		System.out.println("TreeMap method: " +treeMapMethod(input));
		System.out.println("Count Array method: "+countArrayMethod(input));
	}

	@Test
	public void test2() {
		int[] input = {1,1,3,3,5,5,7,7};
		System.out.println("TreeMap method: " +treeMapMethod(input));
		System.out.println("Count Array method: "+countArrayMethod(input));
	}
	
	@Test
	public void test3() {
		int[] input = {1,3,2,3,5,0};
		System.out.println("TreeMap method: " +treeMapMethod(input));
		System.out.println("Count Array method: "+countArrayMethod(input));
	}
	
	@Test
	public void test4() {
		int[] input = {1,1,2,2,4,5,5};
		System.out.println("TreeMap method: " +treeMapMethod(input));
		System.out.println("Count Array method: "+countArrayMethod(input));
	}
	
	private int treeMapMethod(int[] input) {
		int output = 0;
		Map<Integer,Integer> map = new TreeMap<>();
		for (int i : input) {
			map.put(i, map.getOrDefault(i, 0)+1);
		}
		List<Integer> keyList = new ArrayList<Integer>(map.keySet());
		for(int i = 1; i<map.size(); i++) {
			if(keyList.get(i) - keyList.get(i-1) == 1) output+= map.get(keyList.get(i-1));
		}
		return output;
	}
	
	
	private int countArrayMethod(int[] input) {
		int[] count = new int[10];
		int output =0;
		for (int i : input) {
			count[i]++;
		}
		for (int i = 1; i < count.length; i++) {
			if(count[i] !=0 && count[i-1]!=0)output += count[i-1];
		}
		return output;
	}
	
	

}
