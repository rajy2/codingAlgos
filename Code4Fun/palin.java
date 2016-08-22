package prep;

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
	        System.out.println(factor);
	    }
	    int m = factor;
	    int n = 10;
	    
	    //while(factor>=m/2)
	    while(a>1)
	    {
	        if(a/factor != a%n) return false;
	        a=(a%factor)/10;
	        factor = factor/100;
	        
	    }
	    System.out.println("true");
	    return true;
	}

}
