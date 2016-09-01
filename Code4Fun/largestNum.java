/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
*/

import java.util.Arrays;
import java.util.Comparator;

public class largestNum {
	
	public static void main(String args[])
	{
		int[] nums = {0,0,0};
		largestNum obj = new largestNum();
		String str = obj.largestNumber(nums);
		System.out.println(str);
	}
	
	public String largestNumber(int[] nums) {
	    String[] strs = new String[nums.length];
	    for(int i=0; i<nums.length; i++){
	        strs[i] = String.valueOf(nums[i]);
	        System.out.println(strs[i]);
	    }
	 
	    Arrays.sort(strs, new Comparator<String>(){
	        public int compare(String s1, String s2){
	            String leftRight = s1+s2;
	            String rightLeft = s2+s1;
	            return rightLeft.compareTo(leftRight);
	 
	        }
	    });
	 
	    StringBuilder sb = new StringBuilder();
	    for(String s: strs){
	        sb.append(s);
	    }
	 
	    while(sb.charAt(0)=='0' && sb.length()>1){
	        sb.deleteCharAt(0);
	    }
	 
	    return sb.toString();
	}

}
