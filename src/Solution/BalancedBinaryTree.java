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
    public boolean isBalanced(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // step 1, we compute the depth of each subtree
        if (root==null)
        {
            return true;
        }
        return computeDepth(root)>=0;
    }
    
    private int computeDepth(TreeNode root)
    {
        if (root.left==null && root.right==null)
        {
            return 1;
        }
        else
        {
            int depth=0;
            // check the left tree
            int depth_left=0;
            if (root.left!=null)
            {
                depth_left=computeDepth(root.left);
                if (depth_left<0)
                {
                    return -1;
                }
            }
            int depth_right=0;
            if(root.right!=null)
            {
                depth_right=computeDepth(root.right);
                if (depth_right<0)
                {
                    return -1;
                }
            }
            // check the balance
            if (depth_left>depth_right+1 || depth_left+1<depth_right)
            {
                return -1;
            }
            else
            {
                return (depth_left>depth_right?depth_left:depth_right)+1;
            }
        }
    }
}
