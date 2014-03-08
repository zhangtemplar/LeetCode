package trial3;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
     * for postorder traversal, the root node is always in the end
     * for inorder traversal, the root node is always in the center
     * thus we can use the last node of postorer traversal to identify the root
     * thus cut the inorder traversal into two pieces
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (inorder==null || postorder==null || inorder.length<1 || postorder.length<1 || inorder.length!=postorder.length)
        {
            return null;
        }
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    /**
     * note that, the tree is not necesary a bst, thus inorder is not sorted
     */
    private TreeNode buildTree(int[] inorder, int startInorder, int endInorder, int[] postorder, int startPostorder, int endPostorder)
    {
        if (startInorder>endInorder || startPostorder>endPostorder || endPostorder-startPostorder!=endInorder-startInorder)
        {
            return null;
        }
        else if (startInorder==endInorder || startPostorder==endPostorder)
        {
            return new TreeNode(inorder[startInorder]);
        }
        else
        {
            TreeNode root=new TreeNode(postorder[endPostorder]);
            int middle=-1;
            for (int i=startInorder; i<=endInorder; i++)
            {
                if (root.val==inorder[i])
                {
                    middle=i;
                    break;
                }
            }
            // error
            if (middle<startInorder || middle>endInorder)
            {
                return null;
            }
            root.left=buildTree(inorder, startInorder, middle-1, postorder, startPostorder, middle-1-startInorder+startPostorder);
            root.right=buildTree(inorder, middle+1, endInorder, postorder, middle-startInorder+startPostorder, endPostorder-1);
            return root;
        }
    }
}
