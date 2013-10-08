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
    public int maxDepth(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we will use recursion
        // the depth is the larger of the depthes of the two subtrees plus 1
        // empty node
        if (root==null)
        {
            return 0;
        }
        int depth=1;
        if (root.left!=null)
        {
            int dl=maxDepth(root.left)+1;
            depth=depth>dl?depth:dl;
        }
        if (root.right!=null)
        {
            int dr=maxDepth(root.right)+1;
            depth=depth>dr?depth:dr;
        }
        return depth;
    }
}
