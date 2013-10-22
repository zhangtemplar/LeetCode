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
    public void flatten(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // recursion
        subFlatten(root);
    }
    
    // we always return the last node in the current list
    private TreeNode subFlatten(TreeNode root)
    {
        if (root==null)
        {
            return null;
        }
        TreeNode right=root.right;
        TreeNode tail=root;
        root.right=null;
        // preorder: root.next is the its left subtree
        if (root.left!=null)
        {
            tail=subFlatten(root.left);
            root.right=root.left;
        }
        // right subtree is concatenated to the end of the list
        if (right!=null)
        {
            tail.right=right;
            tail=subFlatten(right);
            TreeNode node=root;
        }
        return tail;
    }
}
