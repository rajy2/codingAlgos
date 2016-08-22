package prep;

import java.util.Stack;

public class balanceParen {
	
	public static void main(String[] args)
	{
		balanceParen o = new balanceParen();
		System.out.println(o.isValid("(){}[]"));
	}
	
	public int isValid(String a) {
	    Stack<Character> s = new Stack<Character>();
	    int len = a.length();
	    for(int i = 0; i<len; i++)
	    {
	        for(Character c: s)System.out.println(c);
	        if(a.substring(i,i+1).matches("[\\{,\\(,\\[]")) s.push(a.charAt(i));
	        else {
	            if(s.isEmpty()) return 0;
	            char val = s.pop();
	            System.out.println(a.charAt(i));
	            if(a.charAt(i) == ')' && val == '(') continue;
	            else if(a.charAt(i) == ']' && val == '[') continue;
	            else if(val =='{') continue;
	            else return 0;
	        } 
	    }
	    if(!(s.isEmpty()))return 0;
	    return 1;
	}

}
