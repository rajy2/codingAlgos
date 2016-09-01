/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Given n = 3,

You should return the following matrix:
 [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ] 
*/

import java.util.ArrayList;

public class spiralmatcreate {
	
	public static void main(String[] args)
	{
		spiralmatcreate obj = new spiralmatcreate();
		obj.generateMatrix(4);
	}
	
	public ArrayList<ArrayList<Integer>> generateMatrix(int a) {
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    int dir = 0, top = 0, bottom = a-1, left = 0, right = a-1, n= 1;
	    for(int i = 0; i<a; i++)
	    {
	        res.add(new ArrayList<Integer>());
	        for(int j =0; j<a; j++)
	        {
	        	res.get(i).add(0);
	        }
	    }
	    while(n<= a*a)
	    {
	        if(dir == 0)
	        {
	            //left->right
	            for(int i = left; i<=right; i++)
	            {
	                res.get(top).set(i,n++);
	            }
	            top++;
	        }
	        else if(dir == 1)
	        {
	            //top -> bottom
	            for(int i = top; i<=bottom; i++)
	            {
	                res.get(i).set(right,n++);
	            }
	            right--;
	        }
	        else if(dir == 2)
	        {
	            //right -> left
	            for(int i = right; i>=left; i--)
	            {
	                res.get(bottom).set(i,n++);
	            }
	            bottom--;
	        }
	        else if(dir == 3)
	        {
	            //bottom -> top
	            for(int i = bottom; i>=top; i--)
	            {
	                res.get(i).set(left,n++);
	            }
	            left++;
	        }
	        dir = (dir == 3)? 0:++dir;
	    }
	    for(int i = 0; i<res.size();i++)
	    {
	    	for(Integer ax : res.get(i))
	    	{
	    		System.out.print(ax + " ");
	    	}
	    	System.out.println();
	    
	    }
	    return res;
	    
	}

}
