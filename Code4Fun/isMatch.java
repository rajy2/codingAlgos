package prep;

public class isMatch {
	
	public static void main(String[] args)
	{
		isMatch o = new isMatch();
		o.isMatch("aab", "c*a*b");
	}
	
	public int isMatch(final String s, final String p) {
	    if(p.length()==0) return (s.length()==0)? 1:0;
	    if(p.length()==1 || p.charAt(1) !='*')
	    {
	        if(s.length()<1) return 0;
	        if(s.charAt(0) != p.charAt(0) && p.charAt(0)!='.') return 0;
	        else return isMatch(s.substring(1),p.substring(1));
	    }
	    else{
	        if(isMatch(s,p.substring(2)) == 1) return 1;
	        int i=0;
	        while(i<s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0)=='.'))
	        {
	            if(isMatch(s.substring(i+1),p.substring(2)) ==1) return 1;
	            i++;
	        }
	        return 0;
	    }
	}

}
