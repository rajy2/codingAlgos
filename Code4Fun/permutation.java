/*
Given a collection of numbers, return all possible permutations.
*/

import java.util.ArrayList;
import java.util.Arrays;

public class permutation {
	
	public static void main(String[] args)
	{
		permutation o = new permutation();
		ArrayList<Integer> num = new ArrayList<Integer>();
           num.addAll(Arrays.asList(1,2,3));
		o.permute(num);
	}
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
	    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	    if(a.size()==0) return res;
	    permute(a,res,0);
	    return res;
	}
	private void permute(ArrayList<Integer> a,ArrayList<ArrayList<Integer>> res, int start)
	{
	    if(start>=a.size())
	    {
	        ArrayList<Integer> temp = new ArrayList<Integer>(a);
	        res.add(temp);
	        return;
	    }
	    for(int i = start; i<a.size();i++)
	    {
	        if(i!=start)swap(i,start,a);
	        permute(a,res,start+1);
	        if(i!=start)swap(i,start,a);
	    }
	}
	private void swap(int i, int j, ArrayList<Integer> a)
	{
	    int tmp = a.get(i);
	    a.set(i,a.get(j));
	    a.set(j,tmp);
	}
}
