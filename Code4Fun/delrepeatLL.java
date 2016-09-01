/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
*/

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}
public class delrepeatLL {
	
	public static void main(String[] args)
	{
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(4);
		ListNode l6 = new ListNode(5);
		ListNode l7 = new ListNode(5);
		ListNode l8 = new ListNode(5);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		l5.next=l6;
		l6.next=l7;
		l7.next=l8;
		l8.next=null;
		delrepeatLL o = new delrepeatLL();
		o.deleteDuplicates(l1);
	}
	
	public ListNode deleteDuplicates(ListNode a) {
	    ListNode curr = a.next, head = a, prev = head;
	    int count=0;
	    while(curr!=null)
	    {
	        while(curr!=null && curr.val == a.val) 
	        {
	            curr=curr.next;
	            count++;
	        }
	        if(count!=0)
	        {
	            if(a==head)
	            {
	                while(a!=curr) a=a.next;
	                head=a;
	                prev=head;
	            }
	            else if(curr == null)
	            {
	            	prev.next = null;
	            }
	            else {
	                while(a!=curr)a=a.next;
	                prev.next = a;
	                //prev=a;
	            }
	            count=0;
	        }
	        else {
	        	prev=a;
	        	a=a.next;
	        }

        	if(curr!=null) curr=curr.next;
	    }
	    ListNode temp = head;
	    while(temp!=null)
	    {
	    	System.out.println(temp.val);
	    	temp = temp.next;
	    }
	    return head;
	}

}
