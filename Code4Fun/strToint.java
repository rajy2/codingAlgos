package prep;

public class strToint {
	public static void main(String[] args)
	{
		strToint o = new strToint();
		System.out.println(o.atoi("-54332872018247709407 4 54"));
		
	}
	public int atoi(final String a) {
	    if(a.length()==0) return 0;
	    int j = 0;
	    long val=0;
	    boolean isNeg = false;
	    while(j<a.length() && a.charAt(j) == ' ' && !(a.charAt(j) == '-') && !(a.charAt(j) =='+')) j++;
	    if(a.charAt(j) == '-') 
	    {
	        isNeg=true;
	        j++;
	    }
	    if(a.charAt(j) =='+') j++;
	    //System.out.println(j);
	    for(int i = j; i<a.length(); i++)
	    {
	        if(!(a.charAt(i) >= '0' && a.charAt(i)<='9')) break;
	        val = (val*10) + ((int)a.charAt(i) - '0');
	        if(isNeg && (val*-1) < Integer.MIN_VALUE) return Integer.MIN_VALUE;
	        else if(val > Integer.MAX_VALUE) return Integer.MAX_VALUE;
	    }
	    if(isNeg) return (int)val*-1;
	    return (int)val;
	}

}
