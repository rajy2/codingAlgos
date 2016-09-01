/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
*/

public class palrev {
	public static void main(String args[])
	{
		palrev o = new palrev();
		System.out.println(o.isPalindrome(".,"));
	}
	public int isPalindrome(String a) {
	    if(a.length()==0) return 0;
	    String b = a.toLowerCase();
	    int j= a.length()-1, i=0;
	    while(i<j)
	    {
	    	while(i<a.length() && !(Character.isDigit(b.charAt(i)) || Character.isLetter(b.charAt(i)))) i++;
	    	while(j>=0 && !(Character.isDigit(b.charAt(j)) || Character.isLetter(b.charAt(j)))) j--;
		    if(i<a.length() && j>=0)
		    	{
		    	if(b.charAt(i)!=b.charAt(j)) return 0;
		    	}
	        i++;
	        j--;
	    }
	    return 1;
	}

}
