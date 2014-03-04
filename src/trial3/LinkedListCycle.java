package trial3;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
        if (head==null || head.next==null)
        {
            return false;
        }
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
                return true;
            }
        }
        return false;
    }
}
