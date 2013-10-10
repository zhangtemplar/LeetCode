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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we will maintain two pointers:
        // prev:    the previous of the node to be deleted
        // tail:    the end of the node
        if (head==null)
        {
            return head;
        }
        ListNode result=new ListNode(0);
        result.next=head;
        ListNode prev=result;
        ListNode tail=result;
        while(n>0 && tail!=null)
        {
            tail=tail.next;
            n--;
        }
        // to make sure the list is long enough
        if (n>0 || tail==null)
        {
            return result.next;
        }
        // move to the target location
        while(tail.next!=null)
        {
            prev=prev.next;
            tail=tail.next;
        }
        prev.next=prev.next.next;
        return result.next;
    }
}
