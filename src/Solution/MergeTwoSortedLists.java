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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ListNode head=new ListNode(0);
        ListNode node=head;
        while(l1!=null && l2!=null)
        {
            if (l1.val<=l2.val)
            {
                node.next=l1;
                l1=l1.next;
            }
            else
            {
                node.next=l2;
                l2=l2.next;
            }
            node=node.next;
        }
        // clean up the stuff
        if (l1!=null)
        {
            node.next=l1;
        }
        if (l2!=null)
        {
            node.next=l2;
        }
        return head.next;
    }
}
