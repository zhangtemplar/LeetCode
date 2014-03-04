package trial3;

public class SortList {
	public static void main(String[] args)
	{
		ListNode head=new ListNode(4);
		head.next=new ListNode(3);
		head.next.next=new ListNode(2);
		head.next.next.next=new ListNode(1);
		
		ListNode result=new SortList().sortList(head);
		System.out.println(result);
	}
	
	/**
     * the best method would be merge sort
     *  1) find the middle O(n)
     *  2) sort the two sublist f(n/2)
     *  3) merge the two sorted sublist O(n)
     * it will be easier by using dummy head
     */
    public ListNode sortList(ListNode head) {
        // base case
        if (head==null || head.next==null)
        {
            return head;
        }
        ListNode tail=findTail(head, null);
        return sortList(head, tail);
    }
    
    /**
     * sort the sublist, note that, the head and tail are inclusive
     */
    private ListNode sortList(ListNode head, ListNode tail)
    {
        if (head==tail)
        {
            return head;
        }
        else
        {
            ListNode middle=findMiddle(head, tail);
            ListNode next=middle.next;
            // remove the cycle
            tail.next=null;
            middle.next=null;
            
            ListNode left_head=sortList(head, middle);
            // ListNode left_tail=findTail(left_head, null);
            
            ListNode right_head=sortList(next, tail);
            // ListNode right_tail=findTail(right_head, null);
            
            // merge the two list
            ListNode result=new ListNode(0);
            ListNode ptr=result;
            while(left_head!=null && right_head!=null)
            {
                if (left_head.val>right_head.val)
                {
                    ptr.next=right_head;
                    right_head=right_head.next;
                }
                else
                {
                    ptr.next=left_head;
                    left_head=left_head.next;
                }
                ptr=ptr.next;
            }
            // post process
            if (left_head!=null)
            {
                ptr.next=left_head;
            }
            if(right_head!=null)
            {
                ptr.next=right_head;
            }
            return result.next;
        }
    }
    
    /**
     * find the tail
     */
    private ListNode findTail(ListNode head, ListNode afterTail)
    {
        ListNode tail=head;
        while(tail.next!=afterTail && tail.next!=null)
        {
            tail=tail.next;
        }
        return tail;
    }
    
    /**
     * find the middle of the node
     */
    private ListNode findMiddle(ListNode head, ListNode tail)
    {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && slow!=null && fast.next!=null && fast!=tail && fast.next!=tail)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
