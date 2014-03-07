package trial3;

import java.util.HashMap;

public class BinaryTreeMaximumPathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
     * there are two types of path
     *  1) monotonic one, e.g., 1 to 2;
     *  2) others, e.g., 1 to 3
     * So our algorithm includes two steps:
     *  1) compute the max sum for montonic paths ending at each node
     *  2) check the max sum paths given the resuls of first
     */
    public int maxPathSum(TreeNode root) {
        HashMap<TreeNode, Integer> sum=new HashMap<TreeNode, Integer>();
        maxPathSumSingle(root, sum);
        return maxPathSum(root, sum);
    }
    
    public int maxPathSumSingle(TreeNode root, HashMap<TreeNode, Integer> sum)
    {
        if (root==null)
        {
            return 0;
        }
        else if (root.left==null && root.right==null)
        {
            sum.put(root, root.val);
            return root.val;
        }
        else
        {
            int left=0;
            if (root.left!=null)
            {
                left=maxPathSumSingle(root.left, sum);
            }
            int right=0;
            if (root.right!=null)
            {
                right=maxPathSumSingle(root.right, sum);
            }
            int result=Math.max(left, right);
            if (result<0)
            {
                result=0;
            }
            result+=root.val;
            sum.put(root, result);
            return result;
        }
    }
    
    public int maxPathSum(TreeNode root, HashMap<TreeNode, Integer> sum)
    {
        if (root==null)
        {
            return Integer.MIN_VALUE;
        }
        else if (root.left==null && root.right==null)
        {
            return root.val;
        }
        else
        {
            // the max sum in the two child trees
            long left=Integer.MIN_VALUE;
            long x=Integer.MIN_VALUE;
            if (root.left!=null)
            {
                left=maxPathSum(root.left, sum);
                x=sum.get(root.left);
            }
            long right=Integer.MIN_VALUE;
            long y=Integer.MIN_VALUE;
            if (root.right!=null)
            {
                right=maxPathSum(root.right, sum);
                y=sum.get(root.right);
            }
            
            // check wether we can build a better one by utilizing the root node
            long result=Math.max(left, right);
            if (result<root.val+x)
            {
                result=root.val+x;
            }
            if (result<root.val+y)
            {
                result=root.val+y;
            }
            if (result<root.val+x+y)
            {
                result=root.val+x+y;
            }
            if (result<root.val)
            {
                result=root.val;
            }
            return (int) result;
        }
    }
}
