package trial3;

public class PathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null)
        {
            return false;
        }
        else if (root.left==null && root.right==null)
        {
            return sum==root.val;
        }
        else
        {
            sum=sum-root.val;
            if (root.left!=null && hasPathSum(root.left, sum))
            {
                return true;
            }
            
            if (root.right!=null && hasPathSum(root.right, sum))
            {
                return true;
            }
            
            return false;
        }
    }
}
