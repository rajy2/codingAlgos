/*
You are given a set of coins S. In how many ways can you make sum N assuming you have infinite amount of each coin in the set.

Note : Coins in set S will be unique. Expected space complexity of this problem is O(N).
*/

import java.util.ArrayList;
import java.util.Arrays;

public class coinsChange {
	
	public static void main(String[] args)
	{
		coinsChange o = new coinsChange();
		ArrayList<Integer> a = new ArrayList<>();
		a.addAll(Arrays.asList(1,2,3));
		o.coinchange2(a, 4);
	}
	
	public int coinchange2(ArrayList<Integer> a, int b) {
        if(a==null||a.size()==0) return 0;
        int m = a.size();
        return count(a,m,b);
    }
    private int count(ArrayList<Integer> a, int m, int b)
    {
        int[] table = new int[b+1];
        table[0]=1;
        for(int i = 0; i<m;i++)
        {
            for(int j = a.get(i); j<=b; j++)
            {
                table[j] += table[j-a.get(i)]% 1000007;
            }
        }
        return table[b]% 1000007;
    }

}
