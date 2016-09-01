/*
Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class diff {
	public static void main(String[] args)
	{
		List<Integer> a = new ArrayList<Integer>();
		a.addAll(Arrays.asList(34,63, 64, 38, 65, 83, 50, 44, 18, 34, 71, 80, 22, 28, 20, 96, 33, 70, 0,
				25, 64, 96, 18, 2 ,53, 100, 24, 47, 98, 69, 60, 55, 8 ,38, 72, 94, 18, 68, 0, 53,
				18, 30, 86, 55, 13, 93, 15, 43, 73 ,68, 29));
		diff o = new diff();
		o.diffPossible(a, 97);
	}

	public int diffPossible(final List<Integer> a, int b) {
	    HashSet<Integer> m = new HashSet<>();
	    for(int i = 0; i<a.size(); i++)
	    {
	    	int ai = b+a.get(i);
	    	int aj = a.get(i) -b;
	        if(m.contains(ai) || m.contains(aj)) return 1;
	        	
	        else m.add(a.get(i));
	        
	    }
	    return 0;
	}
}
