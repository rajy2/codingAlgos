package prep;

public class maxSumBST {
	
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

	public int maxPathSum(TreeNode root) {
		int max[] = new int[1]; 
		max[0] = Integer.MIN_VALUE;
		calculateSum(root, max);
		return max[0];
	}
	 
	public int calculateSum(TreeNode root, int[] max) {
		if (root == null)
			return 0;
	 
		int left = calculateSum(root.left, max);
		int right = calculateSum(root.right, max);
	 
		int current = Math.max(root.val, Math.max(root.val + left, root.val + right));
	 
		max[0] = Math.max(max[0], Math.max(current, left + root.val + right));
	 
		return current;
	}
}
