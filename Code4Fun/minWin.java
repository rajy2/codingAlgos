package prep;

import java.util.HashMap;

public class minWin {
	
	public static void main(String[] args)
	{
		minWin o =new minWin();
		o.minWindow("acbbaca", "aba5");
	}
	
	public String minWindow(String S, String T) {
	    int count=0, minWin=Integer.MAX_VALUE,start =0;
	    StringBuilder res = new StringBuilder();
	    HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
	    HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
	    for(int i = 0; i<T.length();i++)
	    {
	    	if(tMap.containsKey(T.charAt(i)))
	        {
	            int val = tMap.get(T.charAt(i));
	            tMap.put(T.charAt(i), val+1);
	        }
	        else tMap.put(T.charAt(i),1);
	    }
	    for(int i = 0; i<S.length();i++)
	    {
	    	if(tMap.containsKey(S.charAt(i)))
	        {
	            if(sMap.containsKey(S.charAt(i)) && sMap.get(S.charAt(i)) < tMap.get(S.charAt(i)))
	            	{
	            	if(count==0) start=i;
	            	int val = sMap.get(S.charAt(i));
	            	sMap.put(S.charAt(i), val+1);
	            	count++;
	            	}
	            else if(!sMap.containsKey(S.charAt(i)))
	            {
	            	if(count==0) start = i;
	                sMap.put(S.charAt(i),1);
	                count ++;
	            }
	        }
	    	if(count == T.length())
	        {
	    		int j=start;
	            if(minWin > i-start)
	            {
	                res = new StringBuilder();
	                while(j<=i)
	                {
	                    res.append(S.charAt(j));
	                    j++;
	                }
	            }
	            if(sMap.get(S.charAt(start)) > tMap.get(S.charAt(start)))
	            {
	                j = start;
	                while(j<S.length())
	                {
	                    if(tMap.containsKey(S.charAt(j)) && sMap.get(S.charAt(j)) > 
	                    tMap.get(S.charAt(j)))
	                    {
	                        int val = sMap.get(S.charAt(j));
	                        sMap.put(S.charAt(j), val-1);
	                        j++;
	                    }
	                    else if(!tMap.containsKey(S.charAt(j))) j++;
	                    else break;
	                }
	            }
	            count=0;
	        }
	        
	    }
	    System.out.println(res.toString());
	    return res.toString();
	}

}
