package prep;

import java.util.ArrayList;
import java.util.Arrays;

public class buildTree {
	
	public static void main(String[] args)
	{
		ArrayList<Integer> a = new ArrayList<>();
		a.addAll(Arrays.asList(3,1,2));
		buildTree o = new buildTree();
		o.b(a);
	}
	
	public TreeNode b(ArrayList<Integer> a) {
        if(a==null) return null;
        TreeNode root = null;
        root = build(root,a,0,a.size()-1);
        return root;
    }
    private TreeNode build(TreeNode n, ArrayList<Integer> a, int low, int high)
    {
        if(low>high) return null;
        int rootIndex = max(a,low,high);
        n = new TreeNode(a.get(rootIndex));
        System.out.println(rootIndex);
        if(low==high) return n;
        n.left = build(n.left, a, low, rootIndex-1);
        n.right = build(n.right, a, rootIndex+1, high);
        return n;
    }
    private int max(ArrayList<Integer> a, int low, int high)
    {
        int maxIndex = low;
        for(int i = low+1; i<=high; i++)
        {
            maxIndex = (a.get(i)>a.get(maxIndex))? i:maxIndex;
        }
        return maxIndex;
    }

}
