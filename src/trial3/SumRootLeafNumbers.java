package trial3;

public class SumRootLeafNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int sumNumbers(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // sounds like a recursion
        if (root==null)
        {
            return 0;
        }
        return sumNumbers(root, 0);
    }
    
    /**
     * this function computes the sum root
     * base: the number at the current root
     * output: the sum of root
     */
    private int sumNumbers(TreeNode root, int base)
    {
        if (root==null)
        {
            return 0;
        }
        int sum=0;
        int val=base*10+root.val;
        if (root.left==null && root.right==null)
        {
            return val;
        }
        if (root.left!=null)
        {
            sum+=sumNumbers(root.left, val);
        }
        if (root.right!=null)
        {
            sum+=sumNumbers(root.right, val);
        }
        return sum;
    }
}
