package prep;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrder {
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(4);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(6);
		TreeNode n3 = new TreeNode(1);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(7);
		TreeNode n7 = new TreeNode(10);
		TreeNode n8 = new TreeNode(11);
		root.left=n1;
		root.right=n2;
		n1.left=n3;
		n1.right=n4;
		n2.left=n5;
		n2.right=n6;
		n4.left=n7;
		n4.right=n8;
		PostOrder o = new PostOrder();
		o.preorderTraversal(root);
	}
	
	public ArrayList<Integer> preorderTraversal(TreeNode a) {
	    Stack<TreeNode> s = new Stack<TreeNode>();
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    if(a!=null) s.push(a);
	    while(!s.isEmpty())
	    {
	        TreeNode n = s.pop();
	        res.add(n.val);
	        if(n.right !=null)
	        {
	            s.push(n.right);
	        }
	        if(n.left!=null)
	        {
	            s.push(n.left);
	        }
	    }
	    return res;
	}
	
	public ArrayList<Integer> postorderTraversal(TreeNode a) {
	    Stack<TreeNode> s = new Stack<TreeNode>();
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    while(a!=null)
	    {
	    	Stack<TreeNode> stack = new Stack<TreeNode>();
	        stack.push(a);
	     
	        while(!stack.isEmpty()) {
	            TreeNode temp = stack.peek();
	            if(temp.left==null && temp.right==null) {
	                TreeNode pop = stack.pop();
	                res.add(pop.val);
	            }
	            else {
	                if(temp.right!=null) {
	                    stack.push(temp.right);
	                    temp.right = null;
	                }
	     
	                if(temp.left!=null) {
	                    stack.push(temp.left);
	                    temp.left = null;
	                }
	            }
	        }
	    }
	    return res;
}
}
