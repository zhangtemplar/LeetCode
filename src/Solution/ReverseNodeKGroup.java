package Solution;

public class ReverseNodeKGroup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // one easy solution is use stack, however, the space is O(k)
        // we can save the space by following procedure
        // s: the previous of the first node of current group;
        // p: another point
        // set s=p; c=s;
        // move s down the list by k times
        // if met any null node, break
        // for i=k-1:-1:0
        //      set c=s;
        //      move p down the list by i times
        //      set n=s.next
        //      set s.next=c.next;
        //      set c.next=c.next.next;
        //      set s=n;
        // end
        // this procedure process one group.
        // move s down the list by k times
        // is s is null, stop
        // point
        // base
        if (k<2)
        {
            return head;
        }
        // create an auxillary node
        ListNode result=new ListNode(0);
        result.next=head;
        head=result;
        while (true)
        {
            // scan the the list to ensure sufficient length
            // the length is not enough
            if (!isLong(head.next, k))
            {
                break;
            }
            // swap it 
            head=swapKGroup(head, k);
            // move the pointer
        }
        return result.next;
    }
    
    /*
    * this function checks whether the list is long enough
    */
    private boolean isLong(ListNode head, int k)
    {
        ListNode current=head;
        int i=0;
        while (current!=null && i++<k)
        {
            current=current.next;
        }
        // the length is not enough
        if (i<k)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    /*
    * this function swap within the k group
    * head is the previous point of the start of the current group
    */
    private ListNode swapKGroup(ListNode head, int k)
    {
        ListNode start, current, previous, next;
        int j;
        start=head;
        // we only need to swap k-1 times
        for (int i=k-1; i>0; i--)
        {
            current=start;
            j=i;
            // move the pointer
            while(j-->0)
            {
                current=current.next;
            }
            // apply the swapping
            next=start.next;
            start.next=current.next;
            current.next=current.next.next;
            start.next.next=next;
            start=start.next;
        }
        // return the last element of current node
        return start.next;
    }
}
