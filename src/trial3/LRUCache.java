package trial3;

import java.util.HashMap;

public class LRUCache {
	public static void main(String[] args)
	{
		LRUCache test=new LRUCache(10);
		test.set(10,13);
		test.set(3,17);
		test.set(6,11);
		test.set(10,5);
		test.set(9,10);
		test.get(13);
		test.set(2,19);
		test.get(2);
		test.get(3);
		test.set(5,25);
		test.get(8);
		test.set(9,22);
		test.set(5,5);
		test.set(1,30);
		test.get(11);
		test.set(9,12);
		test.get(7);
		test.get(5);
		test.get(8);
		test.get(9);
		test.set(4,30);
		test.set(9,3);
		test.get(9);
		test.get(10);
		test.get(10);
		test.set(6,14);
		test.set(3,1);
		test.get(3);
		test.set(10,11);
		test.get(8);
		test.set(2,14);
		test.get(1);
		test.get(5);
		test.get(4);
		test.set(11,4);
		test.set(12,24);
		test.set(5,18);
		test.get(13);
		test.set(7,23);
		test.get(8);
		test.get(12);
		test.set(3,27);
		test.set(2,12);
		test.get(5);
		test.set(2,9);
		test.set(13,4);
		test.set(8,18);
		test.set(1,7);
		test.get(6);
		test.set(9,29);
		test.set(8,21);
		test.get(5);
		test.set(6,30);
		test.set(1,12);
		test.get(10);
		test.set(4,15);
		test.set(7,22);
		test.set(11,26);
		test.set(8,17);
		test.set(9,29);
		test.get(5);
		test.set(3,4);
		test.set(11,30);
		test.get(12);
		test.set(4,29);
		test.get(3);
		test.get(9);
		test.get(6);
		test.set(3,4);
		test.get(1);
		test.get(10);
		test.set(3,29);
		test.set(10,28);
		test.set(1,20);
		test.set(11,13);
		test.get(3);
		test.set(3,12);
		test.set(3,8);
		test.set(10,9);
		test.set(3,26);
		test.get(8);
		test.get(7);
		test.get(5);
		test.set(13,17);
		test.set(2,27);
		test.set(11,15);
		test.get(12);
		test.set(9,19);
		test.set(2,15);
		test.set(3,16);
		test.get(1);
		test.set(12,17);
		test.set(9,1);
		test.set(6,19);
		test.get(4);
		test.get(5);
		test.get(5);
		test.set(8,1);
		test.set(11,7);
		test.set(5,2);
		test.set(9,28);
		test.get(1);
		test.set(2,2);
		test.set(7,4);
		test.set(4,22);
		test.set(7,24);
		test.set(9,26);
		test.set(13,28);
		test.set(11,26);
	}
	
	private LinkedHashMap cache;
    private int max;
    
    public LRUCache(int capacity) {
        cache=new LinkedHashMap(capacity);
        max=capacity;
    }
    
    public int get(int key) {
        if (cache.containsKey(key))
        {
            // update it
            int val=cache.get(key);
            cache.remove(key);
            cache.put(key, val);
            return val;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if (cache.size()>=max && !cache.containsKey(key))
        {
            cache.removeOldest();
            cache.put(key, value);
        }
        else
        {
        	if (cache.containsKey(key))
        	{
        		cache.remove(key);
        	}
            cache.put(key, value);
        }
    }
    
    public String toString()
    {
    	return cache.toString();
    }
}

/**
 * to implement the linkedHashMap, we will use double linked list for this purpose.
 * in addition, the head and tail will be used to speed up the process
 */
class LinkedHashMap
{
    // the linked list stores the data
    DoubleLinkNode head;
    // the hashmap provides the index
    HashMap<Integer, DoubleLinkNode> map;
    
    public LinkedHashMap(int capacity)
    {
        map=new HashMap<Integer, DoubleLinkNode>(capacity);
        // the head is dummy
        head=new DoubleLinkNode(0,0);
    }
    
    public LinkedHashMap()
    {
        this(10);
    }
    
    public int size()
    {
        return map.size();
    }
    
    public boolean containsKey(int k)
    {
        return map.containsKey(k);
    }
    
    public int get(int k)
    {
        assert(containsKey(k));
        return map.get(k).val;
    }
    
    public void put(int k, int v)
    {
        if (containsKey(k))
        {
            map.get(k).val=v;
        }
        else
        {
            DoubleLinkNode node=new DoubleLinkNode(k, v);
            // put it to the end
            node.prev=head.prev;
            node.next=head;
            head.prev.next=node;
            head.prev=node;
            map.put(k, node);
        }
    }
    
    public void remove(int k)
    {
        assert(containsKey(k));
        DoubleLinkNode node=map.get(k);
        if (node.next==head && node.prev==head)
        {
            // the only node in the list
            head.next=head;
            head.prev=head;
        }
        else
        {
            node.prev.next=node.next;
            node.next.prev=node.prev;
        }
        map.remove(k);
    }
    
    public void removeOldest()
    {
        assert(map.size()>0);
        DoubleLinkNode node=head.next;
        head.next=node.next;
        node.next.prev=head;
        map.remove(node.key);
    }
    
    public String toString()
    {
    	return head.toString();
    }
}

class DoubleLinkNode
{
    int val;
    int key;
    DoubleLinkNode prev;
    DoubleLinkNode next;
    public DoubleLinkNode(int k, int v)
    {
        val=v;
        key=k;
        prev=this;
        next=this;
    }
    
    public String toString()
    {
    	StringBuilder str=new StringBuilder();
    	str.append("[");
    	str.append(key);
    	str.append("=");
    	str.append(val);
    	str.append("]");
    	DoubleLinkNode node=this.next;
    	while(node!=this)
    	{
    		str.append(">");
    		str.append("[");
        	str.append(node.key);
        	str.append("=");
        	str.append(node.val);
        	str.append("]");
        	node=node.next;
    	}
    	return str.toString();
    }
}
