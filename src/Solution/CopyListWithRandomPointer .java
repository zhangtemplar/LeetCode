/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // to avoid the duplicates, we need to record the node we already processed
        // we already use the queue to store the lists of nodes, which we have visited but not processed
        if (head==null)
        {
            return head;
        }
        return copyRandomList(head, new HashMap<RandomListNode, RandomListNode>());
    }
    
    /**
     * @param head the node to be copied
     * @param map the hashmap whose key is the source node and value is the copied node
     * @return the copied node
     */
    private RandomListNode copyRandomList(RandomListNode head, HashMap<RandomListNode, RandomListNode> map)
    {
        // we have processed this key before
        if (map.containsKey(head))
        {
            return map.get(head);
        }
        // a new node
        else
        {
            RandomListNode node=new RandomListNode(head.label);
            map.put(head, node);
            if (head.next!=null)
            {
                node.next=copyRandomList(head.next, map);
            }
            if (head.random!=null)
            {
                node.random=copyRandomList(head.random, map);
            }
            return node;
        }
    }
}
