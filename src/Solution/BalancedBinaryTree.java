package Solution;

public class BalancedBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we will use DFS to obtain the height
        return getHeight(root)>=0;
    }
    
    // -1, if the subtree is not balanced
    // otherwise, return the height of the subtree
    public int getHeight(TreeNode root)
    {
        if (root==null)
        {
            return 0;
        }
        if (root.left==null && root.right==null)
        {
            return 1;
        }
        int left=getHeight(root.left);
        if (left<0)
        {
            return -1;
        }
        int right=getHeight(root.right);
        if (right<0)
        {
            return -1;
        }
        if (left>right+1 || left+1<right)
        {
            return -1;
        }
        else
        {
            return (left>right?left:right)+1;
        }
    }
}
