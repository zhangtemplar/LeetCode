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
    public TreeNode sortedArrayToBST(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we will recursion, where the middle is put to the root, left-half to the left subtree and right-half to the right subtree
        if (num==null || num.length<1)
        {
            return null;
        }
        TreeNode root=new TreeNode(0);
        sortedArrayToBST(num, 0, num.length-1, root);
        return root;
    }
    
    private void sortedArrayToBST(int[] num, int start, int end, TreeNode root)
    {
        int middle=(start+end)/2;
        root.val=num[middle];
        if (start<middle)
        {
            root.left=new TreeNode(0);
            sortedArrayToBST(num, start, middle-1, root.left);
        }
        if (end>middle)
        {
            root.right=new TreeNode(0);
            sortedArrayToBST(num, middle+1, end, root.right);
        }
    }
}
