package trial3;

public class ReorderList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
		head.next.next.next=new ListNode(4);
		
		new ReorderList().reorderList(head);
		
		System.out.println(head.toString());
	}

	/**
     * the algorithm contains the following steps
     *  1) split the list into two halves;
     *  2) reverse the second half;
     *  3) merge the two list by interlacing
     */
    public void reorderList(ListNode head) {
        if (head==null || head.next==null || head.next.next==null)
        {
            return;
        }
        
        ListNode middle=findMiddle(head);
        
        // remove cycle
        ListNode node=head;
        while(node.next!=middle)
        {
        	node=node.next;
        }
        node.next=null;
        
        ListNode tail=reverse(middle);
        
        while(head!=middle && tail!=null)
        {
            ListNode next=head.next;
            ListNode prev=tail.next;
            head.next=tail;
            tail.next=next;
            head=next;
            tail=prev;
        }
    }
    
    /**
     */
    public ListNode reverse(ListNode head)
    {
        ListNode next=null;
        ListNode prev=null;
        while(head!=null && head.next!=null)
        {
            next=head.next;
            head.next=prev;
            prev=next;
            next=next.next;
            prev.next=head;
            head=next;
        }
        // we need to process the last node
        if (head!=null)
        {
            head.next=prev;
        }
        else
        {
            head=prev;
        }
        return head;
    }
    
    /**
     * find the middle (the one after the middle)
     */
    public ListNode findMiddle(ListNode head)
    {
        ListNode fast, slow;
        fast=head;
        slow=head;
        while(slow!=null && fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        if (fast!=null)
        {
        	slow=slow.next;
        }
        return slow;
    }
}
