/*
Determine whether an integer is a palindrome. Do this without extra space.

A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed.
Negative numbers are not palindromic.
*/

public class palin {
	public static void main(String args[])
	{
		palin o = new palin();
		o.isPalindrome(2147447412);
	}
	public boolean isPalindrome(int a) {
	    if(a<0) return false;
	    if(a<9) return true;
	    int res = a;
	    int factor = 1;
	    while(res>9)
	    {
	        res = res/10;
	        factor = factor*10;
	    }
	    
	    while(a!=0)
	    {
	        if(a/factor != a%10) return false;
	        a=(a%factor)/10;
	        factor = factor/100;
	    }
	    return true;
	}

}
