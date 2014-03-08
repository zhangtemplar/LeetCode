package trial3;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (inorder==null || preorder==null || inorder.length<1 || preorder.length<1 || inorder.length!=preorder.length)
        {
            return null;
        }
        return buildTree(inorder, 0, inorder.length-1, preorder, 0, preorder.length-1);
    }
    
    /**
     * note that, the tree is not necesary a bst, thus inorder is not sorted
     */
    private TreeNode buildTree(int[] inorder, int startInorder, int endInorder, int[] preorder, int startPreorder, int endPreorder)
    {
        if (startInorder>endInorder || startPreorder>endPreorder || endPreorder-startPreorder!=endInorder-startInorder)
        {
            return null;
        }
        else if (startInorder==endInorder || startPreorder==endPreorder)
        {
            return new TreeNode(inorder[startInorder]);
        }
        else
        {
            TreeNode root=new TreeNode(preorder[startPreorder]);
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
            root.left=buildTree(inorder, startInorder, middle-1, preorder, startPreorder+1, middle-startInorder+startPreorder);
            root.right=buildTree(inorder, middle+1, endInorder, preorder, middle+1-startInorder+startPreorder, endPreorder);
            return root;
        }
    }
}
