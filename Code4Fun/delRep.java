/*

import java.util.ArrayList;
import java.util.Arrays;
/*
Remove Duplicates from Sorted Array

Given a sorted array, remove the duplicates in place such that each element can appear atmost twice and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

Note that even though we want you to return the new length, make sure to change the original array as well in place

For example,
Given input array A = [1,1,1,2],

Your function should return length = 3, and A is now [1,1,2].
*/

public class delRep {
	public static void main(String[] args)
	{
		ArrayList<Integer> a= new ArrayList<>();
		delRep o = new delRep();
		a.addAll(Arrays.asList(1000,1000,1000,1000,1001,1002,1003,1003,1004,1010));
		o.removeDuplicates(a);
	}
	public int removeDuplicates(ArrayList<Integer> a) {
	    int j = 0, count=1;
	    for(int i =0; i<a.size(); i++)
	    {
	        if(i<a.size()-1 && a.get(i).intValue() == a.get(i+1).intValue()) 
	        {
	            count++;
	            continue;
	        }
	        else 
	        {
	            if(count >=2)
	            {
	                a.set(j, a.get(i));
	                a.set(j+1, a.get(i));
	                j++;
	                count=1;
	            }
	            else{
	                a.set(j, a.get(i));
	            }
	            j++;
	            System.out.println(j);
	        }
	    }
	    return j;
	}

}
