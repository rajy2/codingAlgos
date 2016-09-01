/*

You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.

Return A and B.
*/

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
	
	public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
	    long sumPresent = (long)a.get(0), sumSqPresent = (long)a.get(0) * (long)a.get(0), actualSum = 0l, actualSqSum = 0l;
	    for(int i =1; i<a.size(); i++)
	    {
	        sumPresent += (long)a.get(i);
	        sumSqPresent += (long)a.get(i) * (long)a.get(i);
	        actualSum += (long)i;
	        actualSqSum += (long)i*(long)i;
	    }
	    actualSum += (long)a.size();
	    actualSqSum += (long)a.size() * (long)a.size();
	    // actualSum = sumPresent + B - A
	    // => B-A = actualSum - sumPresent
	    long diff = actualSum - sumPresent;
	    // Bsq - Asq = (actualSum)sq - (sumPresent)sq
	    // => (B + A)(B -A) = (actualSum)sq - (sumPresent)sq
	    // => (B+A) = ((actualSum)sq - (sumPresent)sq)/B-A
	    long sum = (actualSqSum - sumSqPresent)/diff;
	    long B = (diff + sum)/(long)2;
	    long A = (sum - B);
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    res.add((int)A);
	    res.add((int)B);
	    return res;
	}
}
