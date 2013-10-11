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
    public int minDepth(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (root==null)
        {
            return 0;
        }
        else if(root.left==null && root.right==null)
        {
            return 1;
        }
        else if(root.left==null)
        {
            return minDepth(root.right)+1;
        }
        else if(root.right==null)
        {
            return minDepth(root.left)+1;
        }
        else
        {
            int depth_left=minDepth(root.left)+1;
            int depth_right=minDepth(root.right)+1;
            return depth_left<depth_right?depth_left:depth_right;
        }
    }
}
