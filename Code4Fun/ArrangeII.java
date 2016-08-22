package prep;

import java.util.Arrays;

public class ArrangeII {
	
	public static void main(String[] args)
	{
		ArrangeII o = new ArrangeII();
		o.arrange("WBWB", 2);
	}
	int[][] dp=null;
	public int arrange(String a, int b) {
		if(a==null || a.length()==0 || b==0) return 0;
        dp= new int[a.length()][b];
        for(int[] row: dp)
        {
            Arrays.fill(row,-1);
        }
		int ans = calc(a,b,0,0);
		return (ans==Integer.MAX_VALUE)? -1:ans;
    }
    private int calc(String a, int b, int start, int stable)
    {
        if(start == a.length())
        {
        	if(stable == b) return 0;
        	return Integer.MAX_VALUE;
        }
        if(stable == b) return Integer.MAX_VALUE;
        if(dp[start][stable] != -1)
        	return dp[start][stable];
        
        int wh=0,bl=0,ans=Integer.MAX_VALUE;
        for(int i=start; i<a.length();i++)
        {
        	if(a.charAt(i)=='W') wh++;
        	else bl++;
        	if(wh*bl > ans) break;
        	int tmp = calc(a,b,i+1,stable+1);
        	if(tmp != Integer.MAX_VALUE)
        	{
        		ans = Math.min(ans, tmp+(wh*bl));
        	}
        }
        return dp[start][stable] = ans;
    }

}
