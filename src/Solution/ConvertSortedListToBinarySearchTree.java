/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ListNode tail=head;
        while(tail!=null && tail.next!=null)
        {
            tail=tail.next;
        }
        return sortedListToBST(head, tail);
    }
    
    private TreeNode sortedListToBST(ListNode head, ListNode tail)
    {
        // to convert an sorted array to a BST, we always use middle as root and iterate this step
        // so the problem is how to find the middle fast
        if (head==null)
        {
            return null;
        }
        else if(head==tail)
        {
            return new TreeNode(head.val);
        }
        else
        {
            // find the previous of middle, note, the left half could have one more node than the right half
            ListNode middle=head;
            ListNode end=head;
            while(end!=null && end.next!=tail && end.next!=null && end.next.next!=tail)
            {
                middle=middle.next;
                end=end.next.next;
            }
            TreeNode root=new TreeNode(middle.next.val);
            root.left=sortedListToBST(head, middle);
            if(head.next!=tail)
            {
            	root.right=sortedListToBST(middle.next.next, tail);
            }
            return root;
        }
    }
}
