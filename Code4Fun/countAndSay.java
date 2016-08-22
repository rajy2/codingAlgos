package prep;

public class countAndSay {
	public static void main(String args[])
	{
		countAndSay o=new countAndSay();
		o.countAndSay(4);
	}
	public String countAndSay(int a) {
	    if(a==1) return "1";
	    if(a==2) return "11";
	    String prev = "11";
	    StringBuilder curr = new StringBuilder();
	    int count=1, j;
	    for(int i = 2; i<a;i++)
	    {
	        for(j = 1; j<prev.length();j++)
	        {
	            while(j<prev.length() && prev.charAt(j) == prev.charAt(j-1)) 
	            {
	                count++;
	                j++;
	            }
	            System.out.println(count +" "+ prev.charAt(j-1));
	            curr.append(count);
	            curr.append(prev.charAt(j-1));
	            count=1;
	        }
	        if(j==prev.length()) curr.append("1"+prev.charAt(j-1));
	        prev=curr.toString();
	        curr=new StringBuilder();
	    }
	    System.out.println(prev.toString());
	    return prev.toString();
	}

}
