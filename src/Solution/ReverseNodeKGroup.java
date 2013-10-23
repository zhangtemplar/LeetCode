/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // one idea is to use recursion
        // auxillary head
        ListNode result=new ListNode(0);
        result.next=head;
        ListNode start=result;
        while(start!=null)
        {
            ListNode tail=start;
            // find the start of next segment
            int i=0;
            while(i<=k && tail!=null)
            {
                tail=tail.next;
                i++;
            }
            // the length of tail is not a multiple of k
            if (tail==null && i<=k)
            {
                break;
            }
            // reverse the current segment, which will return the last element of the reversed segment
            start=subReverseKGroup(start.next, k, start);
            if (start==null)
            {
                break;
            }
            // connect current segment to the next one
            start.next=tail;
        }
        return result.next;
    }
    
    /**
     * @param head the start of current segment
     * @k the length of current segment
     * @start the last element of previous segment
     * @return the last element of reverse of current segment, i.e., the start of current segment before reverse
     */ 
    private ListNode subReverseKGroup(ListNode head, int k, ListNode start)
    {
        // recursion
        if (k>1 && head!=null)
        {
            ListNode node=subReverseKGroup(head.next, k-1, start);
            if (node==null)
            {
                return null;
            }
            head.next=null;
            node.next=head;
            return head;
        }
        // base: we reach the tail
        else
        {
            start.next=head;
            return head;
        }
    }
}
