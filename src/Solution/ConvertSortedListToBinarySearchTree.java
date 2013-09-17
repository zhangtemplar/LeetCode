package Solution;

public class ConvertSortedListToBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // the point is how to find the middle point quickly
        if (head==null)
        {
            return null;
        }
        ListNode middle=findMiddle(head, null);
        TreeNode root=new TreeNode(middle.val);
        root.left=sortedListToBST(head, middle);
        root.right=sortedListToBST(middle.next, null);
        return root;
    }
    
    // build a subtree for list [start, end), i.e., end is exclusive
    public TreeNode sortedListToBST(ListNode start, ListNode end)
    {
        if (start==null || start==end)
        {
            return null;
        }
        ListNode middle=findMiddle(start, end);
        TreeNode root=new TreeNode(middle.val);
        if (start.next==end)
        {
            return root;
        }
        root.left=sortedListToBST(start, middle);
        root.right=sortedListToBST(middle.next, end);
        return root;
    }
    
    // end is exclusive
    public ListNode findMiddle(ListNode start, ListNode end)
    {
        ListNode middle, terminate;
        middle=start;
        terminate=start;
        while(terminate!=null && terminate.next!=null && terminate!=end && terminate.next!=end)
        {
            middle=middle.next;
            terminate=terminate.next.next;
        }
        return middle;
    }
}
