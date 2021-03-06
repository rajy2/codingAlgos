/*
You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, �, SN. In a single operation, you can choose two indices L and R such that 1 ? L ? R ? N and flip the characters SL, SL+1, �, SR. By flipping, we mean change character 0 to 1 and vice-versa.

Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised. If you don�t want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.
*/

public class bitFlip {
	public static void main(String[] args)
	{
		String a = "00011000";
           bitFlip o = new bitFlip();
           o.flip(a);
	}

public ArrayList<Integer> flip(String A) {
        int L = 0, R =0, currDiff = 0, maxDiff = 0, currStart = 0;
        for(int i = 0; i<A.length(); i++)
        {
            if(A.charAt(i)=='0') currDiff++;
            else currDiff--;
            if(currDiff > maxDiff)
            {
                maxDiff = currDiff;
                L = currStart;
                R = i;
            }
            else if(currDiff < 0)
            {
                currStart = i+1;
                currDiff =0;
            }
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(maxDiff != 0)
        {
            res.add(L+1);
            res.add(R+1);
        }
        return res;
    }

}
