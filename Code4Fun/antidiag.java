package prep;

import java.util.ArrayList;
import java.util.Arrays;

public class antidiag {
	public static void main(String args[])
	{
		int n = 1234;
		int length = (int)(Math.log10(n)+1);
		System.out.println(length);
		antidiag obj = new antidiag();
		ArrayList<ArrayList<Integer>> a = new ArrayList<>();
		a.add(new ArrayList<Integer>(Arrays.asList(1,2,3)));
		a.add( new ArrayList<Integer>(Arrays.asList(4,5,6)));
		a.add( new ArrayList<Integer>(Arrays.asList(7,8,9)));
		obj.diagonal(a);
	}

	public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    for(int j = 0; j<a.get(0).size();j++)
	    {
	    	int row=0, col =j;
	        res.add(new ArrayList<Integer>());
		    res.get(res.size()-1).add(a.get(0).get(j));
	            while(row+1<a.size() && col-1>=0)
	            {
	                res.get(res.size()-1).add(a.get(row+1).get(col-1));
	                row++;
	                col--;
	            }
	        }
	    for(int j = 1; j<a.size();j++)
	        {
	        	int row = j;
	        	int col = a.get(0).size()-1;
	        	res.add(new ArrayList<Integer>());
		        res.get(res.size()-1).add(a.get(j).get(col));
	            while(row+1<a.size() && col-1>=0)
	            {
	                res.get(res.size()-1).add(a.get(row+1).get(col-1));
	                row++;
	                col--;
	            }
	        }
	    
	    for(int i = 0; i<res.size();i++)
	    {
	    	for(Integer in: res.get(i))
	    	{
	    		System.out.print(in + " ");
	    	}
	    	System.out.println();
	    }
	    return res;
	}
}
