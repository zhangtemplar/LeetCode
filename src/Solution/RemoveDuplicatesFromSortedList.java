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
    public ListNode deleteDuplicates(ListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (head==null || head.next==null)
        {
            return head;
        }
        ListNode node=head;
        while(node!=null && node.next!=null)
        {
            // we find an duplicate
            if (node.val==node.next.val)
            {
                // remove the next element
                node.next=node.next.next;
            }
            else
            {
                // otherwise continue;
                node=node.next;
            }
        }
        return head;
    }
}
