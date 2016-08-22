package prep;

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
	public ArrayList<Integer> findSubstring(String a, final String[] words2) {
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    if(a==null||a.length() ==0 || words2==null || words2.length==0) return res;
	    HashMap<String, Integer> words = new HashMap<String, Integer>();
	    for(String s: words2)
	    {
	        if(words.containsKey(s)) words.put(s,words.get(s)+1);
	        else words.put(s,1);
	    }
	    int l = words2[0].length();
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
	                if(count == words2.length)
	                {
	                    res.add(start);
	                    String rem = a.substring(start, start+l);
	                    System.out.println(rem);
	                    curr.put(rem, curr.get(rem)-1);
	                    count--;
	                    start=start+l;
	                }
	            }
	            else{
	                count=0;
	                start=start+l;
	                curr.clear();
	            }
	        }
	    }
	    return res;
	}
	/*
	public List<Integer> findSubstring(String s, String[] words) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    if(s==null||s.length()==0||words==null||words.length==0){
	        return result;
	    } 
	 
	    //frequency of words
	    HashMap<String, Integer> map = new HashMap<String, Integer>();
	    for(String w: words){
	        if(map.containsKey(w)){
	            map.put(w, map.get(w)+1);
	        }else{
	            map.put(w, 1);
	        }
	    }
	 
	    int len = words[0].length();
	 
	    for(int j=0; j<len; j++){
	        HashMap<String, Integer> currentMap = new HashMap<String, Integer>();
	        int start = j;//start index of start
	        int count = 0;//count totoal qualified words so far
	 
	        for(int i=j; i<=s.length()-len; i=i+len){
	            String sub = s.substring(i, i+len);
	            if(map.containsKey(sub)){
	                //set frequency in current map
	                if(currentMap.containsKey(sub)){
	                    currentMap.put(sub, currentMap.get(sub)+1);
	                }else{
	                    currentMap.put(sub, 1);
	                }
	 
	                count++;
	 
	                while(currentMap.get(sub)>map.get(sub)){
	                    String left = s.substring(start, start+len);
	                    currentMap.put(left, currentMap.get(left)-1);
	 
	                    count--;
	                    start = start + len;
	                }
	 
	 
	                if(count==words.length){
	                    result.add(start); //add to result
	 
	                    //shift right and reset currentMap, count & start point         
	                    String left = s.substring(start, start+len);
	                    currentMap.put(left, currentMap.get(left)-1);
	                    count--;
	                    start = start + len;
	                }
	            }else{
	                currentMap.clear();
	                start = i+len;
	                count = 0;
	            }
	        }
	    }
	 
	    return result;
	}*/

}
