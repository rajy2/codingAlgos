/*
How many minimum numbers from fibonacci series are required such that sum of numbers should be equal to a given Number N?
Note : repetition of number is allowed.

Example:

N = 4
Fibonacci numbers : 1 1 2 3 5 .... so on
here 2 + 2 = 4 
so minimum numbers will be 2 
*/

import java.util.ArrayList;
import java.util.Arrays;

public class MinFibNosForSum {
	public static void main(String[] args)
	{
		MinFibNosForSum o  = new MinFibNosForSum();
		o.fibsum(4);
	}
	
	public int fibsum(int a) {
	    if(a==0) return 0;
	    if(a==1) return 1;
	    int x,y=x=1,z;
	    ArrayList<Integer> fibNos = new ArrayList<Integer>();
	    fibNos.addAll(Arrays.asList(x,y));
	    while(true)
	    {
	        z=x+y;
	        if(z<=a) fibNos.add(z);
	        else break;
	        x=y;
	        y=z;
	    }   
	    int index=fibNos.size()-1;
	    int noReq=0;
	    while(a>0)
	    {
	        if(fibNos.get(index) <= a)
	        {
	            noReq += a/fibNos.get(index);
	            a=a%fibNos.get(index);
	        }
	        index--;
	    }
	    return noReq;
	}

}
