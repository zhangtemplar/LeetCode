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
    public ListNode rotateRight(ListNode head, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head==null || n<1)
        {
            return head;
        }
        // create an auxillary head
        ListNode result=new ListNode(0);
        result.next=head;
        // identify the length of the array
        int len=0;
        ListNode ptr=head;
        while(ptr!=null)
        {
            len++;
            ptr=ptr.next;
        }
        if (len==1)
        {
            return head;
        }
        n=n%len;
        // find the n-th node
        LinkedList<ListNode> queue=new LinkedList<ListNode>();
        ptr=head;
        while(ptr!=null)
        {
            if(queue.size()>n)
            {
                queue.remove();
            }
            queue.add(ptr);
            ptr=ptr.next;
        }
        // check whether there is enough node there
        if (queue.size()>n)
        {
            // the first of the queue is the position we want to change
            ptr=queue.getLast();
            ptr.next=result.next;
            ptr=queue.getFirst();
            result.next=ptr.next;
            ptr.next=null;
        }
        return result.next;
    }
}
