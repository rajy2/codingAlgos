/*
Given two words A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example : 
edit distance between
"Anshuman" and "Antihuman" is 2.

Operation 1: Replace s with t.
Operation 2: Insert i.
*/

public class editDist {
	
public int minDistance(String a, String b) {
	    if(a==null && b==null) return 0;
	    return editDist(a,b);
	}
	private int editDist(String a, String b)
	{
	    int m = a.length(), n=b.length();
	    int[][] dp = new int[m+1][n+1];
	    for(int i=0; i<=m;i++)
	    {
	        for(int j = 0; j<=n;j++)
	        {
	            if(i==0) dp[i][j]=j;
	            else if(j==0) dp[i][j]=i;
	            else if(a.charAt(i-1)==b.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
	            else{
	                dp[i][j] = 1+Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1]);
	            }
	        }
	    }
	    return dp[m][n];
	} 
     
 
    public static void main(String args[])
    {
        String str1 = "sunday";
        String str2 = "saturday";
        System.out.println( minDistance( str1 , str2) );
    }

}
