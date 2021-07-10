package dsString;

import org.junit.Test;

public class P001determinePalindrome {

	@Test
	public void test1() {
		String test = "$M$$A$DA$M";
		System.out.println(twoPointer(test));
	}

	private boolean twoPointer(String test) {
		int left = 0, right = test.length()-1;
		while(left<=right) {
			while(!(Character.isLetterOrDigit(test.charAt(left)))){
				left++;
			}
			while(!(Character.isLetterOrDigit(test.charAt(right)))){
				right--;
			}
			if(test.charAt(left++) != test.charAt(right--)) return false;
		}
		return true;
	}
}