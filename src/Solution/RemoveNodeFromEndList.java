package Solution;

import java.util.LinkedList;

public class RemoveNodeFromEndList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // the idea is, we maintain a queue of size n
        // we scan the list, add any node we met,
        // if the queue is full, delete the head
        // finally, set the next field of the latest remove node to null
        if (n<1)
        {
            // illegal input
            return head;
        }
        LinkedList<ListNode> queue=new LinkedList<ListNode>();
        ListNode node, node_deleted;
        node=head;
        node_deleted=null;
        while(node!=null)
        {
            if (queue.size()<n)
            {
                queue.add(node);
            }
            else
            {
                node_deleted=queue.remove();
                queue.add(node);
            }
            node=node.next;
        }
        if (node_deleted!=null)
        {
            // if node_deleted==null
            // the size of list is small or equal to n
            // so we will do nothing
            // otherwise, we just the next of its prevous to its next
            node_deleted.next=node_deleted.next.next;
        }
        else if (queue.size()==n)
        {
            // when |list|==n
            return head.next;
        }
        return head;
    }
}
