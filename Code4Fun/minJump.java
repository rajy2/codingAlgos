/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example :
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

If it is not possible to reach the end index, return -1.
*/

import java.util.ArrayList;
import java.util.Arrays;

public class minJump {
	
	public static void main(String[] args)
	{
		minJump o = new minJump();
		ArrayList<Integer> a = new ArrayList<>();
		a.addAll(Arrays.asList(33, 21, 50, 0, 0, 46, 34, 3, 0, 12, 33, 0, 31, 37, 15, 17, 34, 18, 0, 4, 12, 41, 18, 35, 37, 34, 0, 47, 0, 39, 32, 49, 5, 41, 46, 26, 0, 2, 49, 35, 4, 19, 2, 27, 23, 49, 19, 38, 0, 33, 47, 1, 21, 36, 18, 33, 0, 1, 0, 39, 0, 22, 0, 9, 36, 45, 31, 4, 14, 48, 2, 33, 0, 39, 0, 37, 48, 44, 0, 11, 24, 16, 10, 23, 22, 41, 32, 14, 22, 16, 23, 38, 42, 16, 15, 0, 39, 23, 0, 42, 15, 25, 0, 41, 2, 48, 28 ));
		o.jump(a);
	}
	
	public int jump(ArrayList<Integer> a) {
	    
	
	if (a == null || (a.size() > 1 && a.get(0) == 0))
	        return -1;
	        
	    if (a.size() == 1)
	        return 0;
	        
	    int count = a.get(0);
	    int n=a.size();
	    int max = 0;
	    int steps = 0;
	    
	   
	    for (int i = 1; i < n; i++) {
	        
	        count--;
	        max--;
	        max = Math.max(max, a.get(i));
	        
	        if (i == n - 1) {
	            return steps + 1;
	        }
	        
	        if (count == 0) {
	            if (max < 0)
	                return -1;
	            
	            count = max;
	            max = 0;
	            steps++;
	        }
	        
	    }
        
        
	    
	    return steps;
	}

}
