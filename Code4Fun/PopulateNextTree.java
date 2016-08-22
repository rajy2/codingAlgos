package prep;

class TreeLinkNode {
     int val;
     TreeLinkNode left, right, next;
     TreeLinkNode(int x) { val = x; }
 }

public class PopulateNextTree {
	
	public static void main(String[] args)
	{
		TreeLinkNode root = new TreeLinkNode(4);
		TreeLinkNode l1 = new TreeLinkNode(2);
		TreeLinkNode r1 = new TreeLinkNode(6);
		TreeLinkNode l2 = new TreeLinkNode(1);
		TreeLinkNode lr1 = new TreeLinkNode(3);
		TreeLinkNode rl1 = new TreeLinkNode(5);
		TreeLinkNode r2 = new TreeLinkNode(7);
		root.left=l1;
		root.right=r1;
		//l1.left=l2;
		//l1.right=lr1;
		r1.left=rl1;
		r1.right=r2;
		l2.left=null;
		l2.right=null;
		//lr1.left=null;
		//lr1.right=null;
		rl1.left=null;
		rl1.right=null;
		r2.left=null;
		r2.right=null;
		PopulateNextTree o = new PopulateNextTree();
		o.connect(root);
	}
	
	public void connect(TreeLinkNode root) {
	    if(root == null) 
	        return;
	    TreeLinkNode leftWall = null; // leftmost node of the next level.
        TreeLinkNode prev = null; // leading node on the next level
        TreeLinkNode cur = root; // current node on the current level

        while (cur != null) {
            
            while (cur != null) {
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        leftWall = cur.left;
                    }
                    prev = cur.left;
                }

                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        leftWall = cur.right;
                    }
                    prev = cur.right;
                }

                // move to the next node
                cur = cur.next;
            }

            // move to the next level
            cur = leftWall;
            leftWall = null;
            prev = null;

        }
    }
	 /*
	    TreeLinkNode lastHead = root;//prevous level's head 
	    TreeLinkNode lastCurrent = null;//previous level's pointer
	    TreeLinkNode currentHead = null;//currnet level's head 
	    TreeLinkNode current = null;//current level's pointer
	 
	      while(lastHead!=null){
	        lastCurrent = lastHead;
	 
	        while(lastCurrent!=null){
	            if(currentHead == null){
	                currentHead = lastCurrent.left;
	                current = lastCurrent.left;
	            }else{
	                current.next = lastCurrent.left;
	                current = current.next;
	            }
	 
	            if(currentHead != null){
	                current.next = lastCurrent.right;
	                current = current.next;
	            }
	 
	            lastCurrent = lastCurrent.next;
	        }
	 
	        //update last head
	        lastHead = currentHead;
	        currentHead = null;
	    }
	   */
	 
	}


