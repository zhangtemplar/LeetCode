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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // preorder, root is in the begining
        // inorder, root is in the middle
        // note the array may not be sorted
        if (preorder==null || inorder==null || preorder.length<1 || preorder.length!=inorder.length)
        {
            return null;
        }
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    private TreeNode buildTree(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend)
    {
        if (prestart>preend)
        {
            return null;
        }
        else if (prestart==preend)
        {
            return new TreeNode(preorder[prestart]);
        }
        else
        {
            TreeNode root=new TreeNode(preorder[prestart]);
            // looking for the middle in inorder
            int middle=instart;
            for (; middle<=inend; middle++)
            {
                if (inorder[middle]==preorder[prestart])
                {
                    break;
                }
            }
            // split the tree
            root.left=buildTree(preorder, prestart+1, middle-instart+prestart, inorder, instart, middle-1);
            root.right=buildTree(preorder, preend-inend+middle+1, preend, inorder, middle+1, inend);
            return root;
        }
    }
}
