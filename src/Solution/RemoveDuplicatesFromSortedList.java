package Solution;

import java.util.HashSet;

public class RemoveDuplicatesFromSortedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode deleteDuplicates(ListNode head)
	{
		if (head==null)
		{
			return null;
		}
		HashSet<Integer> set=new HashSet<Integer>();
		set.add(head.val);
		ListNode prev, current;
		prev=head;
		current=prev.next;
		while(current!=null)
		{
			if (set.contains(current.val))
			{
				prev.next=current.next;
				current=current.next;
			}
			else
			{
				prev=prev.next;
				current=current.next;
			}
		}
		return head;
	}
}
