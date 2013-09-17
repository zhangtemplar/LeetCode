package Solution;

import java.util.HashMap;

public class ConstructBinaryTreeFromPostorderAndInorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // in-order: left node right
        // pre-order: node left right
        // post-order: left right node
        // the idea is similar the previous except that, the root is always at the end
        // for the postorder
        if (postorder==null || postorder.length<1 || inorder==null || inorder.length<1 || postorder.length!=inorder.length)
        {
            return null;
        }
        TreeNode root=new TreeNode(postorder[postorder.length-1]);
        // search the root in the inorder array
        HashMap<Integer, Integer> table=new HashMap<Integer, Integer>();
        for (int i=0; i<inorder.length; i++)
        {
            table.put(inorder[i], i);
        }
        // search the root in the inorder array
        int i=table.get(root.val);
        root.left=buildTree(postorder, 0, i-1, table, 0, i-1);
        root.right=buildTree(postorder, i, postorder.length-2, table, i+1, inorder.length-1);
        return root;
    }
    
    /**
     * root: the root of current subtree
     * preorder[start1:end1] the subarray we are processing
     * inorder[start1:end2] the subarray we processing
     */
    private TreeNode buildTree(int []postorder, int start1, int end1, HashMap<Integer, Integer> table, int start2, int end2)
    {
        if (start1>end1)
        {
            return null;
        }
        TreeNode root=new TreeNode(postorder[end1]);
        // this is a leaf node
        if (start1==end1 || start2==end2)
        {
            return root;
        }
        // otherwise, repeat what we have before
        int i=table.get(root.val);
        root.left=buildTree(postorder, start1, i+start1-start2-1, table, start2, i-1);
        root.right=buildTree(postorder, i+start1-start2, end1-1, table, i+1, end2);
        return root;
    }
}
