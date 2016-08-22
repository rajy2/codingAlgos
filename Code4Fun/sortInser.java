package prep;

public class sortInser {
	public static void main(String[] args)
	{
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(1);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = null;
		sortInser o = new sortInser();
		o.insertionSortList(l1);
	}
	
	public ListNode insertionSortList(ListNode a) {
	    ListNode head=a,curr=a.next,prev = null;
	    while(curr!=null)
	    {
	        prev=null;
	        ListNode temp = curr.next;
	        ListNode ll = head;
	        while(ll != curr && ll.val <= curr.val)
	        {
	            prev = ll;
	            ll=ll.next;
	        }
	        if(prev==null)
	        {
	            curr.next = ll;
	            while(ll.next !=curr)ll=ll.next;
	            ll.next = temp;
	            head = curr;
	        }
	        else{
	        	ListNode d = prev;
	        	while(d.next!=curr)d=d.next;
	        	d.next=temp;
	        	ListNode t = prev.next;
	            prev.next = curr;
	            curr.next = t;
	            
	            }
	        curr=temp;
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
