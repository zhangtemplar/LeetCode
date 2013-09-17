package Solution;

public class PathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root==null)
        {
            return false;
        }
        sum=sum-root.val;
        if (root.left==null && root.right==null)
        {
            if (sum==0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        if (hasPathSum(root.left, sum))
        {
            return true;
        }
        else if(hasPathSum(root.right, sum))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
