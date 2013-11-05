public class Solution {
    public String minWindow(String S, String T) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // we will first set the window to the whole S
        // if the windows contains necessary char of T
        // we shrink on the left until the condition holds
        // otherwise, we take a step back and shrink on the right
        if (S==null || T==null || S.length()<T.length())
        {
            return "";
        }
        int left=0;
        int right=T.length()-1;
        QuickTable table=new QuickTable();
        for (int i=0; i<T.length(); i++)
        {
            table.remove(T.charAt(i));
            table.add(S.charAt(i));
        }
        int min=Integer.MAX_VALUE;
        int []result=new int[2];
        result[0]=0;
        result[1]=S.length()-1;
        while(right<S.length())
        {
            if (table.isValid())
            {
                if (min>right-left+1)
                {
                    min=right-left+1;
                    result[0]=left;
                    result[1]=right;
                }
                table.remove(S.charAt(left++));
            }
            else if(right<S.length()-1)
            {
                table.add(S.charAt(++right));
            }
            else
            {
                break;
            }
        }
        if (min>S.length())
        {
            return "";
        }
        else
        {
            return S.substring(result[0], result[1]+1);
        }
    }
}

class QuickTable
{
    private TableNode head, tail;
    private HashMap<Character, TableNode> table;
    
    public QuickTable()
    {
        head=null;
        tail=null;
        table=new HashMap<Character, TableNode>();
    }
    
    // remove the couning of a word
    public void remove(char c)
    {
        // check whether we have a count for it
        if (table.containsKey(c))
        {
            // found a node
            TableNode node=table.get(c);
            // decrease the count
            node.val--;
            if (node.val>=0 || node==head)
            {
            }
            // if it converts to -1, we move it to the head
            else if(node==tail)
            {
                tail=node.prev;
                node.prev.next=null;
                node.prev=null;
                head.prev=node;
                node.next=head;
                head=node;
            }
            else
            {
                node.prev.next=node.next;
                node.next.prev=node.prev;
                node.next=head;
                head.prev=node;
                head=node;
            }
        }
        else
        {
            TableNode node=new TableNode(c, -1);
            table.put(c, node);
            node.next=head;
            if (head!=null)
            {
            	head.prev=node;
            }
            head=node;
        }
        // for singleton case
        if (tail==null)
        {
            tail=head;
        }
    }
    
    public void add(char c)
    {
        // check whether we have a count for it
        if (table.containsKey(c))
        {
            // found a node
            TableNode node=table.get(c);
            node.val++;
            // decrease the count
            if (node.val<0 || node==tail)
            {
            }
            // if it converts to 0, we move it to the tail
            else if(node==head)
            {
                head=head.next;
                head.prev=null;
                node.next=null;
                node.prev=tail;
                tail.next=node;
                tail=node;
            }
            else
            {
                node.prev.next=node.next;
                node.next.prev=node.prev;
                node.prev=tail;
                tail.next=node;
                tail=node;
            }
        }
        else
        {
            TableNode node=new TableNode(c, 1);
            table.put(c, node);
            node.prev=tail;
            if (tail!=null)
            {
            	tail.next=node;
        	}
            tail=node;
        }
        // for singleton case
        if (head==null)
        {
            head=tail;
        }
    }
    
    public boolean isValid()
    {
        if (head!=null)
        {
            return head.val>=0;
        }
        return true;
    }
}

class TableNode
{
    public char c;
    public int val;
    public TableNode next, prev;
    public TableNode(char ch, int x)
    {
        c=ch;
        val=x;
        next=null;
        prev=null;
    }
}
