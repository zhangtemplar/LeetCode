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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we first create a fake head
        if (head==null || head.next==null)
        {
            return head;
        }
        ListNode result=new ListNode(0);
        result.next=head;
        // we can use a stack for this purpose
        int i=1;
        ListNode node=result;
        while(i<m && node!=null)
        {
            node=node.next;
            i++;
        }
        ListNode start=node;
        // it is not long enough
        if (node==null)
        {
            return head;
        }
        node=node.next;
        // record the list to be reversed
        Stack<ListNode> stack=new Stack<ListNode>();
        while(i<=n && node!=null)
        {
            stack.push(node);
            node=node.next;
            i++;
        }
        ListNode end=node;
        // pop out the node
        while(!stack.isEmpty())
        {
            start.next=stack.pop();
            start=start.next;
        }
        start.next=end;
        return result.next;
    }
}
