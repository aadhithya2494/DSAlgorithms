package dSArrays;

import org.junit.Test;
import java.util.*;

public class P013uniqueOccuranceNumberInArray {
		/**
		 * Given a non-empty array of integers nums, every element appears twice except for one. 
		 * Find that single one.
		 * You must implement a solution with a linear runtime complexity and use only constant extra space.
		 * 
		 * Example 1:
				Input: nums = [2,2,1]
				Output: 1
		 */
	
	@Test
	public void test1() {
		int input[] = {2,2,1};
		System.out.println(findUniqueElement(input));
	}

		private int findUniqueElement(int[] input) {
			int left = 0, right = input.length-1;
			Map<Integer,Integer> map = new HashMap<>();
			while(left<=right) {
				if(left == right) {
					map.put(input[left], map.getOrDefault(input[left++], 0)+1);
					break;
				}
				map.put(input[left], map.getOrDefault(input[left++], 0)+1);
				map.put(input[right], map.getOrDefault(input[right--], 0)+1);
			}
			for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
				if(entry.getValue() ==1) return entry.getKey();
			}
			return -1;
		}
}
