/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given

s = "myinterviewtrainer",
dict = ["trainer", "my", "interview"].
Return 1 ( corresponding to true ) because "myinterviewtrainer" can be segmented as "my interview trainer".

Return 0 / 1 ( 0 for false, 1 for true ) for this problem
*/

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
	    boolean[] t = new boolean[a.length()+1];
        t[0] = true; 
        Set<String> dict = new HashSet<>(b);
        for(int i=0; i<a.length(); i++){
            if(!t[i]) 
                continue;
 
            for(String s: dict){
                int len = s.length();
                int end = i + len;
                if(end > a.length())
                    continue;
 
                if(t[end]) continue;
 
                if(a.substring(i, end).equals(s)){
                    t[end] = true;
                }
            }
        }
 
        return t[a.length()]?1:0;
    }

}
