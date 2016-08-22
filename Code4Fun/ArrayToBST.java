package prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToBST {
	public static void main(String[] args)
	{
		ArrayToBST o = new ArrayToBST();
		List<Integer> a = new ArrayList<Integer>();
		a.addAll(Arrays.asList(1,2,3,4,5,6,7,8));
		o.balancedBST(a, 0, a.size()-1);
	}
	
	public TreeNode sortedArrayToBST(final List<Integer> a) {
	    if(a==null) return null;
	    return balancedBST(a,0,a.size()-1);
	}
	
	private TreeNode balancedBST(List<Integer> a, int low, int high)
	{
		if(low>high) return null;
		int mid = low+(high-low)/2;
	    TreeNode root = new TreeNode(a.get(mid));
	    root.left = balancedBST(a,low,mid-1);
	    root.right = balancedBST(a,mid+1,high);
	    return root;
	}

}
