package prep;

import java.util.ArrayList;
import java.util.Arrays;

public class delRep {
	public static void main(String[] args)
	{
		ArrayList<Integer> a= new ArrayList<>();
		delRep o = new delRep();
		a.addAll(Arrays.asList(1000,1000,1000,1000,1001,1002,1003,1003,1004,1010));
		o.removeDuplicates(a);
	}
	public int removeDuplicates(ArrayList<Integer> a) {
	    int j = 0, count=1;
	    for(int i =0; i<a.size(); i++)
	    {
	        if(i<a.size()-1 && a.get(i).intValue() == a.get(i+1).intValue()) 
	        {
	            count++;
	            continue;
	        }
	        else 
	        {
	            if(count >=2)
	            {
	                a.set(j, a.get(i));
	                a.set(j+1, a.get(i));
	                j++;
	                count=1;
	            }
	            else{
	                a.set(j, a.get(i));
	            }
	            j++;
	            System.out.println(j);
	        }
	    }
	    return j;
	}

}
