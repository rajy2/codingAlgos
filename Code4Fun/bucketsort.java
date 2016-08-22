package prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bucketsort {
	
	public static void main(String args[])
	{
		List<Integer> a = new ArrayList<Integer>();
		a.addAll(Arrays.asList( 100, 100, 100, 100, 100 ));
		bucketsort obj = new bucketsort();
		obj.maximumGap(a);
	}
	
	public int maximumGap(final List<Integer> a) {
	    if(a.size() == 0 || a.size() == 1) return 0;
	    int max = a.get(0), min = a.get(0), maxGap=0;
	    for(int i = 0; i<a.size(); i++)
	    {
	        if(a.get(i)> max) max = a.get(i);
	    }
	    for(int i = 0; i<a.size(); i++)
	    {
	        if(a.get(i)<min) min = a.get(i);
	    }
	    // min+(n-1)*gap = max;
	    double gap = (double)(max - min)/(a.size()-1);
	    Bucket[] b= new Bucket[a.size()];
	    for(int i = 0; i<b.length; i++)
	    {
	        b[i] = new Bucket();
	    }
	    for(int i = 0; i<a.size(); i++)
	    {
	        //min + gap = a[i] => (a[i]-min)/gap
	        int index = (int)(a.get(i) - min)/(int)gap;
	        if(b[index].min==-1)
	        {
	            b[index].min = a.get(i);
	            b[index].max = a.get(i);
	        }
	        else{
	            b[index].min = Math.min(b[index].min, a.get(i));
	            b[index].max = Math.max(b[index].max,a.get(i));
	        }
	    }
	    for(int i = 0; i<b.length; i++)
	    {
	        System.out.println(b[i].min + " "+ b[i].max);
	    }
	    int high_val = b[0].max;
	    for(int i = 1;i< b.length; i++)
	    {
	        if(b[i].min != -1)
	        {
	            maxGap = Math.max(maxGap, b[i].min- high_val);
	            high_val = b[i].max;
	        }
	    }
	    System.out.println(maxGap);
	    return maxGap;
	}
}
class Bucket{
    int max; 
    int min;
    Bucket()
    {
        min= -1;
        max= -1;
    }

}
