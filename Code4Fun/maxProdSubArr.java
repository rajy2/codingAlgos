package prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class maxProdSubArr {
	
	public static void main(String[] args)
	{
		maxProdSubArr o = new maxProdSubArr();
		List<Integer> a = new ArrayList<Integer>();
		a.addAll(Arrays.asList(2,3,-2,4,6,-2,-1,24));
		o.maxProduct(a);
	}
public int maxProduct(final List<Integer> a) {
	    
	    int[] max = new int[a.size()];
	    int[] min = new int[a.size()];
	    max[0] = min[0] = a.get(0);
	    int result = a.get(0);
	    
	    for(int i=1; i<a.size(); i++){
	        if(a.get(i)>0){
	            max[i]=Math.max(a.get(i), max[i-1]*a.get(i));
                min[i]=Math.min(a.get(i), min[i-1]*a.get(i));
                }else{
                    max[i]=Math.max(a.get(i), min[i-1]*a.get(i));
                    min[i]=Math.min(a.get(i), max[i-1]*a.get(i));
                }
        result = Math.max(result, max[i]);
    }
 
    return result;
	}

}
