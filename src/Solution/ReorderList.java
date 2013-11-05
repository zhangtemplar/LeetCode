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
    public void reorderList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // we may use a hashmap to store the previouse node
        if (head==null || head.next==null)
        {
            return;
        }
        ListNode result=new ListNode(0);
        result.next=head;
        ListNode node=result;
        // the prev node of the list
        HashMap<ListNode, ListNode> prev=new HashMap<ListNode, ListNode>();
        while(node.next!=null)
        {
            prev.put(node.next, node);
            node=node.next;
        }
        ListNode tail=node;
        // perform the operation
        node=head;
        while(node!=null && tail!=null && node.next!=tail && node!=tail)
        {
            tail.next=node.next;
            node.next=tail;
            node=tail.next;
            tail=prev.get(tail);
        }
        // remove the loop
        tail.next=null;
    }
}
