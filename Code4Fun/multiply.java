package prep;

public class multiply {
	public static void main(String[] args)
	{
		multiply o = new multiply();
		o.mul("9999", "9999");
	}
	public String multiply(String a, String b) {
	    if(a.length() == 0 || b.length() == 0) return "0";
	    if(a.length() <= b.length()) return mul(a,b);
	    else return mul(b,a);
	}
	
	private String mul(String a, String b)
	{
	    if(a.length() == 1 || b.length() == 1)
	    {
	        if(a.charAt(0) == '0' || b.charAt(0) == '0') return "0";
	    }
		StringBuilder count = new StringBuilder("aa");
	    StringBuilder res;
	    String prev = null;
	    StringBuilder temp = new StringBuilder();
	    int carry =0;
	    for(int i=a.length()-1; i>=0; i--)
	    {
	        temp = new StringBuilder();
	        res = new StringBuilder();
	        carry=0;
	        for(int j=b.length()-1; j>=0; j--)
	        {
	            int val = (a.charAt(i) - '0') * (b.charAt(j) - '0') + carry;
	            carry = val/10;
	            val = val%10;
	            res.insert(0,val);
	        }
	        if(carry>0) res.insert(0,carry);
	        if(prev != null && prev.length()>1)
	        {
	            int x = res.length()-1, c=0;
	            for(int r = 1; r<count.length(); r++)
	            {
	                System.out.println(count.length());
	            	temp.insert(0, (prev.charAt(prev.length()-r)));
		        }
	            for(int y = prev.length()-count.length(); y>=0; y--)
	            {
	                int sum = (prev.charAt(y) - '0') + (res.charAt(x) - '0') + c;
	                c = sum/10;
	                sum = sum%10;
	                temp.insert(0, sum);
	                x--;
	            }
	            if(x >= 0) 
	            {
	                int s = c+(res.charAt(x) - '0');
	                temp.insert(0, s);
	            }
	            else if(c>0) temp.insert(0,c);
	            prev = temp.toString();
	            count.append('a');
	        }
	        else prev = res.toString();
	    }
	    return prev;
	}

}
