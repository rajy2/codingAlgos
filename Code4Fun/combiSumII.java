/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

 Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ? a2 ? … ? ak).
The solution set must not contain duplicate combinations.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class combiSumII {
	
	public static void main(String[] args)
	{
		ArrayList<Integer> a = new ArrayList<>();
		a.addAll(Arrays.asList(7,8,10,6,11,1,16,8));
		combiSumII o = new combiSumII();
		Collections.sort(a);
		ArrayList<ArrayList<Integer>> r = o.combinationSum(a, 28);
		for(ArrayList<Integer> res: r)
		{
			for(Integer z:res)
			{
				System.out.print(z + " ");
			}
			System.out.println();
		}
	}
	
	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if(a.size()==0) return res;
		ArrayList<Integer> temp = new ArrayList<>();
		getComboS(a,b,res,0,temp);
		return res;
	}

	private void getComboS(ArrayList<Integer> a, int b, ArrayList<ArrayList<Integer>> res, int i,ArrayList<Integer> temp) {
		if(b==0)
		{
			ArrayList<Integer> t = new ArrayList<>(temp);
			Collections.sort(t);
			if(!res.contains(t)) res.add(t);
			return;
		}
		for(int j=i; j<a.size();j++)
		{
			if(a.get(j)>b) continue;
			temp.add(a.get(j));
			getComboS(a, b-a.get(j), res, j, temp);
			temp.remove(temp.size()-1);
		}
	}

}
