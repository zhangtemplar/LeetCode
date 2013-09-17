package Solution;

public class SwapNodePair {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // the pointer to the head of result, even node and odd node of the current pair
        // and also swap
        // we assume the list starts from 0
        ListNode result, even, odd;
        // special case, when the list has less than two nodes, we skip it
        if (head==null || head.next==null)
        {
            return head;
        }
        // common case
        result=head.next;
        even=head;
        odd=result.next;
        result.next=even;
        even.next=odd;
        while (odd!=null && even!=null && odd.next!=null)
        {
            // do the swap
            even.next=odd.next;
            odd.next=odd.next.next;
            even.next.next=odd;
            // mvoe the point
            even=odd;
            odd=odd.next;
        }
        return result;
    }
}
