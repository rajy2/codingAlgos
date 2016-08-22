package prep;

public class reversenum {
	public static void main(String args[])
	{
		reversenum o = new reversenum();
	    o.reverse(-1234);
		
	}
	public int reverse(int a) {
	    boolean isNeg = false;
	    if(a<0)
	    {
	        isNeg = true;
	        a=Math.abs(a);
	    }
	    long res = 0l;
	    while(a>0)
	    {
	    	int digit = a%10;
	        res = res*10 + digit;
	        a=a/10;
	    }
	   if(isNeg) res =res*-1;
	    //System.out.println(Math.pow(2,31)*-1 + " " + (Math.pow(2,31) -1));
	   System.out.println(res); 
	   if(res <Integer.MIN_VALUE || res > Integer.MAX_VALUE) return 0;
	    else return (int)res;
	}

}
