package Solution;

import java.util.HashMap;

/**
 * this class implement a fast counting table, which support following functions
 * 1	store the required counting of the target data
 * 2	quick adjust the counting
 * 3	quickly found any data which dosen't met requirement (assuming that we want all the counting being nonpositive
 * all three operation has constant time cost
 * the idea is that, we maintain a double linked list, where the node has field data and count
 * we always make sure the node with positive count is before the node with negative count
 * which can be simply achieved by moving the node whose count is just increased to 1 to the head
 * and the node whose count is just decreased to 0 to the tail
 * @author qzhang53
 *
 */
public class QuickCountTable <Anytype extends Comparable<Anytype>> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickCountTable<Character> list1=new QuickCountTable<Character>();
		String T="xbnpukocakzqzuhdlxoga";
		for(int i=0; i<T.length(); i++)
		{
			list1.add(T.charAt(i));
		}
		System.out.println(list1);
		String S="xeaifhaqslynbcwxncwgeezbrjorzyuwevejcecuscjvg";
		QuickCountTable<Character> list2=new QuickCountTable<Character>();
		for(int i=0; i<S.length(); i++)
		{
			list2.add(S.charAt(i));
		}
		System.out.println(list2);
	}

	// we will store the data into a double linked list
	// we will also maintain a variable called tail to a quick insert
	private QuickCountTableNode<Anytype> head, tail;
	// the node of this list will be indexed via a hashmap
	// key is the data and the value is the node where the count of this data is stored
	private HashMap<Anytype, QuickCountTableNode<Anytype>> list;
	
	// constructor
	public QuickCountTable()
	{
		head=null;
		tail=null;
		list=new HashMap<Anytype, QuickCountTableNode<Anytype>>();
	}
	
	/** 
	 * this should only be used for initialize the list
	 * if the data is not found in the list, we create a new node for it and set the count to 1 then move
	 * it to the head
	 * otherwise, we retrieve the node with the data and increase its count by 1
	 */
	public void add(Anytype x)
	{
		// first check whether x is already included
		if (list.containsKey(x))
		{
			// we already have it in the list
			QuickCountTableNode<Anytype> node=list.get(x);
			node.cnt++;
			if (node.cnt==1)
			{
				if (node==tail)
				{
					tail=node.prev;
				}
				// this node has count<=0 before, we move it to the head
				if (node.prev!=null)
				{
					node.prev.next=node.next;
				}
				if (node.next!=null)
				{
					node.next.prev=node.prev;
				}
				node.next=head;
				if (head!=null && head!=null)
				{
					head.prev=node;
				}
				if (head!=null)
				{
					node.prev=null;
				}
				head=node;
			}
		}
		else
		{
			// we haven't met it before, we create a new node for it and insert it to the head
			QuickCountTableNode<Anytype> node=new QuickCountTableNode<Anytype>(x);
			node.cnt=1;
			node.next=head;
			if (head!=null && head!=null)
			{
				head.prev=node;
			}
			head=node;
			list.put(x, node);
		}
		// for the case the list has only one element
		if (tail==null)
		{
			tail=head;
		}
	}
	
	/**
	 * when we remove a new data (e.g., shrink the window), we look it up in the hashmap
	 * if it is found, we decrease its count. If it becomes 1, we move it to the head
	 * otherwise, we just do nothing
	 * @param x
	 */
	public void increase(Anytype x)
	{
		// first check whether x is already included
		if (list.containsKey(x))
		{
			// we already have it in the list
			QuickCountTableNode<Anytype> node=list.get(x);
			node.cnt++;
			if (node.cnt==1)
			{
				// avoid the loop
				if (node==tail)
				{
					tail=node.prev;
				}
				// this node has count<=0 before, we move it to the head
				if (node.prev!=null)
				{
					node.prev.next=node.next;
				}
				if (node.next!=null)
				{
					node.next.prev=node.prev;
				}
				node.next=head;
				if (head!=null && head!=null)
				{
					head.prev=node;
				}
				if (head!=null)
				{
					node.prev=null;
				}
				head=node;
			}
		}
	}

	/**
	 * when we met a new data, we look it up in the hashmap
	 * if it is found, we decrease its count. If it becomes 0, we move it to the tail
	 * otherwise, we just do nothing
	 * @param x
	 */
	public void decrease(Anytype x)
	{
		if (list.containsKey(x))
		{
			// we already have it in the list
			QuickCountTableNode<Anytype> node=list.get(x);
			node.cnt--;
			if (node.cnt==0)
			{
				// save the head first
				if(node==head)
				{
					head=node.next;
				}
				// this node has count>0 before, we move it to the tail
				if (node.prev!=null)
				{
					node.prev.next=node.next;
				}
				if (node.next!=null)
				{
					node.next.prev=node.prev;
				}
				node.next=null;
				if (tail!=null && tail!=node)
				{
					tail.next=node;
				}
				if (tail!=node)
				{
					node.prev=tail;
				}
				tail=node;
			}
		}
	}
	
	/**
	 * for being valid, we require the count of all the value in the list is nonpositive
	 * from the algorithm, we already make sure the value with positive count is always 
	 * before the node with nonpositive count
	 * thus we only need to check the first element
	 * @return
	 */
	public boolean isValid()
	{
		if(head!=null)
		{
			if (head.cnt<=0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * just visualize the hashmap
	 */
	public String toString()
	{
		StringBuffer result=new StringBuffer();
		QuickCountTableNode<Anytype> node=head;
		while(node!=null)
		{
			result.append("["+node+"]");
			node=node.next;
		}
		return result.toString();
	}
}

/**
 * the class to store the count and table
 * it also maintain two references to its next and previous
 * @author qzhang53
 *
 * @param <Anytype>
 */
class QuickCountTableNode<Anytype>
{
	public Anytype val;
	public int cnt;
	public QuickCountTableNode<Anytype> next;
	public QuickCountTableNode<Anytype> prev;
	public QuickCountTableNode(Anytype v)
	{
		val=v;
		cnt=0;
		next=null;
		prev=null;
	}
	
	public String toString()
	{
		return new String(val+","+cnt);
	}
}