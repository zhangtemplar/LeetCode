package trial3;

public class RemoveDuplicatesFromSortedListII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
     * the algorithm is similar, but we need to process the next element
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null)
        {
            return head;
        }
        ListNode result=new ListNode(head.val-1);
        result.next=head;
        ListNode node=result;
        while(node!=null && node.next!=null)
        {
            ListNode next=node.next.next;
            while (next!=null && node.next.val==next.val)
            {
                next=next.next;
            }
            // find a duplicate
            if (next!=node.next.next)
            {
                node.next=next;
            }
            else
            {
                node=node.next;
            }
        }
        return result.next;
    }
}
