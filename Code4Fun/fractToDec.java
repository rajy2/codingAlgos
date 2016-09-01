/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.
*/

import java.util.HashMap;

public class fractToDec {
	
	public static void main(String[] args)
	{
		fractToDec o  = new fractToDec();
		o.fractionToDecimal(87,22);
		
	}
	
	public String fractionToDecimal(int numerator, int denominator) {
	    StringBuilder res = new StringBuilder();
	    if(numerator == 0) return "0";
	    if(denominator == 0) return "";
	    if(numerator<0 ^ denominator<0) res.append("-");
	    long n = numerator, d=denominator;
	    n=Math.abs(n);
	    d=Math.abs(d);
	    long beDec = n/d;
	    res.append(String.valueOf(beDec));
	    long rem = (n%d)*10;
	    if(rem == 0) return res.toString();
	    res.append('.');
	    HashMap<Long, Integer> map = new HashMap<Long, Integer>();
	    while(rem!=0)
	    {
	        if(map.containsKey(rem))
	        {
	            int beg = map.get(rem);
	            String begin = res.toString().substring(0,beg);
	            String end =  res.toString().substring(beg,res.length());
	            String toRet = begin + "(" + end + ")"; 
	            return toRet;
	        }
	        map.put(rem,res.length());
	        long val = rem/d;
	        rem = (rem%d) *10;
	        res.append(String.valueOf(val));
	    }
	    return res.toString();
	}

}
