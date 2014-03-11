package trial3;

public class RemoveDuplicatesFromSortedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ListNode deleteDuplicates(ListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (head==null || head.next==null)
        {
            return head;
        }
        ListNode node=head;
        while(node.next!=null)
        {
            if (node.val==node.next.val)
            {
                node.next=node.next.next;
            }
            else
            {
                node=node.next;
            }
        }
        return head;
    }
}
