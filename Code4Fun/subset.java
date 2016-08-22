package prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class subset {
	
	public static void main(String[] args)
	{
		subset o = new subset();
		ArrayList<Integer> t = new ArrayList<>();
		t.addAll(Arrays.asList(5,4));
		o.subsets(t);
	}
	
	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        if (S == null || S.size() == 0) {
            return result;
        }
        Collections.sort(S);
        helper(result, S, new ArrayList<Integer>(), 0);
        return result;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> S, ArrayList<Integer> cur, int i) {
        for (int j = i; j < S.size(); j++) {
            cur.add(S.get(j));
            if(!result.contains(cur)) result.add(new ArrayList<Integer>(cur));
            helper(result, S, cur, j + 1);
            cur.remove(cur.size()-1);
        }
    }

}
