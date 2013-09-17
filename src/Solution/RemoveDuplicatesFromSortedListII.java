package Solution;

import java.util.HashMap;

public class RemoveDuplicatesFromSortedListII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we will create a HashMap
        // where the key is the value and value is the previous node of the current
        if (head==null || head.next==null)
        {
            return head;
        }
        HashMap<Integer, ListNode> set=new HashMap<Integer, ListNode>();
        ListNode current=head.next;
        ListNode prev=head;
        // this is the fake node
        ListNode result=new ListNode(0);
        result.next=head;
        set.put(head.val, result);
        while(current!=null)
        {
            if (set.containsKey(current.val))
            {
                // we need to delete both current and the next node from the set
                ListNode node=set.get(current.val);
                if (node.next==prev)
                {
                    // this is the special case, where the duplicate elements are adjacent
                    prev=node;
                    node.next=current.next;
                    current=current.next;
                }
                else
                {
                    // for the simple case, just remove those two
                    node.next=node.next.next;
                    prev.next=current.next;
                    current=current.next;
                }
            }
            else
            {
                // simplest: we just check the next one
                set.put(current.val, prev);
                prev=prev.next;
                current=current.next;
            }
        }
        return result.next;
    }
}
