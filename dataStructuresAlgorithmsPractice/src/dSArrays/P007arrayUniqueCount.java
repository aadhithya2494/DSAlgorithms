package dSArrays;

import org.junit.Test;
import java.util.*;

public class P007arrayUniqueCount {
	
	/**
	 * 5) Given an array of integers arr, write a function that returns true if and only if the number of occurrences of each value in the array is unique.
	 * Example 1:
	 * Input: arr = [1,2,2,1,1,3]
	 * Output: true
	 */
	
	/**
	 * Solution 1: Use count array
	 * Solution 2: Add to map and determine
	 */
	
	@Test 
	public void test1() {
		int[] input = {1,2,2,1,1,3};
		System.out.println(mapMethod(input));
	}
	
	@Test 
	public void test2() {
		int[] input = {1,2,1,1,3};
		System.out.println(mapMethod(input));
	}

	private boolean mapMethod(int[] input) {
		Map<Integer,Integer> map = new HashMap<>();
		Set<Integer> set = new HashSet<>();
		for (int i : input) {
			map.put(i, map.getOrDefault(i, 0)+1);
		}
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			if(!set.add(entry.getValue())) return false;
		}
		return true;
	}

}
