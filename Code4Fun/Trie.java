package prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Trie {
	
	public static void main(String[] args)
	{
		Trie o = new Trie();
		ArrayList<String> a = new ArrayList<>();
		a.addAll(Arrays.asList("bearcat", "bert" ));
		o.prefix(a);
	}
	
	public ArrayList<String> prefix(ArrayList<String> a) {
	    HashMap<Character,Integer> map = new HashMap<Character, Integer>();
	    ArrayList<String> res = new ArrayList<String>();
	    for(String str: a)
	    {
	        for(int i = 0; i<str.length();i++)
	        {
	        	if(map.containsKey(str.charAt(i))) map.put(str.charAt(i),map.get(str.charAt(i))+1);
	            else map.put(str.charAt(i),1);
	        }
	    }
	    for(String str: a)
	    {
	        int i = 0;
	        for(; i<str.length();i++)
	        {
	            if(map.get(str.charAt(i)) == 1) {
	            	res.add(str.substring(0,i));
	            	break;
	            }
	        }
	        if(i==str.length()) res.add(str);
	    }
	    return res;
	}

}
