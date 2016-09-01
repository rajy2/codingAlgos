/*
Given a set of distinct integers, S, return all possible subsets.

 Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class subset {
	
	public static void main(String[] args)
	{
		subset o = new subset();
		ArrayList<Integer> t = new ArrayList<>();
		t.addAll(Arrays.asList(5,4));
		o.subsets(t);
	}
	
	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    ArrayList<Integer> temp = new ArrayList<Integer>();
	    res.add(temp);
	    if(a.size()==0) return res;
	    Collections.sort(a);
	    generateSubsets(a,res,0,temp);
	    return res;
	}
	public void generateSubsets(ArrayList<Integer> a,ArrayList<ArrayList<Integer>> res, int index,ArrayList<Integer> temp)
	{
	    for(int i = index; i<a.size(); i++)
	    {
	        temp.add(a.get(i));
	        res.add(new ArrayList<Integer>(temp));
	        generateSubsets(a,res,i+1,temp);
	        temp.remove(temp.size()-1);
	    }
	}

}
