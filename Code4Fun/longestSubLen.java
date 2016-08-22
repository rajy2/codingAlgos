package prep;

import java.util.LinkedHashSet;

public class longestSubLen {
	public static void main(String[] args)
	{
		longestSubLen o = new longestSubLen();
		o.lengthOfLongestSubstring("dadbc");
	}
	public int lengthOfLongestSubstring(String a) {
	    LinkedHashSet<Character> unique = new LinkedHashSet<Character>();
	    int len =0,maxLen=0,start=0;
	    for(int i = 0; i<a.length();i++)
	    {
	        if(unique.contains(a.charAt(i))) 
	        {
	            len=0;
	            while(unique.contains(a.charAt(i))) 
	            {
	                unique.remove(a.charAt(start));
	                start++;
	            }
	            unique.add(a.charAt(i));
	        }
	        else {
	            unique.add(a.charAt(i));
	            len++;
	        }
	        maxLen= Math.max(unique.size(),maxLen);
	    }
	    System.out.println(maxLen);
	    return maxLen;
	}
}
