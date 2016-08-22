package prep;

import java.util.Stack;

public class redundantbracs {
	public static void main(String[] args)
	{
		redundantbracs o = new redundantbracs();
		System.out.println(o.braces("(a)"));
	}
	
	public int braces(String a) {
	    Stack<Character> s = new Stack<Character>();
	    for(int i = 0; i<a.length(); i++)
	    {
	        if(!(a.substring(i,i+1).matches("[\\}\\)\\]]")))
	        {
	            s.push(a.charAt(i));
	        }
	        else{
	            StringBuilder str = new StringBuilder();
	            str.append(a.charAt(i));
	            while(!s.isEmpty() && s.peek() != '(' && s.peek() != '[' && s.peek() != '{')
	            {
	               str.insert(0,s.pop());
	            }
	            str.insert(0, s.pop());
	            String temp = str.toString();
	            //System.out.println(temp + temp.matches("\\(?[a-z]*[A-Z]*\\)?"));
	            if(temp.matches("\\(?[a-z]*[A-Z]*\\)?") || temp.matches("\\(?[a-z]*[A-Z]*\\)?") || temp.matches("\\(?[a-z]*[A-Z]*\\)?")) return 1;
	        }
	    }
	    return 0;
	}

}
