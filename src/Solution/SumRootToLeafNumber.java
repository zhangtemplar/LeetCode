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
    public int sumNumbers(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // sounds like a recursion
        if (root==null)
        {
            return 0;
        }
        return sumNumbers(root, 0);
    }
    
    private int sumNumbers(TreeNode root, int sum)
    {
        // leaf node
        if (root.left==null && root.right==null)
        {
            return sum*10+root.val;
        }
        // otherwise
        sum=sum*10+root.val;
        int result=0;
        if (root.left!=null)
        {
            result+=sumNumbers(root.left, sum);
        }
        if (root.right!=null)
        {
            result+=sumNumbers(root.right, sum);
        }
        return result;
    }
}
