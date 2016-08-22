package prep;

import java.util.ArrayList;
import java.util.Arrays;

public class sum {
	
	public static void main(String args[])
	{
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.addAll(Arrays.asList(1,2,-8,1));
		sum obj = new sum();
		obj.maxset(arr);
	}
		public void maxset(ArrayList<Integer> a) {
			long maxSum = 0;
		    long newSum = 0;
		    ArrayList<Integer> maxArray = new ArrayList<Integer>();
		    ArrayList<Integer> newArray = new ArrayList<Integer>();
		    for (Integer i : a) {
		        if (i >= 0) {
		            newSum += i;
		            newArray.add(i);
		        } else {
		            newSum = 0;
		            newArray = new ArrayList<Integer>();
		        }
		        if ((maxSum < newSum) || ((maxSum == newSum) && (newArray.size() > maxArray.size()))) {
		            maxSum = newSum;
		            maxArray = newArray;
		        }
		    }
		    
		    ArrayList<Integer> toRet = new ArrayList<Integer>();
		    for(Integer abc : maxArray)
		    {
		    	
		        System.out.println(abc);
		    }
		    }
		    //return toRet;
		}
	


