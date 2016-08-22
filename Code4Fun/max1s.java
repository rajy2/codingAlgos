package prep;

import java.util.ArrayList;
import java.util.Arrays;

public class max1s {
	public static void main(String[] args)
	{
		max1s o =new max1s();
		ArrayList<Integer> a= new ArrayList<>();
		a.addAll(Arrays.asList(1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0 ));
		o.maxone(a, 4);
	}
	public ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {
	    int left=0, right=0,noOfZeros=0;
	    int maxIndex=0, minIndex=0;
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    for(right =0; right<a.size(); right++)
	    {
	        if(noOfZeros<=b)
	        {
	            if(a.get(right) == 0) noOfZeros++;
	        }
	        else if(noOfZeros>b)
	        {
	            if(a.get(left) == 0) noOfZeros--;
	            left++;
	        }
	        if(right-left > (maxIndex-minIndex))
	        {
	            minIndex = left;
	            maxIndex=right;
	       }
	    }
	    for(int i = minIndex; i<=maxIndex; i++)
	    {
	        res.add(i);
	    }
	    return res;
}
}
