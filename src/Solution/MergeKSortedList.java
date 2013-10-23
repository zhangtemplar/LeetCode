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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // just like ordinary sort list, however, we will use a min heap to maintain the minimal element
        if (lists==null || lists.size()<1)
        {
            return null;
        }
        // we use the priority queue to maintain the minimal element of all lists
        // the size of the queue is equal to the size of current nonempty list
        PriorityQueue<ListNode> queue=new PriorityQueue<ListNode>(lists.size(), new ListNodeComp());
        // initialize the queue by adding the head of each list
        for(ListNode node: lists)
        {
            if (node!=null)
            {
                queue.add(node);
            }
        }
        ListNode result=new ListNode(0);
        ListNode head=result;
        while(!queue.isEmpty())
        {
            // in each step, we always add the minimal of the queue, i.e., head
            head.next=queue.poll();
            head=head.next;
            // then we add the next element from the list whose node we just add to the new list
            if (head.next!=null)
            {
                queue.add(head.next);
            }
        }
        return result.next;
    }
}

class ListNodeComp implements Comparator<ListNode>
{
    public int compare(ListNode x, ListNode y)
    {
        return x.val-y.val;
    }
    
    public boolean equals(Object o)
    {
        return false;
    }
}
