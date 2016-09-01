/* Given a binary tree, determine if it is height-balanced.*/

public class BalancedTree {
	public boolean checkBalance(Node root){
		int result = isBalanced(root);
		if(result>0){
			return true;
		}else{
			return false;
		}
	}
	public int isBalanced(Node a){
		 if(a==null) return 0;
	    int leftHeight = checkBal(a.left);
	    if(leftHeight == -1) return -1;
	    int rightHeight = checkBal(a.right);
	    if(rightHeight == -1) return -1;
	    if(Math.abs(leftHeight - rightHeight) > 1) return -1;
	    else return 1+Math.max(leftHeight, rightHeight);
	}
	public static void main(String args[]){
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.right.left = new Node(30);
		root.right.right = new Node(35);		
		System.out.println(" Is Tree Balanced : " + (new BalancedTree()).checkBalance(root));
		root.right.right.right = new Node (40);
		root.right.right.right.right = new Node (45);
		System.out.println(" Is Tree Balanced : " + (new BalancedTree()).checkBalance(root));
	}
}
class Node{
	int data;
	Node left;
	Node right;
	public Node(int data){
		this.data = data;
		this.left = null;
		this.right =null;
	}
}