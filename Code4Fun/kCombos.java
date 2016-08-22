package prep;

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
