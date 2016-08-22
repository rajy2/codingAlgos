package prep;

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
