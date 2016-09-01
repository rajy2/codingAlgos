/*
Given a column title as appears in an Excel sheet, return its corresponding column number.
*/

public class ExcelColumToNum {
	public static void main(String args[])
	{
		ExcelColumToNum obj = new ExcelColumToNum();
		obj.titleToNumber("AB");
	}
	
	public int titleToNumber(String s) {
	    if(s==null || s.length() == 0){
	        throw new IllegalArgumentException("Input is not valid!");
	    }
	 
	    int result = 0;
	    int i = s.length()-1;
	    int t = 0;
	    while(i >= 0){
	        char curr = s.charAt(i);
	        result = result + (int) Math.pow(26, t) * (curr-'A'+1);
	        t++;
	        i--;
	    }
	 
	    return result;
	}

}
