package trial3;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isBalanced(TreeNode root) {
        int[] result=isBalanced(root, 1);
        return result[0]==0;
    }
    
    /**
     * compute the balance information of the two trees
     * output
     *  [0] whether the tree is balanced (0) or not
     *  [1] the max depth of the tree
     */
    public int[] isBalanced(TreeNode root, int level)
    {
        int[]result=new int[2];
        if (root==null)
        {
            return result;
        }
        else if(root.left==null && root.right==null)
        {
            result[1]=level;
            return result;
        }
        else
        {
            // check left tree
            int []left={0,level};
            if (root.left!=null)
            {
                left=isBalanced(root.left, level+1);
            }
            // left tree is not balanced
            if (left[0]!=0)
            {
                return left;
            }
            
            // check right tree
            int []right={0,level};
            if (root.right!=null)
            {
                right=isBalanced(root.right, level+1);
            }
            // right tree is not balanced
            if (right[0]!=0)
            {
                return right;
            }
            
            // merge the result
            // currently left tree and right tree are balanced
            if (left[1]>right[1]+1 || left[1]<right[1]-1)
            {
                result[0]=1;
            }
            else
            {
                result[0]=0;
                result[1]=Math.max(left[1], right[1]);
            }
            return result;
        }
    }
}
