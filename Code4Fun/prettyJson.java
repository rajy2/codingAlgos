/*
Pretty print a json object using proper indentation.

Every inner brace should increase one indentation to the following lines.
Every close brace should decrease one indentation to the same line and the following lines.
The indents can be increased with an additional ‘\t’
*/


import java.util.ArrayList;

public class prettyJson {
	public static void main(String[] args)
	{
		prettyJson o =new prettyJson();
		o.prettyJSON("{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}");
	}

	public ArrayList<String> prettyJSON(String a) {
	    //System.out.println((int)'\t');
		ArrayList<String> res = new ArrayList<String>();
	    if(a.length() == 0) return res;
	    int indent = 0;
	    StringBuilder str = new StringBuilder();
        for(int i = 0; i<a.length(); i++)
	    {
        	str = new StringBuilder();
	        if(a.charAt(i) == ' ') continue;
	        if(a.substring(i, i+1).matches("[\\{\\}\\[\\]]"))
	        {
	            
	            if(a.charAt(i) == '{' || a.charAt(i) == '[')
	            {
	            	for(int j = 0; j<indent; j++) str.append('\t'); 
		            str.append(a.charAt(i));
		            indent += 1;
			    }
	            else{
	            	if(indent > 0) indent -=1; 
	            	for(int j = 0; j<indent; j++) str.append('\t'); 
		            str.append(a.charAt(i));
			    }
			    if(i+1<a.length() && a.charAt(i+1) == ',')
			    {
			        str.append(a.charAt(i+1));
			        i++;
			    }
			    res.add(str.toString());
	        }
	        else{
	        	for(int j = 0; j<indent; j++) str.append('\t');
	            str.append(a.charAt(i));
	            i++;
	            while(i<a.length() && !(a.substring(i,i+1).matches("[\\{\\}\\[\\],]")))
	            {
	                str.append(a.charAt(i));
	                i++;
	            }
	            if(i<a.length() && a.charAt(i) == ',')
	            {
	                str.append(a.charAt(i));
	                res.add(str.toString());
	            }
	            else 
	            {
	            	res.add(str.toString());
	            	i--;
	            }
	        }
	    }
	    return res;
	}
}

