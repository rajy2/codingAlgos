package prep;

import java.util.ArrayList;
import java.util.Arrays;

public class wordInDict {
	
	public static void main(String[] args)
	{
		wordInDict o = new wordInDict();
		ArrayList<String> dict = new ArrayList<>();
		dict.addAll(Arrays.asList("interview", "my", "trainer"));
		o.wordBreak("myinterviewtrainer", dict);
	}
	
	public int wordBreak(String a, ArrayList<String> b) {
	    if(a.length()==0 || b.size()==0) return 0;
	    boolean[] wordEnd = new boolean[a.length()+1];
	    wordEnd[0] = true;
	    for(int i = 0; i<a.length();i++)
	    {
	        if(wordEnd[i])
	        {
	        for(int j = i+1; j<=a.length();j++)
	        {
	            String s = a.substring(i,j);
	            if(b.contains(s)) wordEnd[j] =true;
	        }
	        }
	    }
	    return (wordEnd[a.length()])? 1:0;
	}

}
