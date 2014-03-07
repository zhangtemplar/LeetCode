package trial3;

public class ConvertSortedListToBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
     * use a recursion
     * find the middle of the list
     * cut the list into two balanced sub lists
     * add the sublist to the bst
     * the complexity would be O(nlogn), as searching of middle takes o(n)
     */
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, null);
    }
    
    /**
     * convert the sorted list (head>...>tail) to a BST
     * tail is exclused.
     */
    private TreeNode sortedListToBST(ListNode head, ListNode tail)
    {
        if (head==null || head==tail)
        {
            return null;
        }
        else if(head.next==tail)
        {
            return new TreeNode(head.val);
        }
        else
        {
            ListNode middle=findMiddle(head, tail);
            TreeNode root=new TreeNode(middle.val);
            root.left=sortedListToBST(head, middle);
            root.right=sortedListToBST(middle.next, tail);
            return root;
        }
    }
    
    /**
     * find the middle in the list
     */
    private ListNode findMiddle(ListNode head, ListNode tail)
    {
        ListNode fast, slow;
        fast=head;
        slow=head;
        while(fast!=null && slow!=null && fast.next!=null && slow!=tail && fast!=tail && fast.next!=tail)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
