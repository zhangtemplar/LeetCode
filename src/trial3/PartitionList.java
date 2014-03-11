package trial3;

public class PartitionList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=new ListNode(1);
		head.next=new ListNode(3);
		head.next.next=new ListNode(2);
		
		System.out.println(new PartitionList().partition(head, 3));
	}
	/**
     * we take two steps
     *  1) find the node
     *  2) shift the node whichever is smaller than x
     * we keep the location the latest is inserted
     */
    public ListNode partition(ListNode head, int x) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ListNode result=new ListNode(x-1);
        result.next=head;
        ListNode node=result;
        // find the first location whose value is greater or equal to x
        ListNode anchor=null;
        while(node!=null)
        {
            if (node.next!=null && node.val<x && node.next.val>=x)
            {
                anchor=node;
                break;
            }
            node=node.next;
        }
        // current list already satisfy the condition
        if (anchor==null)
        {
            return result.next;
        }
        // make the change, shift every node who is smaller than x to the next of anchor
        node=anchor.next;
        while(node!=null && node.next!=null)
        {
            ListNode tmp=node.next.next;
            // shift it before prev
            if (node.next.val<x)
            {
                node.next.next=anchor.next;
                anchor.next=node.next;
                anchor=anchor.next;
                node.next=tmp;
            }
        	node=node.next;
        }
        return result.next;
    }
}
