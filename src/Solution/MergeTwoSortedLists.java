package Solution;

public class MergeTwoSortedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeTwoSortedLists instance=new MergeTwoSortedLists();
		ListNode l1=new ListNode(1);
		ListNode l2=null;
		ListNode l3=instance.mergeTwoLists(l1, l2);
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (l1==null)
        {
            return l2;
        }
        else
        {
            ListNode result=l1;
            ListNode prev=null;
            while(l1!=null && l2!=null)
            {
                if (l1.val<=l2.val)
                {
                    if (prev==null)
                    {
                        prev=l1;
                        l1=l1.next;
                    }
                    else
                    {
                        prev.next=l1;
                        prev=l1;
                        l1=l1.next;
                    }
                }
                else
                {
                    // ok, head of l2 is the minimum, i.e., the new head
                    if (prev==null)
                    {
                        result=l2;
                        prev=l2;
                        l2=l2.next;
                    }
                    else
                    {
                        prev.next=l2;
                        prev=l2;
                        l2=l2.next;
                    }
                }
            }
            // post-processing: in case one of the list is unfinised
            if (l2!=null)
            {
                if (prev!=null)
                {
                    prev.next=l2;
                }
            }
            else
            {
                if (prev!=null)
                {
                    prev.next=l1;
                }
            }
            return result;
        }
    }
}
