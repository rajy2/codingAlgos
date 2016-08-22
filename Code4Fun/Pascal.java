package prep;

import java.util.ArrayList;

public class Pascal {
	public static void main(String[] args)
	{
		Pascal obj = new Pascal();
		obj.generate(3);
	}
	public ArrayList<ArrayList<Integer>> generate(int a) {
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    ArrayList<Integer> curr = new ArrayList<Integer>();
	    if(a == 0) return res; 
	    curr.add(1);
	    res.add(curr);
	    if(a == 1) return res;
	    curr = new ArrayList<Integer>();
	    curr.add(1);
	    curr.add(1);
	    res.add(curr);
	    if(a == 2) return res;
	    while(res.size() != a)
	    {
	        curr = new ArrayList<Integer>();
	        curr.add(1);
	        int prevSize = res.get(res.size() -1).size();
	        for(int i = 1; i< prevSize; i++)
	        {
	        	curr.add(res.get(i).get(i-1) + res.get(i).get(i));
	        }
	        curr.add(1);
	        res.add(curr);
	    }
	    return res;
	    
	} 
	}


