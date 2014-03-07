package trial3;

public class FlattenBinaryTreeToLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
     * we need to do it under pre-order process
     */
    public void flatten(TreeNode root) {
        subFlatten(root);
    }
    
    private TreeNode subFlatten(TreeNode root)
    {
        if (root==null)
        {
            return null;
        }
        else if(root.left==null && root.right==null)
        {
            return root;
        }
        else
        {
            TreeNode right=root.right;
            TreeNode left=null;
            // move the left to the right then flatten left subtree, return the last (rightmost) node in the subtree
            if (root.left!=null)
            {
                root.right=root.left;
                root.left=null;
                left=subFlatten(root.right);
                left.right=right;
            }
            // add the right subtree to the right child of last node
            if (right!=null)
            {
                return subFlatten(right);
            }
            else
            {
                return left;
            }
        }
    }
}
