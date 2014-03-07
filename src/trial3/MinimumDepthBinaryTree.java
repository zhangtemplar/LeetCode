package trial3;

public class MinimumDepthBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int minDepth(TreeNode root) {
        return minDepth(root, 1, -1);
    }
    
    /**
     * level: the depth of root
     * upper: the minimal depth already known
     */
    public int minDepth(TreeNode root, int level, int upper) {
        if (root==null)
        {
            return 0;
        }
        else if (root.left==null && root.right==null)
        {
            // find a leaf
            if (upper>0 && upper<level)
            {
                return upper;
            }
            else
            {
                return level;
            }
        }
        // this nonleaf node already has larger depth, not necessary to try
        else if(upper>0 && level>=upper)
        {
            return upper;
        }
        else
        {
            int left=Integer.MAX_VALUE;
            if (root.left!=null)
            {
                left=minDepth(root.left, level+1, upper);
            }
            
            int right=Integer.MAX_VALUE;
            if (root.right!=null)
            {
                right=minDepth(root.right, level+1, upper);
            }
            
            int result=Math.min(left, right);
            if (upper>0 && upper<result)
            {
                return upper;
            }
            else
            {
                return result;
            }
        }
    }
}
