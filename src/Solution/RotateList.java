package Solution;

import java.util.LinkedList;

public class RotateList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateList instance=new RotateList();
		ListNode n1=new ListNode(1);
		n1.next=new ListNode(2);
		ListNode n2=instance.rotateRight(n1, 2);
	}

	public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // scan the last element to rotate
        // check the condition
        if (n<1 || head==null)
        {
            return head;
        }
        // we use a queue to find the k-element on the right
        ListNode current=head;
        ListNode removed=null;
        LinkedList<ListNode> queue=new LinkedList<ListNode>();
        while(current!=null)
        {
            if (queue.size()>=n)
            {
                removed=queue.remove();
            }
            queue.add(current);
            current=current.next;
        }
        // check the condition
        // whether the array is long enough
        if (queue.size()<n || removed==null)
        {
            // the queue is not long enough
            // we leave it untouched
            // return head;
            // we need to make it cycle
            n%=queue.size();
            if (n==0)
            {
                return head;
            }
            current=head;
            removed=null;
            queue.clear();
            while(current!=null)
            {
                if (queue.size()>=n)
                {
                    removed=queue.remove();
                }
                queue.add(current);
                current=current.next;
            }
        }
        // length>n
        // set the head
        ListNode result=queue.remove();
        // find the tail
        current=result;
        while(current.next!=null)
        {
            current=current.next;
        }
        // concatenate
        current.next=head;
        // remove the cycle
        removed.next=null;
        return result;
    }
}

//class ListNode 
//{
//	int val;
//	ListNode next;
//	ListNode(int x) 
//	{
//	val = x;
//	next = null;
//	}
//}