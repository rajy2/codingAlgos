/*
Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.

Make sure the combinations are sorted.

To elaborate,
1. Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
2. Entries should be sorted within themselves.

Example :
If n = 4 and k = 2, a solution is:

[
  [1,2],
  [1,3],
  [1,4],
  [2,3],
  [2,4],
  [3,4],
]
*/

import java.util.ArrayList;
import java.util.Collections;

public class kCombos {
	
	public static void main(String[] args)
	{
		kCombos o = new kCombos();
		o.combine(4, 2);
	}
	
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    if(n==0) return res;
	    ArrayList<Integer> temp = new ArrayList<Integer>();
	    getCombos(n,k,res,temp, 0,1);
	    return res;
	}
	
	private void getCombos(int n, int k, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int i, int val)
	{
	    if(i==k)
	    {
	        ArrayList<Integer> t = new ArrayList<Integer>(temp);
	        Collections.sort(t);
	        if(!res.contains(t)) res.add(t);
	        return;
	    }
	    for(int j=val; j<=n;j++)
	    {
	        temp.add(j);
	        getCombos(n,k,res,temp,temp.size(),j+1);
	        temp.remove(temp.size()-1);
	    }
	}

}
