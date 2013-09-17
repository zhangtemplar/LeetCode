package Solution;

import java.util.Arrays;
import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructBinaryTreeFromPreorderAndInorderTraversal instance=new ConstructBinaryTreeFromPreorderAndInorderTraversal();
		int[] preorder={1, 2};
		int[] inorder={2, 1};
		TreeNode root=instance.buildTree(preorder, inorder);
		System.out.println(root);
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // in-order: left node right
        // pre-order: node left right
        // for the the pre-order of any subtree, node is always at the first
        // if we search this one the in-order, we know how many ndoes are in the left
        // and right subtrees
        // we can repeat this procedure.
        if (preorder==null || preorder.length<1 || inorder==null || inorder.length<1 || preorder.length!=inorder.length)
        {
            return null;
        }
        TreeNode root=new TreeNode(preorder[0]);
        // search the root in the inorder array
        HashMap<Integer, Integer> table=new HashMap<Integer, Integer>();
        for (int i=0; i<inorder.length; i++)
        {
            table.put(inorder[i], i);
        }
        // search the root in the inorder array
        int i=table.get(preorder[0]);
        root.left=buildTree(preorder, 1, i, table, 0, i-1);
        root.right=buildTree(preorder, i+1, preorder.length-1, table, i+1, inorder.length-1);
        return root;
    }
    
    /**
     * root: the root of current subtree
     * preorder[start1:end1] the subarray we are processing
     * inorder[start1:end2] the subarray we processing
     */
    private TreeNode buildTree(int []preorder, int start1, int end1, HashMap<Integer, Integer> table, int start2, int end2)
    {
        if (start1>end1)
        {
            return null;
        }
        TreeNode root=new TreeNode(preorder[start1]);
        // this is a leaf node
        if (start1==end1 || start2==end2)
        {
            return root;
        }
        // otherwise, repeat what we have before
        int i=table.get(preorder[start1]);
        root.left=buildTree(preorder, start1+1, i+start1-start2, table, start2, i-1);
        root.right=buildTree(preorder, i+start1-start2+1, end1, table, i+1, end2);
        return root;

    }
}
