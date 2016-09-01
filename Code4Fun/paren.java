/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.
*/

import java.util.ArrayList;

public class paren {
	
	public static void main(String[] args)
	{
		paren o = new paren();
		o.generateParenthesis(3);
	}
	
	public ArrayList<String> generateParenthesis(int a) {
	    ArrayList<String> res = new ArrayList<String>();
	    genParen(res, "", a,a);
	    return res;
	}
	public void genParen(ArrayList<String> res, String s, int left, int right)
	{
	    if(left>right) return;
	    if(left==0 && right==0)
	    {
	        res.add(s);
	        return;
	    }
	    if(left>0)
	    {
	        genParen(res, s+"(", left-1,right);
	    }
	    if(right>0)
	    {
	        genParen(res, s+")", left, right-1);
	    }
	}

}
