package prep;

import java.util.ArrayList;
import java.util.Arrays;

public class InPostTree {
	
	public static void main(String[] args)
	{
		InPostTree o = new InPostTree();
		ArrayList<Integer> postorder = new ArrayList<>();
		postorder.addAll(Arrays.asList(1,2,4,6,5,3));
		ArrayList<Integer> inorder = new ArrayList<>();
		inorder.addAll(Arrays.asList(1,2,3,4,5,6));
		TreeNode root = o.buildTree(inorder, postorder);
		System.out.println(root.val);
	}
	public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
	    if(inorder == null||postorder ==null || inorder.size() != postorder.size()) return null;
	    return build(inorder,postorder,0,inorder.size()-1,postorder.size()-1);
	}
	private TreeNode build(ArrayList<Integer> inorder, ArrayList<Integer> postorder, int start,
	int end, int index)
	{
	    if(start > end) return null;
	    TreeNode root = new TreeNode(postorder.get(index));
	    int i = inorder.indexOf(postorder.get(index));
	    root.right = build(inorder, postorder, i+1,end, index-1);
	    root.left = build(inorder,postorder,start,i-1, index-(end-i)-1);
	    return root;
	}
}
