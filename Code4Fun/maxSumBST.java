/*
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

Example :

Given the below binary tree,

       1
      / \
     2   3
Return 6.
*/

public class maxSumBST {

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
	
	public static void main(String args[])
	{
		TreeNode tree = new TreeNode(10);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(10);
        tree.left.left = new TreeNode(20);
        tree.left.right = new TreeNode(1);
        tree.right.right = new TreeNode(-25);
        tree.right.right.left = new TreeNode(3);
        tree.right.right.right = new TreeNode(4);
        maxSumBST o = new maxSumBST();
        o.maxPathSum(tree);
	}

	public int maxPathSum(TreeNode a) {
	    if(a==null) return 0;
	    int[] max = new int[1];
	    max[0] = Integer.MIN_VALUE;
	    findMaxSum(a,max);
	    return max[0];
	}
	private int findMaxSum(TreeNode a, int[] max)
	{
	    if(a == null) return 0;
	    int left = findMaxSum(a.left, max);
	    int right = findMaxSum(a.right, max);
	    int curr = Math.max(a.val, Math.max(a.val+left, a.val+right));
	    max[0] = Math.max(max[0], Math.max(curr,left + a.val + right));
	    return curr;
	}
}
