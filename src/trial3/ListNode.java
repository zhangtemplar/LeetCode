package trial3;

public class ListNode {

	int val;
	ListNode next;
	public ListNode(int v)
	{
		val=v;
	}
	
	public String toString()
	{
		StringBuilder str=new StringBuilder();
    	str.append(val);
    	ListNode node=this.next;
    	while(node!=null)
    	{
    		str.append(">");
        	str.append(node.val);
        	node=node.next;
    	}
    	return str.toString();
	}
}
