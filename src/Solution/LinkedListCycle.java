/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // we use two pointer, one moves one node forward each time and the other moves two nodes forward each time
        // if there is a loop, those two pointers must hit at some time
        if (head==null || head.next==null)
        {
            return false;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(slow!=null && fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if (slow!=null && fast!=null && slow==fast)
            {
                return true;
            }
        }
        return false;
    }
}
