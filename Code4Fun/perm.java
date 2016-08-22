package prep;

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
