/*
Validate if a given string is numeric.
*/

public class Validate {
	
	public static void main(String[] args)
	{
		Validate o = new Validate();
		String sm = "92233720368547758071";
		String e = "92233720368547758079";
		//e = "a";
		//System.out.println(e);
		System.out.println(Math.min(sm.length(), e.length()));
		//System.out.println(sm);
		//o.isNumber("1.1e+1");
	}
	
	public int isNumber(final String a) {
	    if(a.length() == 0) return 0;
	    int j=0;
	    while(j<a.length() && a.charAt(j) == ' ') j++;
	    //System.out.println(j);
	    if(j<a.length() && (a.charAt(j) == '-' || a.charAt(j) == '+')) j++;
	    if(j<a.length() && a.charAt(j) == 'e') return 0;
	    if(j==a.length()) return 0;
	    boolean eFound = false;
	    boolean decPoint = false;
	    for(int i=j; i<a.length();i++)
	    {
	        System.out.println(i);
	        if(a.charAt(i) == 'e')
	        {
	        	System.out.println(a.charAt(i+1) == '+');
	        	System.out.println(!(a.charAt(i+1) >= '0' && a.charAt(i+1) <= '9') || !((a.charAt(i+1) == '+') ||
	            		(a.charAt(i+1) == '-')));
	            if(eFound) return 0;
	            else if(i == a.length()-1) return 0;
	            else if(!(a.charAt(i+1) >= '0' && a.charAt(i+1) <= '9') && !((a.charAt(i+1) == '+') ||
	            		(a.charAt(i+1) == '-'))) return 0;
	            if(a.charAt(i+1) == '+' || a.charAt(i+1) == '-')
	            {
	                i=i+1;
	                eFound = true;
	            }
	            else eFound = true;
	        }
	        else if(a.charAt(i) == '.')
	        {
	            if(decPoint || eFound) return 0;
	            else if(i == a.length()-1) return 0;
	            else if(!(a.charAt(i+1) >= '0' && a.charAt(i+1) <= '9')) return 0;
	            else decPoint = true;
	        }
	        else if(!(a.charAt(i) >= '0' && a.charAt(i) <='9')) return 0;
	    }
	    return 1;
	}

}
