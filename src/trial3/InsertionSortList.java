package trial3;

import java.util.HashMap;

public class InsertionSortList {
	public static void main(String[] args)
	{
		ListNode head=new ListNode(3);
		head.next=new ListNode(2);
		head.next.next=new ListNode(1);
		
		ListNode result=new InsertionSortList().insertionSortList(head);
		
		System.out.println(result);
	}
	
	/**
     * we will use the algorithm slight different from one on Wiki
     * we start from the tail
     */
    public ListNode insertionSortList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head==null || head.next==null)
        {
            return head;
        }
        ListNode result=new ListNode(0);
        result.next=head;
        HashMap<ListNode, ListNode> neighbor=new HashMap<ListNode, ListNode>();
        ListNode ptr=result;
        while(ptr.next!=null)
        {
            neighbor.put(ptr.next, ptr);
            ptr=ptr.next;
        }
        // start from the end
        while(ptr!=result)
        {
            ListNode cur=ptr;
            ListNode prv=neighbor.get(ptr);
            while(cur!=null && cur.next!=null && cur.val>cur.next.val)
            {
                prv.next=cur.next;
                prv=cur.next;
                // swap cur and cur.next
                ListNode next=cur.next;
                cur.next=next.next;
                next.next=cur;
            }
            ptr=neighbor.get(ptr);
        }
        return result.next;
    }
}
