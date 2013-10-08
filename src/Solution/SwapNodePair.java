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
    public ListNode swapPairs(ListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (head==null || head.next==null)
        {
            return head;
        }
        // create an auxillary node for the head
        ListNode result=new ListNode(0);
        result.next=head;
        ListNode current=result;
        ListNode next=null;
        while(current.next!=null && current.next.next!=null)
        {
            next=current.next;
            current.next=next.next;
            current=next.next;
            next.next=current.next;
            current.next=next;
            current=current.next;
        }
        return result.next;
    }
}
