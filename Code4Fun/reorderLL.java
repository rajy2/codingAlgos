/*

Given a singly linked list

    L: L0 ? L1 ? … ? Ln-1 ? Ln,
reorder it to:

    L0 ? Ln ? L1 ? Ln-1 ? L2 ? Ln-2 ? …
You must do this in-place without altering the nodes’ values.
*/


public class reorderLL {
	public static void main(String[] args)
	{
		reorderLL o = new reorderLL();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = null;
		o.reorderList(l1);
	}
	public ListNode reorderList(ListNode a) {
	    int size = 0;
	    ListNode temp = a, head =a,prev=null;
	    while(temp!=null)
	    {
	        size++;
	        temp=temp.next;
	    }
	    for(int i = 0;i<size/2; i++)
	    {
	        a=a.next;
	    }
	    while(a!=null)
	    {
	        temp = a.next;
	        a.next = prev;
	        prev = a;
	        a = temp;
	    }
	    int n = size/2;
	    ListNode curr = head, tmp = null;
	    while(prev!=null)
	    {
	        temp = curr.next;
	        tmp = prev.next;
	        curr.next = prev;
	        prev.next = (tmp==null)?null:temp;
	        curr = temp;
	        prev = tmp;
	    }
	    ListNode t = head;
	    while(t!=null)
	    {
	    	System.out.println(t.val);
	    	t=t.next;
	    }
	    return head;
	}

}
