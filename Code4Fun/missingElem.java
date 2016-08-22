package prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class missingElem {

	public static void main(String[] args){
		missingElem obj = new missingElem();
		List<Integer> arr = new ArrayList<Integer>();
		arr.addAll(Arrays.asList(3,1,2,5,3));
		obj.repeatedNumber(arr);
	}
	
	public void repeatedNumber(final List<Integer> a) {
		HashSet<Integer> ab = new HashSet<Integer>(a);
		//System.out.println(ab.size() + " " + a.size());
		int sum = 0;
		for(Integer x: ab)
		{
			sum+=x;
		}
		int n = a.size();
		int reqSum = n*(n+1)/2;
		int elemReq = reqSum - sum;
		System.out.println(elemReq);
	}
}
