package prep;

public class numToTitle {
	
	public static void main(String args[])
	{
		numToTitle o = new numToTitle();
		o.convertToTitle(730);
	}
	public String convertToTitle(int a) {
	    if(a==0) return "";
	    StringBuilder sb = new StringBuilder();
	    while(a>0)
	    {
	    	a--;
	        System.out.println(a%26);
	        char ch = (char)(a%26 + 'A');
	        sb.append(ch);
	        a/=26;
	    }
	    return sb.reverse().toString();
	}

}
