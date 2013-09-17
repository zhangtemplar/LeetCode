package Solution;

public class ReverseLinkedListII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLinkedListII instance=new ReverseLinkedListII();
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
		ListNode result=instance.reverseBetween(head, 1, 3);
		System.out.println(instance.printListNode(result));
	}

	public String printListNode(ListNode head)
	{
		StringBuffer result=new StringBuffer();
		while(head!=null)
		{
			result.append(head.val+"->");
			head=head.next;
		}
		return result.toString();
	}
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // first find that node
        // 1) the node right before the m_th node
        // 2) the current node we are processing
        // 3) the n_th node
        int k=1;
        ListNode prev, current, last;
        // create an axulliar node as the new head
        ListNode result=new ListNode(0);
        result.next=head;
        ListNode node=result;
        while(k<m && node!=null)
        {
            node=node.next;
            k++;
        }
        // now we have prev.next=m_th node
        prev=node;
        current=prev.next;
        while(k<n && current.next!=null)
        {
        	node=prev.next;
            prev.next=current.next;
            last=current.next;
            current.next=last.next;
            last.next=node;
            k++;
        }
        return result.next;
    }
}
