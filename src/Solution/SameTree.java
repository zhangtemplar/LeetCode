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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we will use recursion
        if (p==null)
        {
            if (q==null)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        // p!=null
        if (q==null)
        {
            return false;
        }
        // check the value
        if (p.val==q.val)
        {
            // check the subtree
            // left tree first
            if (p.left==null)
            {
                if (q.left!=null)
                {
                    return false;
                }
            }
            else
            {
                if (q.left==null)
                {
                    return false;
                }
                else if(!isSameTree(p.left, q.left))
                {
                    return false;
                }
            }
            // so far so good, then check the right subtree
            if (p.right==null)
            {
                return q.right==null;
            }
            else
            {
                if (q.right==null)
                {
                    return false;
                }
                else
                {
                    return isSameTree(p.right, q.right);
                }
            }
        }
        else
        {
            return false;
        }
    }
}
