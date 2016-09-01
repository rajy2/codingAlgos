/*
You are given a string, S, and a list of words, L, that are all of the same length.

Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class substringConcat {
	
	public static void main(String[] args)
	{
		substringConcat o = new substringConcat();
		String[] words = {"foo", "bar"};
		o.findSubstring("barfoothefoobarman ", words);
	}
	public ArrayList<Integer> findSubstring(String a, final List<String> b) {
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    if(a==null||a.length() ==0 || b==null || b.size()==0) return res;
	    HashMap<String, Integer> words = new HashMap<String, Integer>();
	    for(String s: b)
	    {
	        if(words.containsKey(s)) words.put(s,words.get(s)+1);
	        else words.put(s,1);
	    }
	    int l = b.get(0).length();
	    for(int i = 0; i<l;i++)
	    {
	        int start = i;
	        int count=0;
	        HashMap<String, Integer> curr = new HashMap<String, Integer>();
	        for(int j = i; j<=a.length()-l; j=j+l)
	        {
	            String sub = a.substring(j,j+l);
	            if(words.containsKey(sub))
	            {
	                if(curr.containsKey(sub)) curr.put(sub, curr.get(sub)+1);
	                else curr.put(sub,1);
	                count++;
	                while(curr.get(sub) > words.get(sub))
	                {
	                    String rem = a.substring(start, start+l);
	                    curr.put(rem, curr.get(rem)-1);
	                    count--;
	                    start=start+l;
	                }
	                if(count == b.size())
	                {
	                    res.add(start);
	                    String rem = a.substring(start, start+l);
	                    curr.put(rem, curr.get(rem)-1);
	                    count--;
	                    start=start+l;
	                }
	            }
	            else{
	                count=0;
	                start=j+l;
	                curr.clear();
	            }
	        }
	    }
	    return res;
	}

}
