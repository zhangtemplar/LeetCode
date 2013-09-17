package Solution;

public class SameTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we can use recursion
        if (p==null)
        {
            if (q==null)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else if (q==null)
        {
            return false;
        }
        else if (q.val!=p.val)
        {
            return false;
        }
        else
        {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
