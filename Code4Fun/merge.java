package prep;

import java.util.ArrayList;
import java.util.Arrays;

public class merge {
	public static void main(String args[])
	{
		merge o= new merge();
		ArrayList<Integer> a= new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();
		a.addAll(Arrays.asList(-4,3));
		b.addAll(Arrays.asList(-2,-2));
		o.merge(a, b);
	}
	public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
	    int i, j=i=0;

	    while(i<a.size() && j<b.size())
	    {
	        if(a.get(i).intValue() == b.get(j).intValue())
	        {
	            if(i+1<a.size()) a.add(i+1,b.get(i));
	            else a.add(b.get(j));
	            i++;
	            j++;
	        }
	        else if(a.get(i).compareTo(b.get(j)) >0)
	        {
	            a.add(i,b.get(j));
	            j++;
	            i++;
	        }
	        else i++;
	    }
	}

}
