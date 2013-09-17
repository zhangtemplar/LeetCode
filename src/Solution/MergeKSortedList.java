package Solution;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // the idea is simple, we maintain a min heap, whose size is k
        // for each iteration, we pop the top of the heap and add to the output
        // accordingly we add the next element of the array, from which the poped element comes
        // the complexity is O(sum(n_i)log(k)), where n_i is the length of i_th list
        // when k is 2, the complexity is linear
        if (lists==null || lists.size()<1)
        {
            // illegal input
            return null;
        }
        else if (lists.size()==1)
        {
            // no merge is required
            return lists.get(0);
        }
        else
        {
            // apply the sort
            // maintain an array of pointer for each list
            ListNode []pointer=new ListNode[lists.size()];
            // the head, to-add node, latest node of the resultant list
            ListNode result, previous;
            NodeIndex current;
            result=null;
            current=null;
            previous=null;
            // initialize
            PriorityQueue<NodeIndex> queue=new PriorityQueue<NodeIndex>(lists.size());
            for (int i=0; i<lists.size(); i++)
            {
                // for the pointer of each list
                pointer[i]=lists.get(i);
                // add it to the min heap
                if (pointer[i]!=null)
                {
                    queue.add(new NodeIndex(pointer[i], i));
                }
            }
            // apply the merge
            while (true)
            {
                // exit condition
                if (queue.size()<1)
                {
                    break;
                }
                // pop the top\
                current=queue.poll();
                // add the head of the result
                if (result==null)
                {
                    result=current.node;
                }
                // add the latest eleent to the resultant list
                if (previous!=null)
                {
                    previous.next=current.node;
                    previous=current.node;
                }
                else
                {
                    previous=current.node;
                }
                // add the next element of that list into the heap
                pointer[current.index]=current.node.next;
                if (pointer[current.index]!=null)
                {
                    queue.add(new NodeIndex(pointer[current.index], current.index));
                }
            }
            return result;
        }
    }
}

class NodeIndex implements Comparable<NodeIndex>
{
    public ListNode node;
    public int index;
    public NodeIndex(ListNode n, int i)
    {
        node=n;
        index=i;
    }
    
    // this is required for building the min heap
    // the order only depends on the value of the node
    public int compareTo(NodeIndex n)
    {
        return node.val-n.node.val;
    }
}