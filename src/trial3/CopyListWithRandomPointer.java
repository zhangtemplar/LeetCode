package trial3;

import java.util.HashMap;

public class CopyListWithRandomPointer {
	/**
     * we simply copy every node we met and follow all the pointer we found
     * however, to avoid deadloop, we keep a record of the nodes we copied
     * we can use recursion or stack
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        return copyRandomList(head, new HashMap<RandomListNode, RandomListNode>());
    }
    
    private RandomListNode copyRandomList(RandomListNode head, HashMap<RandomListNode, RandomListNode> visited)
    {
        if (visited.containsKey(head))
        {
            return visited.get(head);
        }
        else
        {
            if (head==null)
            {
                return null;
            }
            RandomListNode result=new RandomListNode(head.label);
            visited.put(head, result);
            if (head.next!=null)
            {
                result.next=copyRandomList(head.next, visited);
            }
            if (head.random!=null)
            {
                result.random=copyRandomList(head.random, visited);
            }
            return result;
        }
    }
}
