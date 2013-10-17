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
        ListNode result=new ListNode(0);
        result.next=head;
        ListNode current=result;
        while(current.next!=null)
        {
            ListNode node=current.next;
            while(node.next!=null && node.val==node.next.val)
            {
                node=node.next;
            }
            // so result.next:node.prev is duplicate
            if(current.next!=node)
            {
                current.next=node.next;
            }
            else
            {
                current=current.next;
            }
        }
        return result.next;
    }
}
