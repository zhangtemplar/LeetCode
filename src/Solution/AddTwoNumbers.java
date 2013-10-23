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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ListNode result=new ListNode(0);
        ListNode node=result;
        int increment=0;
        // summation
        while(l1!=null && l2!=null)
        {
            int sum=l1.val+l2.val+increment;
            increment=sum/10;
            node.next=new ListNode(sum%10);
            node=node.next;
            l1=l1.next;
            l2=l2.next;
        }
        // dealing unmatched point
        while(l1!=null)
        {
            int sum=l1.val+increment;
            increment=sum/10;
            node.next=new ListNode(sum%10);
            node=node.next;
            l1=l1.next;
        }
        while(l2!=null)
        {
            int sum=l2.val+increment;
            increment=sum/10;
            node.next=new ListNode(sum%10);
            node=node.next;
            l2=l2.next;
        }
        // for the increment
        if (increment>0)
        {
            node.next=new ListNode(increment);
        }
        return result.next;
    }
}
