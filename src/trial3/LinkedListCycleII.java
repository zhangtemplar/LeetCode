package trial3;

public class LinkedListCycleII {
	/**
     * to find out the cycle, we can use two pointer
     * one travels at normal speed and the other one at double speed
     * if two points meets, there must be a cycle and keep the location
     * Assume it takes n steps, then n=a+xb and 2n=a+yb, where a is the
     * length before cycle and b is the length of the cycle
     * run the slow pointer n time and keep a record of how many time
     *  the saved location is hit. It will give x. Do the same for the 
     * fast pointer 2n step but at normal speed. Then b=n/(y-x)
     * now to find the start of the cycle, we set one pointer at the head
     *  and the second pointer b nodes after, move two pointers at the same
     * speed, the location where they meet is the start.
     */
    public ListNode detectCycle(ListNode head) {
        if (head==null || head.next==null)
        {
            return null;
        }
        
        CycleResult met=hasCycle(head);
        if (met.node==null)
        {
            return null;
        }
        
        int slowCounter=0;
        ListNode node=head;
        for (int i=0; i<met.step; i++)
        {
            if (node==met.node)
            {
                slowCounter++;
            }
            node=node.next;
        }
        
        int fastCounter=0;
        node=node.next;
        for (int i=0; i<met.step; i++)
        {
            if (node==met.node)
            {
                fastCounter++;
            }
            node=node.next;
        }
        
        int cycle=met.step/fastCounter;
        
        node=head;
        ListNode node2=head;
        for (int i=0; i<met.step-cycle*slowCounter; i++)
        {
            node2=node2.next;
        }
        
        while(node!=node2)
        {
            node=node.next;
            node2=node2.next;
        }
        return node;
    }
    
    class CycleResult
    {
        ListNode node;
        int step;
        
        public CycleResult(ListNode n, int s)
        {
            node=n;
            step=s;
        }
    }
    
    /**
     * detect the cycle
     */
    public CycleResult hasCycle(ListNode head)
    {
        ListNode fast, slow;
        fast=head;
        slow=head;
        int step=0;
        while(fast!=null && fast.next!=null && slow!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            step++;
            if (fast==slow && fast!=null)
            {
                return new CycleResult(fast, step);
            }
        }
        return new CycleResult(null, step);
    }
}
