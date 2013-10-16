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
    public ListNode partition(ListNode head, int x) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we maintain the pointer which is right before x
        if (head==null || head.next==null)
        {
            return head;
        }
        ListNode result=new ListNode(0);
        result.next=head;
        // the location of last node which is smaller than x
        ListNode cut=result;
        // the location which is right before the node we are considering
        ListNode current=result;
        while(current.next!=null)
        {
            // put it right after cut
            if(current.next.val<x)
            {
                if (current==cut)
                {
                    cut=cut.next;
                    current=current.next;
                }
                else
                {
                    ListNode cut_next=cut.next;
                    ListNode current_next=current.next;
                    cut.next=current_next;
                    current.next=current_next.next;
                    current_next.next=cut_next;
                    cut=current_next;
                }
            }
            else
            {
                current=current.next;
            }
        }
        return result.next;
    }
}
