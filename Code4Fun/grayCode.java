/*
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
There might be multiple gray code sequences possible for a given n.
Return any such sequence.
*/

import java.util.ArrayList;
import java.util.List;

public class grayCode {
	
	public static void main(String[] args)
	{
		grayCode o = new grayCode();
		o.grayCode(10);
	}

	public ArrayList<Integer> grayCode(int a) {
	    if(a==0)
	    {
	        ArrayList<Integer> res = new ArrayList<Integer>();
	        res.add(0);
	        return res;
	    }
	    ArrayList<Integer> res = grayCode(a-1);
	    int numToAdd = 1<<(a-1);
	    for(int i = res.size()-1; i>=0;i--)
	    {
	        res.add(res.get(i)+numToAdd);
	    }
	    return res;
	}
}
