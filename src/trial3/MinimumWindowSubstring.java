package trial3;

import java.util.HashMap;

public class MinimumWindowSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new MinimumWindowSubstring().minWindow("a", "a"));
	}
	public String minWindow(String S, String T) {
        if (S==null || S.length()<1 || T==null || T.length()<1 || S.length()<T.length())
        {
            return "";
        }
        // the search window is S[i:j]
        int i, j;
        WordCounter counter=new WordCounter();
        for (i=0; i<T.length(); i++)
        {
            counter.remove(T.charAt(i));
        }
        i=0;
        j=0;
        counter.add(S.charAt(0));
        // the current best window
        int best_i=-1;
        int best_j=S.length();
        while(j<S.length())
        {
            if (counter.check())
            {
                if (j-i<best_j-best_i)
                {
                    best_j=j;
                    best_i=i;
                }
                if (i<=j)
                {
                    counter.remove(S.charAt(i));
                    i++;
                }
                else
                {
                	j++;
                    if (j<S.length())
                    {
                        counter.add(S.charAt(j));
                    }
                }
            }
            else
            {
                j++;
                if (j<S.length())
                {
                    counter.add(S.charAt(j));
                }
            }
        }
        if (best_i>-1 && best_j<S.length())
        {
            return S.substring(best_i, best_j+1);
        }
        return "";
    }
}

/**
 * new class for counting the word in the list
 * especially we will make sure the negative count will in the head
 */
class WordCounter
{
	/**
	 * double linked list
	 */
	class DoubleLinkNode
	{
	    int val;
	    char key;
	    DoubleLinkNode prev;
	    DoubleLinkNode next;
	    public DoubleLinkNode(char k, int v)
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
    DoubleLinkNode head;
    HashMap<Character, DoubleLinkNode> map;
    
    public WordCounter()
    {
        head=new DoubleLinkNode((char)0,0);
        map=new HashMap<Character, DoubleLinkNode>();
    }
    
    /**
     * increase the count
     */
    public void add(char key)
    {
        if (map.containsKey(key))
        {
            DoubleLinkNode node=map.get(key);
            node.val++;
            /**
             * used to be negative, we need to move it to the tail, if not now
             */
            if (node.val==0 && node.next!=head)
            {
                node.prev.next=node.next;
                node.next.prev=node.prev;
                
                node.prev=head.prev;
                node.prev.next=node;
                node.next=head;
                head.prev=node;
            }
        }
        else
        {
            // create a new entry
            DoubleLinkNode node=new DoubleLinkNode(key, 1);
            map.put(key, node);
            node.prev=head.prev;
            head.prev.next=node;
            node.next=head;
            head.prev=node;
        }
    }
    
    /**
     * decrease the count
     */
    public void remove(char key)
    {
        if (map.containsKey(key))
        {
            DoubleLinkNode node=map.get(key);
            node.val--;
            /**
             * used to be nonnegative, we need to move it to the head, if not now
             */
            if (node.val==-1 && node.prev!=head)
            {
                node.next.prev=node.prev;
                node.prev.next=node.next;
                
                node.next=head.next;
                head.next.prev=node;
                node.prev=head;
                head.next=node;
            }
        }
        else
        {
            // create a new entry and put it to the head
            DoubleLinkNode node=new DoubleLinkNode(key, -1);
            map.put(key, node);
            node.next=head.next;
            head.next.prev=node;
            node.prev=head;
            head.next=node;
        }
    }
    
    /**
     * check the first count
     */
    public boolean check()
    {
        if (head.next!=head)
        {
            return head.next.val>-1;
        }
        return true;
    }
}
