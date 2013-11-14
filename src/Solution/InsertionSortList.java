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
    public ListNode insertionSortList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // we use a hashmap to store the previous of the node
        if (head==null || head.next==null)
        {
            return head;
        }
        ListNode result=new ListNode(0);
        result.next=head;
        HashMap<ListNode, ListNode> prev=new HashMap<ListNode, ListNode>();
        ListNode node=result;
        while(node.next!=null)
        {
            prev.put(node.next, node);
            node=node.next;
        }
        node=head.next;
        while(node!=null)
        {
            // every node before node is sorted
            ListNode hole=result.next;
            while(hole!=node && hole.val<=node.val)
            {
                hole=hole.next;
            }
            // insert node before node
            if (hole==node)
            {
                node=node.next;
                continue;
            }
            ListNode next=node.next;
            if (hole.next==node)
            {
                // we just swap hole and next;
                prev.get(hole).next=node;
                hole.next=node.next;
                prev.put(node, prev.get(hole));
                prev.put(hole, node);
                prev.put(node.next, hole);
                node.next=hole;
            }
            else
            {
                prev.get(hole).next=node;
                prev.get(node).next=node.next;
                prev.put(node.next, prev.get(node));
                prev.put(node, prev.get(hole));
                prev.put(hole, node);
                node.next=hole;
            }
            node=next;
        }
        return result.next;
    }
}
