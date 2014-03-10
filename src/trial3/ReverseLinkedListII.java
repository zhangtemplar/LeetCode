package trial3;

public class ReverseLinkedListII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=new ListNode(3);
		head.next=new ListNode(5);
		System.out.println(new ReverseLinkedListII().reverseBetween(head, 1, 2));
	}
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m==n || head==null)
        {
            return head;
        }
        // dummy head
        ListNode result=new ListNode(-1);
        result.next=head;
        // keep the start and end of the reverse section
        ListNode start, end, before_start, after_end;
        start=null;
        end=null;
        before_start=null;
        after_end=null;
        ListNode node, prev, next;
        node=result;
        prev=null;
        next=null;
        int i=0;
        while(node!=null)
        {
            // set up the anchor
            if (i==m-1)
            {
                before_start=node;
                prev=node;
            }
            if (i==m)
            {
                start=node;
            }
            if (i==n)
            {
                end=node;
            }
            if (i==n+1)
            {
                after_end=node;
                break;
            }
            // start the processing
            if (i>=m && i<=n)
            {
                next=node.next;
                node.next=before_start.next;
                before_start.next=node;
                node=next;
            }
            else
            {
            	node=node.next;
            }
            i++;
        }
        // before_start.next=end;
        start.next=after_end;
        return result.next;
    }
}
