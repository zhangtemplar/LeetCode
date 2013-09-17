package Solution;

public class PartitionList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we will create a auxillary node as the head
        ListNode result=new ListNode(0);
        result.next=head;
        // we will main two reference
        // prev: the last node which is less than x
        // current: the previous of the node that we are being processed
        ListNode current=result;
        ListNode prev=result;
        while(current.next!=null)
        {
            if (current.next.val<x)
            {
                if (current==prev)
                {
                    // special case
                    current=current.next;
                    prev=prev.next;
                }
                else
                {
                    // we need to move this node ahead
                    ListNode next=current.next;
                    current.next=current.next.next;
                    next.next=prev.next;
                    prev.next=next;
                    // then move the prev down
                    prev=prev.next;
                }
            }
            else
            {
                // we just skip this node
                current=current.next;
            }
        }
        return result.next;
    }
}
