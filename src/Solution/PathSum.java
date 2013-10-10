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
    public boolean hasPathSum(TreeNode root, int sum) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we will use recursion
        // we reach a leaf
        if (root==null)
        {
            return false;
        }
        if (root.left==null && root.right==null)
        {
            return sum==root.val;
        }
        // otherwise, check its children
        else if (root.left!=null && hasPathSum(root.left, sum-root.val))
        {
            return true;
        }
        else if(root.right!=null && hasPathSum(root.right, sum-root.val))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
