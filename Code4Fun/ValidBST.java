/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node’s key.
The right subtree of a node contains only nodes with keys greater than the node’s key.
Both the left and right subtrees must also be binary search trees.
*/

class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
public class ValidBST {
	
	public int isValidBST(TreeNode a) {
	    return validate(a, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}
	private int validate(TreeNode a, int maxAllowed, int minAllowed)
	{
	    if(a==null) return 1;
	    if( (Integer.valueOf(a.val) < maxAllowed) && (Integer.valueOf(a.val) >= minAllowed) &&
	    validate(a.left, a.val, minAllowed) == 1 &&
	    validate(a.right, maxAllowed, a.val) == 1) return 1;
	    else return 0;
	}

}
