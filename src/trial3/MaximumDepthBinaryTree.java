package trial3;

public class MaximumDepthBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int maxDepth(TreeNode root) {
        return maxDepth(root, 1);
    }
    
    /**
     * level: the depth of root
     * upper: the minimal depth already known
     */
    public int maxDepth(TreeNode root, int level) {
        if (root==null)
        {
            return 0;
        }
        else if (root.left==null && root.right==null)
        {
            return level;
        }
        else
        {
            int left=level;
            if (root.left!=null)
            {
                left=maxDepth(root.left, level+1);
            }
            
            int right=level;
            if (root.right!=null)
            {
                right=maxDepth(root.right, level+1);
            }
            
            int result=Math.max(left, right);
            return result;
        }
    }
}
