/*
Given preorder and inorder traversal of a tree, construct the binary tree.
*/

import java.util.ArrayList;
import java.util.Arrays;

public class PreInTree {
	public static void main(String[] args)
	{
		PreInTree o = new PreInTree();
		ArrayList<Integer> preorder = new ArrayList<>();
		preorder.addAll(Arrays.asList(2,1,3));
		ArrayList<Integer> inorder = new ArrayList<>();
		inorder.addAll(Arrays.asList(1,2,3));
		o.buildTree(preorder, inorder);
	}
	public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {
	    TreeNode root=null;
	    root= build(root, preorder, inorder,0,inorder.size()-1);
	    return root;
	}
	int index=0;
	private TreeNode build(TreeNode root, ArrayList<Integer> preorder, ArrayList<Integer> inorder,int low, int high)
	{
		index++;
	    if(low>high) return null;
	    root = new TreeNode(preorder.get(index));
	    int i = inorder.indexOf(preorder.get(index));
	    root.left = build(root.left, preorder, inorder,low,i-1);
	    root.right = build(root.right, preorder,inorder, i+1,high);
	    return root;
	}

}
