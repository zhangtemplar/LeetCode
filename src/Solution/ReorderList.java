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
        // to achive this task, we need the following steps
        //  1, divide the list into two halves;
        //  2, for the second half, reverse its order in place
        //  3, merge the two lists into a single one
        
        // boundary condition
        if (head==null || head.next==null)
        {
            return;
        }
        
        // divide the node into two
        ListNode middle=divideHalves(head);
        
        // reverse the second half
        ListNode second=reverseList(middle);
        
        // merge the list
        ListNode first_next, second_next;
        while(head!=null || second!=null)
        {
            first_next=head.next;
            second_next=second.next;
            head.next=second;
            second.next=first_next;
            head.next=second_next;
            
            head=first_next;
            second=second_next;
        }
    }
    
    /**
     * we can also reverse a list in place. the idea is that, in i-th round
     * we shift the i-th node to the i-th to the last
     */
    private ListNode reverseList(ListNode head)
    {
        if (head==null || head.next==null)
        {
            return head;
        }
        // the pointer to the previous node, current node and next node
        ListNode prev, curr, next, tail;
        
        // create a dumy head
        ListNode result=new ListNode(0);
        result.next=head;
        
        tail=null;
        while(true)
        {
            prev=result;
            curr=prev.next;
            next=curr.next;
            if (next==tail)
            {
                break;
            }
            // move i-th node to i-th to last position
            while(curr.next!=tail)
            {
                prev.next=next;
                curr.next=next.next;
                next.next=curr;
            }
            // update the terminating condition
            tail=curr;
        }
        return result.next;
    }
    
    /**
     * divide the list into two halves, where the head of second half is returned
     * it can be easily achieved by using two pointers moving at different speed
     */
    private ListNode divideHalves(ListNode head)
    {
        ListNode slow, fast;
        slow=head;
        fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        if (fast==null)
        {
            // the list has even length
            return slow;
        }
        else
        {
            return slow.next;
        }
    }
}
