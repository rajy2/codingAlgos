/*
Given a string s, partition s such that every string of the partition is a palindrome.

Return all possible palindrome partitioning of s.
*/

import java.util.ArrayList;

public class palindromeOfString {
	
	public static void main(String[] args)
	{
		palindromeOfString o = new palindromeOfString();
		o.partition("efe");
	}
	
	public ArrayList<ArrayList<String>> partition(String a) {
	    ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
	    ArrayList<String> temp = new ArrayList<String>();
	    if(a.length() == 0) return res;
	    else if(a.length() == 1)
	    {
	        temp.add(a);
	        res.add(temp);
	        return res;
	    }
	    palin(a,res, 0, temp);
	    return res;
	}
	public void palin(String a, ArrayList<ArrayList<String>> res, int index, ArrayList<String> temp)
	{
	    if(index == a.length())
	    {
	        ArrayList<String> p = new ArrayList<String>(temp);
	        res.add(p);
	        return;
	    }
	    for(int i = index+1; i<=a.length();i++)
	    {
	        String str = a.substring(index, i);
	        if(isPalin(str))
	        {
	            temp.add(str);
	            palin(a,res,i,temp);
	            temp.remove(temp.size()-1);
	        }
	    }
	    
	}
	public boolean isPalin(String str)
	{
	    int left=0, right=str.length()-1;
	    while(left<=right)
	    {
	        if(str.charAt(left) != str.charAt(right)) return false;
	        left++;
	        right--;
	    }
	    return true;
	}

}
