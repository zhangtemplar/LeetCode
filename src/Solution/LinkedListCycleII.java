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
    public ListNode detectCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // the similar idea as the basic problem. However, the core problem here is how to find
        // the length of the loop
        if (head==null || head.next==null)
        {
            return null;
        }
        // Step 1
        // if we record the number of steps it takes for slow and fast hit
        // then this number (N) must be multiple of the length of the loop (L)
        ListNode fast, slow;
        fast=head;
        slow=head;
        int step=0;
        while(slow!=null && fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            step++;
            if (fast==slow)
            {
                break;
            }
        }
        // no loop found
        if (slow==null || fast==null || fast.next==null)
        {
            return null;
        }
        // Step 2
        // we repeat this process to find out the number of loops the slow (b) and fast (a) takes
        // then the length of the loop would be L=N/(a-b)
        fast=head;
        int round_fast=0;
        int round_slow=0;
        for (int i=0; i<=step*2; i++)
        {
            fast=fast.next;
            if (fast==slow)
            {
                round_fast++;
            }
            if (i==step)
            {
                round_slow=round_fast;
            }
        }
        // Step 3
        // we can use L, b and N to find out m, the index of the start of the loop
        int loop=step/(round_fast-round_slow);
        fast=head;
        for (int i=0; i<loop; i++)
        {
            fast=fast.next;
        }
        slow=head;
        while(fast!=slow)
        {
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }
}
