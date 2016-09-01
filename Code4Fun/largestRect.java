/*
Given n non-negative integers representing the histogram’s bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
*/

import java.util.Stack;

public class largestRect {
	
	public static void main(String[] args)
	{
		largestRect o = new largestRect();
		ArrayList<Integer> h = new ArrayList<>();
           h.addAll(Arrays.asList(2,1,5,6,2,3));
		o.largestRectangleArea(h);
	}
	
	public int largestRectangleArea(ArrayList<Integer> a) {
	    Stack<Integer> s = new Stack<Integer>();
	    int max=0,i=0;
	    while(i<a.size())
	    {
	        if(s.isEmpty() || a.get(i) >= a.get(s.peek()))
	        {
	            s.push(i);
	            i++;
	        }
	        else{
	            int index = s.pop();
	            int height = a.get(index);
	            int width = s.isEmpty()? i : i-s.peek()-1;
	            max= Math.max(max,height*width);
	        }
	    }
	    while(!s.isEmpty())
	    {
	        int index = s.pop();
	        int height = a.get(index);
	        int width = s.isEmpty()? i : i-s.peek()-1;
	        max= Math.max(max, height*width);
	    }
	    return max;
	}

}
