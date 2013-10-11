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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we know in inorder traverse, the root is in the middle (i.e., seperate the left and right subtree)
        // in postorder traverse, the root is always in the end
        // we can use the root obtained in postorder, to find the separator of left and right subtree
        if (inorder==null || postorder==null || inorder.length<1 || postorder.length<1 || inorder.length!=postorder.length)
        {
            return null;
        }
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    private TreeNode buildTree(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend)
    {
        TreeNode root=new TreeNode(postorder[postend]);
        // this is a leaf node
        if (instart==inend)
        {
            return root;
        }
        // search the root
        int middle=Arrays.binarySearch(inorder, instart, inend+1, postorder[postend]);
        if (middle<0)
        {
            // the root can't be found, some errors there
            return root;
        }
        // we build the left tree and right tree accordingly.
        if (instart<middle)
        {
            root.left=buildTree(inorder, instart, middle-1, postorder, poststart, middle-1-instart+poststart);
        }
        if (middle<inend)
        {
            root.right=buildTree(inorder, middle+1, inend, postorder, postend-inend+middle, postend-1);
        }
        return root;
    }
}
