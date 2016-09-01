/*
Given a positive integer n and a string s consisting only of letters D or I, you have to find any permutation of first n positive integer that satisfy the given input string.

D means the next number is smaller, while I means the next number is greater.

Notes
- Length of given string s will always equal to n - 1
- Your solution should run in linear time and space.
*/

import java.util.ArrayList;

public class perm {
	
	public static void main(String[] args)
	{
		perm o = new perm();
		o.findPerm("ID", 3);
	}
	
	public ArrayList<Integer> findPerm(final String A, int B) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(A.length() != B-1) return ans;
        for(int i = 0; i < B - 1; i++) 
        {
            if(!(A.charAt(i) == 'I' || A.charAt(i) == 'D')) return ans;
        }
        
        int start = 1, upto = B;
        for(int i = 0; i < B && (start < upto); i++) {
            if(A.charAt(i) == 'D') ans.add(upto--);
            else ans.add(start++);
        }
        //if(start != upto) return ans;
        ans.add(B-1,start);
        return ans;

    }

}
